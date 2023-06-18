package ru.grigorevvn.listener.homework;

import ru.grigorevvn.model.Message;

import java.util.Optional;

public interface HistoryReader {

    Optional<Message> findMessageById(long id);
}
