package test;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by slgu1 on 10/17/15.
 */
abstract class Animal implements Comparator <Animal>{

    Animal(String name) {
        this.name = name;
    }
    @Override
    public int compare(Animal o1, Animal o2) {
        if (o1.order < o2.order)
            return -1;
        if (o1.order == o2.order)
            return 0;
        if (o1.order > o2.order)
            return 1;
        return 0;
    }

    abstract public String toString();

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    protected int order;
    protected String name;
}

class Cat extends Animal {
    Cat(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return String.format("cat %s %d", name, order);
    }
}

class Dog extends Animal{
    Dog(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return String.format("dog %s %d", name, order);
    }
}

class TwoStack {

    void push(Animal animal) {
        animal.setOrder(order);
        if (animal instanceof  Dog) {
            dogList.add((Dog)animal);
            ++order;
        }
        else if (animal instanceof Cat) {
            catList.add((Cat)animal);
            ++order;
        }
        else {
            System.out.println("wrong type animal");
        }
    }

    Animal peek() {
        if (dogList.size() == 0 && catList.size() == 0) {
            return null;
        }
        if (dogList.size() == 0) {
            return catList.peek();
        }
        if (catList.size() == 0) {
            return dogList.peek();
        }
        Dog dog = dogList.peek();
        Cat cat = catList.peek();
        if(dog.compare(dog,cat) <= 0)
            return dog;
        else
            return cat;
    }
    Animal pop() {
        if (dogList.size() == 0 && catList.size() == 0) {
            return null;
        }
        if (dogList.size() == 0) {
            return catList.poll();
        }
        if (catList.size() == 0) {
            return dogList.poll();
        }
        Dog dog = dogList.peek();
        Cat cat = catList.peek();
        if(dog.compare(dog,cat) <= 0)
            return dogList.poll();
        else
            return catList.poll();
    }
    boolean isEmpty() {
        return dogList.isEmpty() && catList.isEmpty();
    }
    private int order = 0;
    private Queue <Dog> dogList = new LinkedList<Dog>();
    private Queue <Cat> catList = new LinkedList<Cat>();
}

public class Test5 {
    public static void main(String [] args) {
        TwoStack st = new TwoStack();
        for (int i = 0; i < 10; ++i) {
            if ((i % 2) == 0) {
                st.push(new Cat(String.format("%.2f",Math.random())));
            }
            else {
                st.push(new Dog(String.format("%.2f",Math.random())));
            }
        }
        while (!st.isEmpty()) {
            System.out.println(st.pop());
        }
    }
}
