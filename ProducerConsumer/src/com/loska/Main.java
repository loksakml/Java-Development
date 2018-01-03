package com.loska;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.loska.Main.EOF;

public class Main {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<String>();
        MyProducer producer = new MyProducer(buffer, ThreadColour.ANSI_GREEN);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColour.ANSI_PURPLE);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColour.ANSI_CYAN);

        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();


    }
}


class MyProducer implements Runnable {
    private List<String> buffer;
    private String colour;

    public MyProducer(List<String> buffer, String colour) {
        this.buffer = buffer;
        this.colour = colour;
    }

    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2" ,"3", "4", "5"};

        for (String num: nums){
            try{
                System.out.println(colour + "Adding..." + num);
                buffer.add(num);

                Thread.sleep(random.nextInt(1000));
            } catch(InterruptedException e){
                System.out.println("Producer was interrupted");
            }

        }

        System.out.println(colour + "Adding EOF and and exiting...");
        buffer.add("EOF");
    }

}

class MyConsumer implements Runnable{
    private List<String> buffer;
    private String colour;

    public MyConsumer(List<String> buffer, String colour) {
        this.buffer = buffer;
        this.colour = colour;
    }

    public void run(){
        while (true) {
            if (buffer.isEmpty()){
                continue; //when the buffer has no products in it, customers will loop around and keep checking the buffer..until it is not empty. The continue key words will jump you out of the loop and start the while loop again  - ie: ignore all the codes that follow.
            }
            if(buffer.get(0).equals(EOF)){
                System.out.println(colour + "Exiting");
                break;
            } else {
                System.out.println(colour + "Removed " + buffer.remove(0));
            }


        }
    }
}