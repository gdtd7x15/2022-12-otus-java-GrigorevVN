package ru.grigorevvn.listener;

import ru.grigorevvn.model.Message;

public interface Listener {

    void onUpdated(Message msg);
}
