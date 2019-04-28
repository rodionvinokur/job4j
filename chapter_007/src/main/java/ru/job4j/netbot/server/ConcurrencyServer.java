package ru.job4j.netbot.server;

import ru.job4j.netbot.dict.Dictionary;
import ru.job4j.netbot.dict.IDict;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.file.Paths;
import java.util.concurrent.*;

/**
 * ConcurrencyServer
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class ConcurrencyServer {
    private final int port;
    private final IDict dictionary;
    private final ServerSocket serverSocket;
    private static volatile boolean exit = false;

    public static void setExit(boolean ex) {
        exit = ex;
    }

    public static boolean isExit() {
        return exit;
    }

    public ConcurrencyServer(int port, String path) throws IOException {
        this.port = port;
        this.dictionary = new Dictionary(Paths.get(path));
        this.serverSocket = new ServerSocket(port);
        this.serverSocket.setSoTimeout(2000);
    }

    public void init() {
        try {
            run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void run() throws IOException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        while (!exit) {
            Socket socket = null;
            System.out.println("Waiting client connection on port: " + port);
            try {
                socket = serverSocket.accept();
                Future<?> f = es.submit(new Session(socket, dictionary, Thread.currentThread())::run);
            } catch (SocketTimeoutException ignore) {
                ignore.getMessage();
            } catch (Exception e) {
                if (socket != null) {
                    socket.close();
                }
                throw new RuntimeException(e.getMessage());
            }
        }
        es.shutdown();
    }
}


