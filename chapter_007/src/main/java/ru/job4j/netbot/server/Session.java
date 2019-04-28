package ru.job4j.netbot.server;

import ru.job4j.netbot.dict.IDict;

import java.io.*;
import java.net.Socket;

import static ru.job4j.netbot.app.App.BOT_BYE;

/**
 * Session
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Session {
    private final Socket socket;
    private final IDict dictionary;
    private final Thread main;

    public Session(Socket socket, IDict dictionary, Thread main) {
        this.socket = socket;
        this.dictionary = dictionary;
        this.main = main;
    }

    public void run() {
        System.out.println("Waiting client connection on port: " + socket.getLocalPort());
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader br = new BufferedReader((new InputStreamReader(socket.getInputStream())))
        ) {
            System.out.println("Client connected on port: " + socket.getLocalPort());
            String line = "Hello!";
            String prefix = "Bot>  ";
            while (true) {
                line = prefix + line;
                bw.write(line);
                bw.newLine();
                bw.newLine();
                bw.flush();
                if (BOT_BYE.equals(line.toLowerCase())) {
                    break;
                }
                line = br.readLine();
                line = getResponse(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String getResponse(String line) {
        if (line.trim().toLowerCase().startsWith("bye")) {
            return "Bye!";
        }

        if (line.trim().toLowerCase().startsWith("exit")) {
            ConcurrencyServer.setExit(true);
            return "Bye!";
        }
        return dictionary.readRandomLine();
    }
}
