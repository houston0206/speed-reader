package edu.grinnell.csc207.mysteries;

class Counter1 {
    public int value;
    public void increment() {
        value += 1;
    }
}

class Counter2 {
    public int value;
    public void increment(int value) {
        value += value;
    }
}

class Counter3 {
    public int value;
    public void increment(int value) {
        this.value += value;
    }
}

class Counter4 {
    public int value;
    public void increment(int value) {
        value += this.value;
    }
}
  
public class Counters {
    public static void main(String[] args) {
        Counter2 two = new Counter2();
        two.increment(2);
        System.out.println(two.value);
        System.out.println("Hello World!");
    }
}
