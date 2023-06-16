package ru.grigorevvn.processor;

import ru.grigorevvn.model.Message;

public interface Processor {

    Message process(Message message);
}
