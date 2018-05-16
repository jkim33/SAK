# Team SAK -- Jason Kim, Soojin Choi, Adrian Kloskowski
## APCS2 pd8

## Min Heap

### To-Do
1) public ALHeap() -- Constructor is necessary to make instances. 
2) public String toString() -- Great for visualization when testing future methods.
3) public boolean isEmpty() -- Simple to implement, is used for later methods. 
4) public void add(Integer addVal) -- We now have all the resources to visual addition. This is also one of the core methods that make this Min Heap what it is. 
5) private int minChildPos(int pos) -- Is a helper method for removeMin(). 
6) public Integer removeMin() -- Now we have elements to remove and the necessary helper methods. 

## LAB#03 -- PriorityQueue

### Method Summary/Decisions
<p><b> add(String str) </b></p>
<p> For our implementation of add(), we decided to use the ArrayList's add method for simplicity. This simply adds the String to the end of the ArrayList, and also keeps the data in queue order. </p>

<p><b> isEmpty() </b></p>
<p> We have the instance variable, named "size". Size is updated with the add and remove methods, so all we have to do, is see if size is equal to zero. </p>

<p><b> peekMin() </b></p>
<p> We have a local variable that stores the "lowest string" as we traverse through the queue. As we traverse, if we encounter an even lower string than the one currently stored, we replace the stored string with the new lower one. Once we are done traversing, we return that stored lowest string. </p>

<p><b> removeMin() </b></p> 
<p> We basically go through the same process as peekMin(), but this time, we also store the index of the corresponding "lowest string". Once we are done traversing, we use the ArrayList's remove method to remove at index. We return the stored lowest string. </p>

### Time Complexity of the Methods
<p> add(String str) 
- Runtime is Constant Time.
</p>

<p> isEmpty() 
- Runtime is Constant Time.
</p>

<p> peekMin() 
- Runtime is Linear Time.
</p>

<p> removeMin() 
- Runtime is Linear Time.
</p>


