package ru.grigorevvn.homework;


import java.util.ArrayDeque;
import java.util.Deque;

public class CustomerReverseOrder {
    Deque<Customer>  queue;

    public CustomerReverseOrder() {
        this.queue = new ArrayDeque<>();
    }

    public void add(Customer customer) {
        queue.addLast(customer);
    }

    public Customer take() {
        return queue.removeLast();
    }
}
