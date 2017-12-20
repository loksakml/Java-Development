package com.loska;

import static com.loska.ThreadColour.ANSI_BLUE;

public class AnotherThread extends Thread {

    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "Hello from the other thread. ");
    }
}
