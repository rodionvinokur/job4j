package ru.job4j.netbot.server;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.netbot.dict.IDict;

import java.io.*;
import java.net.Socket;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Created by slevi on 28.04.2019.
 */
public class SequenceServerTest {
    Socket socket;
    IDict dict;

    @Before
    public void setUp() {
        socket = mock(Socket.class);
        dict = mock(IDict.class);

    }

    @Test
    public void whenHelloAndByeThen() throws IOException {
        InputStream is = new ByteArrayInputStream("bye!".getBytes());
        OutputStream os = new ByteArrayOutputStream();
        when(socket.getInputStream()).thenReturn(is);
        when(socket.getOutputStream()).thenReturn(os);
        when(dict.readRandomLine()).thenReturn("bye!");
        SequenceServer ss = new SequenceServer(socket, dict);
        ss.run();
        assertEquals(new StringBuilder("Bot>  Hello!")
                .append(System.lineSeparator())
                .append(System.lineSeparator())
                .append("Bot>  Bye!")
                .append(System.lineSeparator())
                .append(System.lineSeparator())
                .toString(), os.toString());
    }

    @Test
    public void whenHelloAndExitThen() throws IOException {
        InputStream is = new ByteArrayInputStream("exit".getBytes());
        OutputStream os = new ByteArrayOutputStream();
        when(socket.getInputStream()).thenReturn(is);
        when(socket.getOutputStream()).thenReturn(os);
        when(dict.readRandomLine()).thenReturn("bye!");
        SequenceServer ss = new SequenceServer(socket, dict);
        ss.run();
        assertEquals(new StringBuilder("Bot>  Hello!")
                .append(System.lineSeparator())
                .append(System.lineSeparator())
                .append("Bot>  Bye!")
                .append(System.lineSeparator())
                .append(System.lineSeparator())
                .toString(), os.toString());
    }

    @Test
    public void whenHelloAndHelloAndByeThen() throws IOException {
        InputStream is = new ByteArrayInputStream(new StringBuilder("Good morning!")
                .append(System.lineSeparator())
                .append("Bot>  Bye!")
                .append(System.lineSeparator()).toString().getBytes());
        OutputStream os = new ByteArrayOutputStream();
        when(socket.getInputStream()).thenReturn(is);
        when(socket.getOutputStream()).thenReturn(os);
        when(dict.readRandomLine()).thenReturn("Good").thenReturn("bye!");
        SequenceServer ss = new SequenceServer(socket, dict);
        ss.run();
        assertEquals(new StringBuilder("Bot>  Hello!")
                .append(System.lineSeparator())
                .append(System.lineSeparator())
                .append("Bot>  Good")
                .append(System.lineSeparator())
                .append(System.lineSeparator())
                .append("Bot>  bye!")
                .append(System.lineSeparator())
                .append(System.lineSeparator())
                .toString(), os.toString());
    }

}