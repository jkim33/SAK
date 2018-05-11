//Jason Kim
//APCS2 pd8
//HW#46 -- Arrr, There Be Priorities Here Matey
//2018-05-09

import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue {

    private ArrayList<String> data; //holds all the strings
    private int size; //stores size

    public ArrayPriorityQueue() {
	data = new ArrayList<String>(); //initialize
	size = 0;
    }

    public void add(String str) {
	data.add(str); //use the arraylist method
	size++; //increase size
    }

    public boolean isEmpty() {
	return (size == 0); //simply check
    }

    public String peekMin() {
	if (isEmpty()) { //if empty, don't run the main body
	    throw new RuntimeException();
	}
	String min = data.get(0); //stores the minimum string
	for (String s: data) { //as we go through the data
	    if (s.compareTo(min) < 0) { //compare the min and current string
		min = s; //record whenever we see a smaller string
	    }
	}
	return min; //return
    }

    public String removeMin() {
	if (isEmpty()) { //don't run if empty
	    throw new RuntimeException(); 
	}
	String min = data.get(0); //stores the minimum string
	int index = 0; //stores the index to remove from
	int curr = 0; //for ease
	for (String s: data) { //as we go through the data
	    if (s.compareTo(min) < 0) { //compare the min and current string
		min = s; //record whenever we see a smaller string
		index = curr; //update index 
	    }
	    curr++; //update curr
	}
	size--; //decrease size
	data.remove(index); //remove
	return min; //return
    }

    public String toString() {
	String ret = "";
	for (String s: data) {
	    ret = ret + s + " ";
	}
	return ret;
    }

    public static void main (String[]args) {
	ArrayPriorityQueue test = new ArrayPriorityQueue();
	
	System.out.println("IsEmpty?: " + test.isEmpty());
	test.add("foo"); //3
	test.add("doo"); //2
	test.add("coo"); //1 (min)
	test.add("goo"); //4
	test.add("zoo"); //5
	System.out.println(test);
	System.out.println("==========================");
	System.out.println(test.peekMin()); //coo
	System.out.println(test.removeMin());
	System.out.println(test);
	System.out.println("==========================");
	System.out.println(test.peekMin()); //doo
	System.out.println(test.removeMin());
	System.out.println(test);
	System.out.println("==========================");
	System.out.println(test.peekMin()); //foo
	System.out.println(test.removeMin());
	System.out.println(test);
	System.out.println("==========================");
	System.out.println(test.peekMin()); //goo
	System.out.println(test.removeMin());
	System.out.println(test);
	System.out.println("==========================");
	System.out.println(test.peekMin()); //zoo
	System.out.println(test.removeMin());
	System.out.println(test);
    }
    
    
}
