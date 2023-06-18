package ru.otus.processor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.grigorevvn.model.Message;
import ru.grigorevvn.processor.homework.ProcessorThrowException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProcessorThrowExceptionTest {

    @Test
    @DisplayName("ProcessorThrowException выбрасывает исключение если DateTimeProvider вернул четную секунду")
    void EvenSecTest(){
        var processor = new ProcessorThrowException(()-> 0);
        var plug = new Message.Builder(Long.MAX_VALUE).build();
        assertThrows(RuntimeException.class, () -> processor.process(plug));
    }

    @Test
    @DisplayName("ProcessorThrowException не выбрасывает исключение т.к. DateTimeProvider вернул нечетную секунду")
    void oddSecTest() {
        var processor = new ProcessorThrowException(() ->1);
        var plug = new Message.Builder(Long.MAX_VALUE).build();
        assertDoesNotThrow(() -> processor.process(plug));
    }

}