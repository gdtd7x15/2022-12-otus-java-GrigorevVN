package ru.grigorevvn.listener.homework;

import ru.grigorevvn.listener.Listener;
import ru.grigorevvn.model.Message;
import ru.grigorevvn.service.MessageService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class HistoryListener implements Listener, HistoryReader {
    private MessageService messageService;
    private Map<Long,Message> history;

    public HistoryListener() {
        this.messageService = new MessageService();
        this.history = new HashMap<>();
    }

    @Override
    public void onUpdated(Message msg) {
        history.put(msg.getId(), messageService.copy(msg));
    }

    @Override
    public Optional<Message> findMessageById(long id) {
        return history.entrySet().stream()
                .filter(entry -> entry.getKey().equals(id))
                .findFirst()
                .map(Map.Entry::getValue);
    }
}
