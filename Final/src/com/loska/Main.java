package com.loska;

public class Main {

    public static void main(String[] args) {
        SomeClass one = new SomeClass("one");
        SomeClass two = new SomeClass("two");
        SomeClass three = new SomeClass("three");

        System.out.println(one.getInstanceNumber());
        System.out.println(two.getInstanceNumber());
        System.out.println(three.getInstanceNumber());

        int pw =674602;
        Password password = new Password(pw);
        password.storePassword();

        password.letMeIn(1);
        password.letMeIn(674602);a

    }
}
