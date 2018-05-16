//Adrian Kloskowski
//APCS2 pd. 8
//Hw 46 -- Arr there be priorities here matey or smth
//2018-05-16

public class ArrayPriorityQueue implements PriorityQueue {
	private ArrayList<String> _data;
	private int size;
	
	public ArrayPriorityQueue() {
		_data = new ArrayList<String>();
		size = 0;
	}
	
	public void add(String str){
		_data.add(str);
		size++;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public String peekMin(){
		int minIndex = 0;
		String minStr = _data[0];
		for (int i = 1; i < size; i++){
			if (_data[i].compareTo(minStr) > 0) {
				minIndex = i;
				minStr = _data[i];
			}
		}
		return minStr;
	}
	
	public String removeMin(){
		int minIndex = 0;
		String minStr = _data[0];
		for (int i = 1; i < size; i++){
			if (_data[i].compareTo(minStr) > 0) {
				minIndex = i;
				minStr = _data[i];
			}
		}
		return _data.remove(minIndex);
	}
	
}