package com.roy.messageque.source;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;

public class MessageSenderB implements Runnable {
    private BlockingQueue queue;
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageSenderB.class);

    public MessageSenderB(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                Thread.sleep(1000);
                queue.put("This is from Source B message " + i);
            }
        } catch (InterruptedException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
