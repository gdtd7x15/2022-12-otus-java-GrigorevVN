package ru.grigorevvn.listener;

import ru.grigorevvn.model.Message;

public class ListenerPrinterConsole implements Listener {

    @Override
    public void onUpdated(Message msg) {
        var logString = String.format("msg:%s", msg);
        System.out.println(logString);
    }
}
