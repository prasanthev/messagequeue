package com.roy.messageque.source;

import java.util.concurrent.BlockingQueue;
import java.util.logging.Logger;

public class MessageSenderA implements Runnable {
    private BlockingQueue queue;
    private static final Logger LOGGER = Logger.getLogger(MessageSenderA.class.getName());

    public MessageSenderA(BlockingQueue queue) {
        this.queue=queue;
    }

    @Override
    public void run(){
        for(int i=1;i<100;i++) {

            try {
                Thread.sleep(1000);
                queue.put(" This is from source A " + i);
            } catch (InterruptedException e) {
                LOGGER.severe(e.getMessage());
            }

        }
    }
}
