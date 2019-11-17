package com.roy.messageque.source;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;

public class MessageSenderA implements Runnable {
    private BlockingQueue queue;
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageSenderA.class);

    public MessageSenderA(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {

            try {
                Thread.sleep(1000);
                queue.put(" This is from source A " + i);
            } catch (InterruptedException e) {
                LOGGER.error(e.getMessage());
            }

        }
    }
}
