package ru.grigorevvn.service;

import ru.grigorevvn.model.Message;
import ru.grigorevvn.model.ObjectForMessage;

import java.util.ArrayList;
import java.util.List;

public class MessageService {
    public Message copy(Message msg) {
        return msg.toBuilder()
                .field13(copyObjectForMessage(msg.getField13()))
                .build();
    }

    private ObjectForMessage copyObjectForMessage(ObjectForMessage ofm) {
        List<String> dataCopy = new ArrayList<>(ofm.getData());
        ObjectForMessage ofmCopy = new ObjectForMessage();
        ofmCopy.setData(dataCopy);
        return ofmCopy;
    }
}
