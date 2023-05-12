package ru.grigorevvn.homework;


import java.util.*;

public class CustomerService {
    private final TreeMap<Customer, String> customerMap;
    private static final Comparator<Customer> customerScoreComparator = (c1, c2) -> Long.compareUnsigned(c1.getScores(), c2.getScores());

    public CustomerService() {
        customerMap = new TreeMap<>(customerScoreComparator);
    }

    public Map.Entry<Customer, String> getSmallest() {
        Map.Entry<Customer, String> result = customerMap.entrySet().stream()
                .findFirst().orElse(null);
        return getProxyEntry(result);
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        for (Iterator<Map.Entry<Customer, String>> iterator = customerMap.entrySet().iterator(); iterator.hasNext();) {
            Map.Entry<Customer, String> entry = iterator.next();
            if (entry.getKey().getScores() > customer.getScores()) {
                return getProxyEntry(entry);
            }
        }
        return null; // это "заглушка, чтобы скомилировать"
    }

    public void add(Customer customer, String data) {
        customerMap.put(customer, data);
    }

    private Map.Entry<Customer, String> getProxyEntry (Map.Entry<Customer, String> entry) {
        if (entry != null) {
            Customer customer = new Customer(entry.getKey().getId(), entry.getKey().getName(), entry.getKey().getScores());
            return Map.entry(customer, entry.getValue());
        }
        return null;
    }
}
