package ru.grigorevvn.model;

import java.util.Collections;
import java.util.List;

public class ObjectForMessage {
    private List<String> data;

    public List<String> getData() {
        return data != null ? data : Collections.emptyList();
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
