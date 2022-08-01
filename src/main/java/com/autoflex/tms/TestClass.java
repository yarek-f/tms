package com.autoflex.tms;

import java.util.Comparator;
import java.util.TreeSet;

public class TestClass {
    public static void main(String[] args) {
        Person person1 = new Person(12);
        Person person2 = new Person(35);

        TreeSet<Person> t = new TreeSet<>(new PersonCompare());
        t.add(person1);
        t.add(person2);

//        System.out.println(person1.compareTo(person2));
    }

    public static class Person  {
        int age;

        public Person(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

//        @Override
//        public int compareTo(Person o) {
//            if (this.age == o.age)
//                return 0;
//            else return this.age < o.age ? -1 : 1;
//        }
    }

    public static class PersonCompare implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            if (o1.age == o2.age) {
                return 0;
            } else if (o1.age < o2.age) {
                return -1;
            } else {
                return 1;
            }

        }
    }
}




