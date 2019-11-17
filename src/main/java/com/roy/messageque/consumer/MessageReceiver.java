package com.roy.messageque.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;

public class MessageReceiver implements Runnable {
    private BlockingQueue queue;
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageReceiver.class);

    public MessageReceiver(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(10);
                LOGGER.info(queue.take().toString());
            }
        } catch (InterruptedException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
