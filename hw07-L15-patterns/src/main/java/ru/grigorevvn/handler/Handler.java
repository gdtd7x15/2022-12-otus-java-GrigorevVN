package ru.grigorevvn.handler;

import ru.grigorevvn.listener.Listener;
import ru.grigorevvn.model.Message;

public interface Handler {
    Message handle(Message msg);

    void addListener(Listener listener);
    void removeListener(Listener listener);
}
