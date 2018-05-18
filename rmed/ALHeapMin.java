/*****************************************************
 * class ALHeapMin
 * SKELETON
 * Implements a min heap using an ArrayList as underlying container
 *****************************************************/

import java.util.ArrayList;

public class ALHeapMin
{

    //instance vars
    private ArrayList<Integer> _heap; //contains an array of integers that can only result in one tree
    int size;

    /*****************************************************
     * default constructor  ---  inits empty heap
     *****************************************************/
    public ALHeapMin()
    {
	_heap = new ArrayList<Integer>(); //initialize
    }


    /*****************************************************
     * toString()  ---  overrides inherited method
     * Returns either
     * a) a level-order traversal of the tree (simple version)
     * b) ASCII representation of the tree (more complicated, more fun)
     * Implementation: Traverse through _heap and add it to the return String
     *****************************************************/
    public String toString()
    {
	String ret = "";     //initialize
	for (int i: _heap) { //for each integer
	    ret += i + " ";  //add it to ret
	}
	return ret;          //return
    }//O(n)


    /*****************************************************
     * boolean isEmpty()
     * Returns true if no meaningful elements in heap, false otherwise
     * Implementation: Use the ArrayList method size() to check
     *****************************************************/
    public boolean isEmpty()
    {
	return _heap.size() == 0;
    }//O(1)


    /*****************************************************
     * Integer peekMin()
     * Returns min value in heap
     * Postcondition: Heap remains unchanged.
     * Implementation: With _heap storing the level-order transversal, the first element is the lowest value
     *****************************************************/
    public Integer peekMin()
    {
	return _heap.get(0);
    }//O(1)


    /*****************************************************
     * add(Integer)
     * Inserts an element in the heap
     * Postcondition: Tree exhibits heap property.
     * Implementation:
     * 1) Insert addVal to the end of _heap
     * 2) While the Min Heap condition is not met, swap addVal with its parent
     * 3) Stop swapping once the Min Heap condition is met
     *****************************************************/
    public void add( Integer addVal )
    {
      size++;
        _heap.add(addVal);                                    //add addVal to the end of the ArrayList
	if (_heap.size() == 1) {                              //if it was the first element added
	    return;                                           //stop there
	}
	int index = _heap.size() - 1;                         //index keeps track of where addVal is
	while(index > 0 && addVal < _heap.get((index-1)/2)) { //while the condition is not met
	    swap(index, (index-1)/2);                         //swap addVal with its parent
	    index = (index-1)/2;                              //get the new index
	}
    }//O(logn)


    /*****************************************************
     * removeMin()  ---  means of removing an element from heap
     * Removes and returns least element in heap.
     * Postcondition: Tree maintains heap property.
     * Implementation:
     * 1) Swap the last element with the first (lowest)
     * 2) Remove the new last element
     * 3) With the new first element, keep swapping with children when necessary
     *****************************************************/
    public Integer removeMin()
    {
	if (isEmpty()) {                  //if empty
	    return null;                  //stop
	}
  size --;
	if (_heap.size() == 1) {          //if there is only one element
	    return _heap.remove(0);       //simply remove
	}

	Integer ret = peekMin();          //get the integer that will be removed
        swap(_heap.size()-1, 0);          //swap the first and last element of _heap
	_heap.remove(_heap.size()-1);     //remove the last element
	int index = 0;                    //stores the index of the element we must carry
	int possNew = minChildPos(index); //stores the index of the child that has the potential to swap

	//In this process, as long there is a child and it has a lower value than the parent, swap
	while(index*2+1 < _heap.size() && _heap.get(index) > _heap.get(possNew)) {
	    swap(index, possNew);
	    index = possNew;
	    possNew = minChildPos(index);
	}
	return ret;
    }//O(logn)


    /*****************************************************
     * minChildPos(int)  ---  helper fxn for removeMin()
     * Returns index of least child, or
     * -1 if no children, or if input pos is not in ArrayList
     * Postcondition: Tree unchanged
     * Implementation:
     * 1) Check is it's out of bounds. Calculate the index of the left and right child
     * 2) Check if it only has one child, return that child
     * 3) Check if it has 2 children, return the one with the lower value
     * 4) If all fails, return -1
     *****************************************************/
    private int minChildPos( int pos )
    {
	//pos is not in _heap
	if (pos >= _heap.size()) {                          //check if out of bounds
	    return -1;                                      //if so, return -1
	}
	int left = (pos*2) + 1;                             //get left child index
	int right = (pos*2) + 2;                            //get right child index

	//only one child
	if (left < _heap.size() && _heap.size() <= right) { //only has a left child
	    return left;                                    //return that left child's index
	}

	//two children
	if (left < _heap.size() && right < _heap.size()) {  //check that it does have 2 children
	    Integer a = _heap.get(left);                    //set a = to the element at index left
	    Integer b = _heap.get(right);                   //set b = to the element at index right
	    if (minOf(a,b) == a) {                          //if a is smaller
		return left;                                //return left index
	    }
	    else {                                          //otherwise
		return right;                               //return right index
	    }
	}

	//no children
	return -1;                                          //if no other conditions apply, return -1
    }//O(1)


    //************ aux helper fxns ***************
    private Integer minOf( Integer a, Integer b )
    {
	if ( a.compareTo(b) < 0 )
	    return a;
	else
	    return b;
    }

    //swap for an ArrayList
    private void swap( int pos1, int pos2 )
    {
	_heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );
    }
    //********************************************



    //main method for testing
    public static void main( String[] args )
    {

	  ALHeapMin pile = new ALHeapMin();

	  pile.add(2);
	  System.out.println(pile);
	  pile.add(4);
	  System.out.println(pile);
	  pile.add(6);
	  System.out.println(pile);
	  pile.add(8);
	  System.out.println(pile);
	  pile.add(10);
	  System.out.println(pile);
	  pile.add(1);
	  System.out.println(pile);
	  pile.add(3);
	  System.out.println(pile);
	  pile.add(5);
	  System.out.println(pile);
	  pile.add(7);
	  System.out.println(pile);
	  pile.add(9);
	  System.out.println(pile);

	  System.out.println(pile.minChildPos(0));
	  System.out.println(pile.minChildPos(1));
	  System.out.println(pile.minChildPos(2));
	  System.out.println(pile.minChildPos(3));

	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class ALHeapMin
