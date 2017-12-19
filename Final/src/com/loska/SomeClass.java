package com.loska;

public class SomeClass {

    private static int classCounter = 0;
    public final int instanceNumber; //final field cannot be change one a value is assigned. This is different from constance, which is usually declared as static final
    private final String name;

    public SomeClass(String name) {
        this.name = name;
        classCounter++;
        instanceNumber = classCounter;
        System.out.println(name + " created, instance is " + instanceNumber);
    }

    public int getInstanceNumber() {
        return instanceNumber;
    }
}aaa

//also by marking a class as final, it prevent the class being subclassed aa
aa