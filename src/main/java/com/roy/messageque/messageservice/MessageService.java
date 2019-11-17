package com.roy.messageque.messageservice;

import com.roy.messageque.consumer.MessageReceiver;
import com.roy.messageque.source.MessageSenderA;
import com.roy.messageque.source.MessageSenderB;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Logger;

public class MessageService {
    private static final Logger LOGGER = Logger.getLogger(MessageService.class.getName());

    public static void main(String[] args) {
        BlockingQueue queue = new LinkedBlockingQueue();
        MessageSenderA senderA = new MessageSenderA(queue);
        MessageSenderB senderB = new MessageSenderB(queue);
        MessageReceiver receiver = new MessageReceiver(queue);
        new Thread(senderA).start();
        new Thread(receiver).start();
        new Thread(senderB).start();
        LOGGER.info("Sender and Receiver has been Started");
    }
}
