// Soojin Choi
// APCS2 pd08
// HW46 -- Arrr, There Be Priorities Here Matey
// 2018-05-10
import java.util.ArrayList;
import java.lang.RuntimeException;
public class ArrayPriorityQueue implements PriorityQueue<String>{
	
	ArrayList<String> data;
	//Constructor
	public ArrayPriorityQueue(){
		data = new ArrayList<String>();
	}
	//Methods
	/* Adds a new value at the end of the ArrayList - the front of the 	   Queue 
	   Keeps order of Queue -- Runtime O(1) */
	public void add(String newVal){
		data.add(newVal);
	}
	/* Returns true if ArrayList has no elements */
	public boolean isEmpty(){
		return data.size() == 0;
	}
	/* Compares the data and returns the Min value of the Queue
	   Runtime -- O(n)*/
	public String peekMin(){
		String currMin = "";
		if (isEmpty()){
			throw new RuntimeException();
		}
		if(data.size() - 1 == 0){
			currMin = data.get(0);
		}
		for (int x = data.size()-1; x > 0 ; x--){
			int comparison = data.get(x).compareTo(data.get(x-1));
			System.out.println(comparison);
			if (comparison < 0){
				currMin = data.get(x);
			}
			else{
				currMin = data.get(x-1);
			}
		}
		return currMin;
	}
	/** Removes the Min of the Queue and returns the Min value of the 	    Queue
	  * Runtime -- O(n)*/
	public String removeMin(){
		if (isEmpty()){
			throw new RuntimeException();
		}
		String target = peekMin();
		for (int x = data.size()-1; x >= 0 ; x--){
			if (data.get(x) == target){
				data.remove(x);
				return target;
			}
		}
		return "Empty";
	}
	//ToString.. Return Queue front -> back. (ArrayList back -> front)
	public String toString(){
		String retVal = "";
		for (int x = data.size() - 1; x >= 0; x--){
			retVal += data.get(x) + " | ";
		}
		return retVal;
	}
	public static void main(String [] args){
		ArrayPriorityQueue compare = new ArrayPriorityQueue();
		/*compare.add("may");
		compare.add("of");
		compare.add("fifth");
		compare.add("the");
		compare.add("not");
		compare.add("is");
		compare.add("today");*/
		compare.add("a");
		compare.add("b");
		compare.add("d");
		compare.add("c");
		System.out.println("Original Queue" + compare);
		int counter = 5;
		while (counter > 1){
			System.out.println("Removing ... " + compare.peekMin());
			compare.removeMin();
			System.out.println("Current state after remove:" + compare);
			System.out.println("- - - - - - - - - - - - - - - - - - -");
			System.out.println();
			counter --;
		}
	}
}
