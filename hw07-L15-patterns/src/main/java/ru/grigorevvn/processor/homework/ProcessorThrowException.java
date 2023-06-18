package ru.grigorevvn.processor.homework;

import ru.grigorevvn.model.Message;
import ru.grigorevvn.processor.Processor;

public class ProcessorThrowException implements Processor {
    private final DateTimeProvider provider;

    public ProcessorThrowException(DateTimeProvider dateTimeProvider) {
        this.provider = dateTimeProvider;
    }

    @Override
    public Message process(Message message) {
        int currentSecond = provider.getSecond();
        if(currentSecond % 2 == 0) {
            throw new RuntimeException(String.format("oops second is even: %s", currentSecond));
        }
        return message;
    }
}
