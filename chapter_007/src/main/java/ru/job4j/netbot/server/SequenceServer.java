package ru.job4j.netbot.server;

import ru.job4j.netbot.dict.IDict;

import java.io.IOException;
import java.net.Socket;


/**
 * SequenceServer
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class SequenceServer {
    final private Socket socket;
    final private IDict dictionary;

    public SequenceServer(Socket socket, IDict dictionary) {
        this.socket = socket;
        this.dictionary = dictionary;
    }

    public void run() throws IOException {
        try {
            new Session(socket, dictionary, Thread.currentThread()).run();
        } catch (Exception e) {
            if (this.socket != null) {
                this.socket.close();
            }
            throw new RuntimeException(e.getMessage());
        }
    }
}
