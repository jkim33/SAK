//Team SAK -- Soojin Choi, Jason Kim
//APCS2 pd8
//HW#50 -- Run Run Run
//2018-05-18

import java.util.NoSuchElementException;

/* ALGO:
 * Adding: 
 * 1) The first element to be added goes to the MaxHeap
 * 2) For every element that is added afterward, check if the value is less than the root of the MaxHeap. 
 *   a) If it is, add that element to the MaxHeap.
 *   b) If it is not, add that element to the MinHeap.
 * 3) Check if the size difference of the 2 Heaps is within 1. Any greater, and we must balance them.
 *   a) In order to balance them, we must remove from the bigger Heap and add that to the smaller Heap.
 *   b) We do this until the 2 Heaps have a size difference within 1.
 * 
 * Median:
 * 1) If the size of both Heaps is equal to 0, throw an excpetion.
 * 2) If the 2 Heaps have different sizes, return the root of the larger Heap.
 * 3) If the 2 Heaps are equal in size, return the average of the 2 roots.
 */

public class RunMed {

    //instance variable
    ALHeapMin bigVals; 
    ALHeapMax lilVals;

    //constructor
    public RunMed(){
	bigVals = new ALHeapMin(); //initialize
	lilVals = new ALHeapMax(); //initialize
    }

    //methods
    public Integer getMedian(){

	//No elements
	if (lilVals.isEmpty() && bigVals.isEmpty()){ //if both are empty
	    throw new NoSuchElementException();      //throw an exception
	}
	
	//Odd number of elements
	if (bigVals.size > lilVals.size){            //Check which Heap is larger
	    return bigVals.peekMin();                //return the root of the larger Heap
	}
	else if (lilVals.size > bigVals.size){
	    return lilVals.peekMax();
	}

	//Even number of elements
	else{
	    Integer bigMed = bigVals.peekMin();      //min val of the big nums
	    Integer lilMed = lilVals.peekMax();      //max val of the lil nums
	    return new Integer ((bigMed.intValue() + lilMed.intValue()) / 2);
	}
    }//O(1)

    public void add(Integer newVal){
	if (lilVals.isEmpty()){                     //If it's the first element
	    lilVals.add(newVal);                    //Just add it to index 0
	}

	else if (newVal > lilVals.peekMax()){       //Compare newVal with root of MaxHeap
	    bigVals.add(newVal);                    //If newVal is larger
	}                                           //add to the MinHeap
	else {
	    lilVals.add(newVal);                    //otherwise, add to MaxHeap
	}

	int sizeDif = lilVals.size - bigVals.size; //get the size difference
	while (sizeDif > 1 || sizeDif < -1){       //if it's not within 1
	    if(sizeDif > 1 ){                      //remove from larger, add to smaller
		bigVals.add(lilVals.removeMax());
	    }
	    else{
		lilVals.add(bigVals.removeMin());
	    }
	    sizeDif = lilVals.size - bigVals.size;
	}
    }//O(logn)

}
