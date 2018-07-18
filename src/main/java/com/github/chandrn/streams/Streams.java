package com.github.chandrn.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Streams {

    public static void main(String[] args) {
        final Person will = new Person("Will", 25, Gender.MALE);
        final Person jane = new Person("Jane", 35, Gender.FEMALE);
        final Person bob = new Person("Bob", 45, Gender.MALE);

        final List<Person> people = new ArrayList<Person>();
        people.add(will);people.add(jane);people.add(bob);

        final Predicate<Person> lessThanForty = (p) -> p.age < 40;

        people.stream()
                .parallel()
                .filter(lessThanForty)
                .forEach(p -> System.out.println(p));

    }
}

