package com.example.springboot;

import org.springframework.stereotype.Component;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.newScheduledThreadPool;

@Component
public class AppCounter {
    private int counter = 1;
    ScheduledExecutorService scheduler = newScheduledThreadPool(1);

    public AppCounter() {
        run();
    }

    public void run() {
        int intervalInSeconds = 1;

        scheduler.scheduleAtFixedRate(
                () -> {
                    System.out.println("Counter: " + counter);
                    counter++;
                }, 0, intervalInSeconds, TimeUnit.SECONDS);

    }
}
