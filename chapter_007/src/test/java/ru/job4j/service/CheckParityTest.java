package ru.job4j.service;


import org.junit.Test;

import java.io.*;


import static org.junit.Assert.*;

/**
 * CheckParityTest
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class CheckParityTest {

    @Test
    public void whenNumberIsIntegerAndJustOddThenFalse() throws Exception {
        int[] ints = {1, 3, 35, 7, 9, 11, 13, 15};
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             OutputStream bos = new BufferedOutputStream(baos);
             DataOutputStream dos = new DataOutputStream(bos);) {
            for (int i : ints) {
                dos.writeInt(i);
            }
            CheckParity checkParity = new CheckParity(new IntStrategy());
            DataInputStream dis = new DataInputStream(
                    new BufferedInputStream(
                            new ByteArrayInputStream(baos.toByteArray())
                    )
            );
            assertFalse(checkParity.isNumber(dis));
        }
    }

    @Test
    public void whenNumberIsIntegerAndHaveEvenThenTrue() throws Exception {
        int[] ints = {1, 3, 35, 7, 9, 12, 13, 15};
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             OutputStream bos = new BufferedOutputStream(baos);
             DataOutputStream dos = new DataOutputStream(bos);) {
            for (int i : ints) {
                dos.writeInt(i);
                dos.flush();
            }
            CheckParity checkParity = new CheckParity(new IntStrategy());
            DataInputStream dis = new DataInputStream(
                    new BufferedInputStream(
                            new ByteArrayInputStream(baos.toByteArray())
                    )
            );
            assertTrue(checkParity.isNumber(dis));
        }
    }

    @Test
    public void whenNumberIsLongAndHaveEvenThenTrue() throws Exception {
        long[] ints = {1, 3, 35, 7, 9, 111, 14, 15};
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             OutputStream bos = new BufferedOutputStream(baos);
             DataOutputStream dos = new DataOutputStream(bos);) {
            for (long i : ints) {
                dos.writeLong(i);
                dos.flush();
            }
            CheckParity checkParity = new CheckParity(new LongStrategy());
            DataInputStream dis = new DataInputStream(
                    new BufferedInputStream(
                            new ByteArrayInputStream(baos.toByteArray())
                    )
            );
            assertTrue(checkParity.isNumber(dis));
        }
    }

    @Test
    public void whenArrayEmtyThenFalse() throws Exception {
        long[] ints = {};
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             OutputStream bos = new BufferedOutputStream(baos);
             DataOutputStream dos = new DataOutputStream(bos);) {
            for (long i : ints) {
                dos.writeLong(i);
                dos.flush();
            }
            CheckParity checkParity = new CheckParity(new LongStrategy());
            DataInputStream dis = new DataInputStream(
                    new BufferedInputStream(
                            new ByteArrayInputStream(baos.toByteArray())
                    )
            );
            assertFalse(checkParity.isNumber(dis));
        }
    }
}