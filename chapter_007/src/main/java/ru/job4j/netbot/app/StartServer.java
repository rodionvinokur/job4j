package ru.job4j.netbot.app;

import ru.job4j.netbot.dict.Dictionary;
import ru.job4j.netbot.server.ConcurrencyServer;
import ru.job4j.netbot.server.SequenceServer;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.nio.file.Paths;

import static ru.job4j.netbot.app.App.PORT;

/**
 * Class StartServer
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class StartServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        //new ConcurrencyServer(PORT, "Dictionary" + File.separator + "dictionary.txt").init();
        String path = "Dictionary" + File.separator + "dictionary.txt";
        new SequenceServer(
                new ServerSocket(PORT).accept(),
                new Dictionary(Paths.get(path))
        ).run();
    }
}
