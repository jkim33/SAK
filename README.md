# Team SAK -- Jason Kim, Soojin Choi, Adrian Kloskowski
## APCS2 pd8
## LAB#03 -- PriorityQueue + Min Heap

## RunMed (rmed)
### Algorithm
<p> This system takes advantage of 2 Heaps, one min, one max. The first element always goes to the MaxHeap. From there, every element afterwards goes into the appropriate Heap, depending on the its value compared to the root of the MaxHeap. If the new element is smaller, we add it to the MaxHeap. If not, it's added to the MinHeap. From there, if the size difference between the 2 Heaps is greater than 1, we remove elements from the larger Heap and add them to the smaller one. </p>
<p> When getting the median, if there are no elements in either Heap, throw and exception. If one Heap is larger, return the root of that Heap. If the 2 Heaps are equal in size, return the mean of the 2 roots. </p>

## Min Heap (almh)
### To-Do
1) public ALHeap() -- Constructor is necessary to make instances. 
2) public String toString() -- Great for visualization when testing future methods.
3) public boolean isEmpty() -- Simple to implement, is used for later methods. 
4) public void add(Integer addVal) -- We now have all the resources to visual addition. This is also one of the core methods that make this Min Heap what it is. 
5) private int minChildPos(int pos) -- Is a helper method for removeMin(). 
6) public Integer removeMin() -- Now we have elements to remove and the necessary helper methods. 

### Method Summary/Runtime
<p><b> add(Integer addVal) </b></p>
<p> We added addVal to the end of the _heap ArrayList. From there, we checked if its current parent had a larger value, and if it did, the two swapped. This kept going on until the Min Heap condition was met. </p>
<p>- Runtime is Log(n).</p>

<p><b> isEmpty() </b></p>
<p> We used the size() method from ArrayList _heap to determine if it was empty. </p>
<p>- Runtime is Constant Time.</p>

<p><b> minChildPos(int pos) </b></p>
<p> We used parentIndex * 2 + 1 for the left child and parentIndex * 2 + 2 for the right child. From there, we compared the two values if both children existed. If not, we just returned the index of the one child or -1. </p>
<p>- Runtime is Constant Time.</p>

<p><b> removeMin() </b></p>
<p> We first swapped the root and the furthest right element of the bottom level. From there, we carried that past furthest right element down where it was appropriate with the help of minChildPos(int pos).</p>
<p>- Runtime is Log(n).</p>

## PriorityQueue (v1 + v2)
### Method Summary/Runtime
<p><b> add(String str) </b></p>
<p> For our implementation of add(), we decided to use the ArrayList's add method for simplicity. This simply adds the String to the end of the ArrayList, and also keeps the data in queue order. </p>
<p>- Runtime is Constant Time.</p>

<p><b> isEmpty() </b></p>
<p> We have the instance variable, named "size". Size is updated with the add and remove methods, so all we have to do, is see if size is equal to zero. </p>
<p>- Runtime is Constant Time.</p>

<p><b> peekMin() </b></p>
<p> We have a local variable that stores the "lowest string" as we traverse through the queue. As we traverse, if we encounter an even lower string than the one currently stored, we replace the stored string with the new lower one. Once we are done traversing, we return that stored lowest string. </p>
<p>- Runtime is Linear Time.</p>

<p><b> removeMin() </b></p> 
<p> We basically go through the same process as peekMin(), but this time, we also store the index of the corresponding "lowest string". Once we are done traversing, we use the ArrayList's remove method to remove at index. We return the stored lowest string. </p>
<p>- Runtime is Linear Time.</p>
