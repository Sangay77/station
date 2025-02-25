package com.sangay.ecom.learning.functional;

import java.util.function.Consumer;

class Person{

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class ConsumerDemo {
    public static void main(String[] args) {

        Person person=new Person();
        Consumer<Person> consumer=t->t.setName("sangay");
        consumer.accept(person);
        System.out.println(person.getName());

    }
}
