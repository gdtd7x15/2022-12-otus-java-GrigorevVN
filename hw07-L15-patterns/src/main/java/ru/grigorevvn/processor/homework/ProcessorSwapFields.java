package ru.grigorevvn.processor.homework;

import ru.grigorevvn.model.Message;
import ru.grigorevvn.processor.Processor;

public class ProcessorSwapFields implements Processor {
    @Override
    public Message process(Message message) {
        return message.toBuilder()
                .field11(message.getField12())
                .field12(message.getField11())
                .build();
    }
}
