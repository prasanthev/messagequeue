package com.roy.messageque.source;

import java.util.concurrent.BlockingQueue;
import java.util.logging.Logger;

public class MessageSenderB implements Runnable {
    private BlockingQueue queue;
    private static final Logger LOGGER = Logger.getLogger(MessageSenderB.class.getName());

    public MessageSenderB(BlockingQueue queue) { this.queue = queue; }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                Thread.sleep(1000);
                queue.put("This is from Source B message " + i);
            }
        } catch (InterruptedException e) {
            LOGGER.severe(e.getMessage());
        }
    }
}
