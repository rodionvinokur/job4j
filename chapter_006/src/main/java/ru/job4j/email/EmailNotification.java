package ru.job4j.email;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * EmailNotification
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class EmailNotification {

    final private ExecutorService pool = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()
    );

    public void emailTo(User user) {
        String subject = "Notification {username} to email {email}."
                .replaceFirst("\\{username\\}", user.getName())
                .replaceFirst("\\{email\\}", user.getEmail());
        String body = "Add a new event to {username}"
                .replaceFirst("\\{username\\}", user.getName());
        Runnable doSend = () -> {
            send(subject, body, user.getEmail());
        };
        pool.submit(doSend);
    }

    public void close() {
        pool.shutdown();
        while (!pool.isTerminated()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void send(String subject, String body, String email) {
        System.out.println(subject + "\n" + body + "\n" + email + "\n");
    }
}
