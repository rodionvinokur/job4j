package ru.job4j.netbot.app;

import ru.job4j.netbot.client.Client;

import static ru.job4j.netbot.app.App.PORT;

/**
 * Class StartClient
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class StartClient {
    public static void main(String[] args) {
        Runnable client = (new Client(PORT))::run;
        new Thread(client, "Client on port = " + PORT).start();
    }
}
