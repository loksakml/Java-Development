package com.loska;

import static com.loska.ThreadColour.ANSI_GREEN;
import static com.loska.ThreadColour.ANSI_PURPLE;
import static com.loska.ThreadColour.ANSI_RED;

public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hello from the main thread.");
        Thread anotherThread = new AnotherThread();

        anotherThread.start();

        new Thread() {
            public void run() {
                System.out.println(ANSI_GREEN + "Hello from the anonymous class.");
            }
        }.start();

        System.out.println(ANSI_PURPLE + "Hello from the main thread again.");




    }
}
