package com.loska;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static com.loska.Main.EOF;

public class Main {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
       // List<String> buffer = new ArrayList<String>();
        // ReentrantLock bufferLock = new ReentrantLock();
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<String>(6);//this is not dynamic, so it doesnt grow

        ExecutorService executorService = Executors.newFixedThreadPool(5);//first you need a new threadPool
//        MyProducer producer = new MyProducer(buffer, ThreadColour.ANSI_GREEN, bufferLock);
//        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColour.ANSI_PURPLE, bufferLock);
//        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColour.ANSI_CYAN, bufferLock);

        MyProducer producer = new MyProducer(buffer, ThreadColour.ANSI_GREEN);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColour.ANSI_PURPLE);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColour.ANSI_CYAN);


        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        Future<String> future = executorService.submit(new Callable<String>(){
            @Override
            public String call() throws Exception {
                System.out.println(ThreadColour.ANSI_WHITE + "I'm being printed for the Callable class");
                return "This is the callable result.";
            }
        });
        try{
            System.out.println(future.get());

        } catch(ExecutionException e){
            System.out.println("Something went wrong");
        } catch(InterruptedException e){
            System.out.println("Thread running the tast was interrupted");

        }

        executorService.shutdown();

    }
}


class MyProducer implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String colour;
    //private ReentrantLock bufferLock;

    public MyProducer(ArrayBlockingQueue<String> buffer, String colour) {
        this.buffer = buffer;
        this.colour = colour;
        //this.bufferLock = bufferLock;
    }

    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2" ,"3", "4", "5"};

        for (String num: nums){
            try{
                System.out.println(colour + "Adding..." + num);
                buffer.put(num);
//                bufferLock.lock();
//                try {
//                    buffer.add(num);
//                } finally {
//                    bufferLock.unlock();
//                }



                Thread.sleep(random.nextInt(1000));
            } catch(InterruptedException e){
                System.out.println("Producer was interrupted");
            }

        }

        System.out.println(colour + "Adding EOF and and exiting...");
        try{
            buffer.put("EOF");
        } catch (InterruptedException e){

        }

//        bufferLock.lock();
//        try {
//            buffer.add("EOF");
//        } finally {
//            bufferLock.unlock();
//        }




    }

}

class MyConsumer implements Runnable{
    private ArrayBlockingQueue<String> buffer;
    private String colour;
   // private ReentrantLock bufferLock;

    public MyConsumer(ArrayBlockingQueue<String> buffer, String colour) {
        this.buffer = buffer;
        this.colour = colour;
        //this.bufferLock = bufferLock;
    }

    public void run(){

        //int counter = 0;

        while (true) {
            synchronized (buffer) {
                //if(bufferLock.tryLock()){
                try {
                    if (buffer.isEmpty()) {
                        continue; //when the buffer has no products in it, customers will loop around and keep checking the buffer..until it is not empty. The continue key words will jump you out of the loop and start the while loop again  - ie: ignore all the codes that follow.
                    }
                    //System.out.println(colour + "The counter = " + counter);

                    if (buffer.peek().equals(EOF)) {
                        System.out.println(colour + "Exiting");
                        break;
                    } else {
                        System.out.println(colour + "Removed " + buffer.take());
                    }
                } catch (InterruptedException e) {

                }

            }
//            } finally {
//                bufferLock.unlock();
//            }

//        } else {
//            counter ++;
//        }







        }
    }
}