package com.packageChallege;

public class Series {

    public static int nSum(int n){
        if(n>=0){
            int nSum = 0;
            for (int i = 0; i <=n ; i++) {
                nSum += i;
            }
            return nSum;
        } else {
            System.out.println("Input must be an integer greater or equal to zero.");
            return -1;
        }


    }

    public static int factorial(int n){
        if (n >= 1) {
            int factorial = 1;
            for (int i = 1; i <=n ; i++) {
                factorial *= i;
            }
            return factorial;
        } else {
            System.out.println("Input must be an integer greater than zero.");
            return -1;
        }

    }


    public static int fibonacci(int n){
        if (n == 0){
            return 0;
        } else if (n == 1){
            return 1;
        } else if (n>1){
            return fibonacci(n-1) + fibonacci(n-2);
        } else {
            System.out.println("Input must be an integer greater or equal to zero.");
            return -1;
        }
    }






}
