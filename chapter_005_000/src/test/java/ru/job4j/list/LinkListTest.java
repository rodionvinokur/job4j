package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * LinkListTest
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */
public class LinkListTest {
    private LinkList list;
    LinkList.Node<Integer> one;
    LinkList.Node<Integer> two;
    LinkList.Node<Integer> three;
    LinkList.Node<Integer> four;
    LinkList.Node<Integer> five;
    LinkList.Node<Integer> six;

    @Before
    public void setUp() {
        list = new LinkList();
        LinkList.Node<Integer> first = list.new Node<Integer>(1);
        LinkList.Node<Integer> two = list.new Node<Integer>(2);
        LinkList.Node<Integer> third = list.new Node<Integer>(3);
        LinkList.Node<Integer> four = list.new Node<Integer>(4);
    }

    @Test
    public void whenFirstNullThenCycleFalse() {
        one = null;
        assertFalse(list.hasCycle(one));
    }

    @Test
    public void whenSimpleFromAtoBtoTAhenCycleTrue() {
        one = list.new Node<Integer>(1);
        two = list.new Node<Integer>(2);
        three = list.new Node<Integer>(3);
        one.next = two;
        two.next = three;
        three.next = one;
        assertTrue(list.hasCycle(one));
    }

    @Test
    public void whenSimpleFromAtoBtoCtoNullThenCycleFalse() {
        one = list.new Node<Integer>(1);
        two = list.new Node<Integer>(2);
        three = list.new Node<Integer>(3);
        one.next = two;
        two.next = three;
        three.next = null;
        assertFalse(list.hasCycle(one));
    }

    @Test
    public void whenDeepCycleFromAtoBtoCtoDtoCThenCycleTrue() {
        one = list.new Node<Integer>(1);
        two = list.new Node<Integer>(2);
        three = list.new Node<Integer>(3);
        four = list.new Node<Integer>(4);
        five = list.new Node<Integer>(5);
        six = list.new Node<Integer>(6);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = three;
        six.next = null;
        assertTrue(list.hasCycle(one));
    }

}