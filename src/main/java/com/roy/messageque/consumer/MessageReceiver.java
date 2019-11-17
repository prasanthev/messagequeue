package com.roy.messageque.consumer;

import java.util.concurrent.BlockingQueue;
import java.util.logging.Logger;

public class MessageReceiver implements Runnable {
    private BlockingQueue queue;
    private static final Logger LOGGER = Logger.getLogger(MessageReceiver.class.getName());

    public MessageReceiver(BlockingQueue queue) {
        this.queue=queue;
    }

    @Override
    public void run() {
        try {
        while (true){
                Thread.sleep(10);
                LOGGER.info(queue.take().toString());
            }
        } catch (InterruptedException e) {
            LOGGER.severe(e.getMessage());
        }
    }
}
