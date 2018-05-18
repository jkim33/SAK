import java.util.NoSuchElementException;
/* ALGO:


*/
public class RunMed{

    //instance variable
    ALHeapMin bigVals;
    ALHeapMax lilVals;

    //constructor
    public RunMed(){
      bigVals = new ALHeapMin();
      lilVals = new ALHeapMax();
    }

    //methods
    public Integer getMedian(){
      System.out.println(bigVals);
      System.out.println(lilVals);
      if (lilVals.isEmpty() && bigVals.isEmpty()){
        throw new NoSuchElementException();
      }
      //Odd number of elements
      if (bigVals.size > lilVals.size){
        System.out.println("Choice2");
        return bigVals.peekMin();
      }
      else if (lilVals.size > bigVals.size){
        System.out.println("Choice3");
        return lilVals.peekMax();
      }
      else{//Even number of elements
        Integer bigMed = bigVals.peekMin(); //min val of the big nums
        Integer lilMed = lilVals.peekMax(); //max val of the lil nums
        System.out.println("Choice1");
        return new Integer ((bigMed.intValue() + lilMed.intValue()) / 2);
      }
    }//O()

    public void add(Integer newVal){
      if (lilVals.isEmpty()){ //If it's the first element
        lilVals.add(newVal);
      }
      //Val > current median
      else if (newVal > lilVals.peekMax()){
        bigVals.add(newVal);
      }
      else {
        lilVals.add(newVal);
      }

      int sizeDif = lilVals.size - bigVals.size;
      while (sizeDif > 1 || sizeDif < -1){
        if(sizeDif > 1 ){
          bigVals.add(lilVals.removeMax());
        }
        else{
          lilVals.add(bigVals.removeMin());
        }
        sizeDif = lilVals.size - bigVals.size;
      }
    }//O()

}
