package com.github.chandrn.streams;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class SumAndAverage {

    public static void main(String[] args) throws IOException {
//        final Person will = new Person("Will", 25, Gender.MALE);
//        final Person jane = new Person("Jane", 35, Gender.FEMALE);
//        final Person bob = new Person("Bob", 45, Gender.MALE);

        final List<Person> people = PersonLoader.load();
//        people.add(will);
//        people.add(jane);
//        people.add(bob);

        final double sum = people.stream()
                .mapToDouble(p -> p.age)
                .sum();
        System.out.println("sum = " + sum);

        //another way to sum

        final Integer sum2 = people.stream()
                .collect(Collectors.summingInt(Person::getAge));
        System.out.println("sum2 = " + sum2);



        final OptionalDouble average = people.stream()
                .mapToDouble(p -> p.age)
                .average();

        System.out.println("average = " + average.getAsDouble());

        //Get all male names sorted by decreasing age

        final List<String> names = people.stream()
                .filter(p -> p.gender == Gender.MALE)
                .sorted(Comparator.comparing(Person::getAge).reversed())
                .map(Person::getName)
                .collect(Collectors.toList());

        //grouping by

        /*final Map<Integer, List<Person>> peopleByAge = people.stream()
                .collect(Collectors.groupingBy(Person::getAge));

        for (Integer age : peopleByAge.keySet()) {
            System.out.println(age + ":" +peopleByAge.get(age));
        }*/

        //joining

        final String namesString = people.stream()
                .map(Person::getName)
                .collect(Collectors.joining(","));

        System.out.println("namesString = " + namesString);

        //comparator
        final Optional<Person> person = people.stream()
                .collect(Collectors.minBy(Comparator.comparing(Person::getAge)));

        System.out.println("person = " + person);

        //partitioning

        final Map<Boolean, List<Person>> genders = people.stream()
                .collect(Collectors.partitioningBy(p -> p.gender == Gender.MALE));

        for (Boolean aBoolean : genders.keySet()) {
            System.out.println(aBoolean + ":" + genders.get(aBoolean));
        }

        //Summarizing
        final IntSummaryStatistics intSummaryStatistics = people.stream()
                .collect(Collectors.summarizingInt(Person::getAge));

        System.out.println("intSummaryStatistics = " + intSummaryStatistics);
    }
}
