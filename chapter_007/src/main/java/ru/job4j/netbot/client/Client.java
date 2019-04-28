package ru.job4j.netbot.client;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import static ru.job4j.netbot.app.App.BOT_BYE;

/**
 * Class Client
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class Client {
    private final int port;
    private final String ip;

    public Client(int port, String ip) {
        this.port = port;
        this.ip = ip;
    }

    public Client(int port) {
        this.port = port;
        this.ip = "127.0.0.1";
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String prefix = "User> ";
        Socket socket = new Socket(); //ip, port
        boolean stop = false;
        int countConnectionReTry = 3;
        while (!stop) {
            try {
                socket.connect(new InetSocketAddress(ip, port), 3000);
                stop = true;
            } catch (IOException e) {
                countConnectionReTry--;
                if (countConnectionReTry == 0) {
                    stop = true;
                }
            }
        }
        try (
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            while (true) {
                String line = "";
                StringBuilder sb = new StringBuilder();
                while (true) {
                    line = br.readLine();
                    if (line.equals("")) {
                        break;
                    }
                    sb.append(line);
                }
                line = sb.toString();
                System.out.println(line);
                if (BOT_BYE.equals(line.trim().toLowerCase())) {
                    break;
                }
                System.out.print(prefix);
                line = scanner.nextLine();
                bw.write(line);
                bw.newLine();
                bw.flush();
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
}
