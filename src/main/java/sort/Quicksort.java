package sort;

public class Quicksort implements Sort {

	private int[] arr;
    //private static final LOGGER = LoggerFactor
	public void setArray(int[] arr){
		this.arr = arr;
	}

	// pivot is last index of array
	public void sort(int lo, int hi) {
		//call partition around it, lower values left, highe ones right
		if (hi <= lo){return;}
		int newPivot = partition(hi);
		// recursively call quicksort on each side
		sort(lo,newPivot-1);
		sort(newPivot+1,hi);
	}

	public int partition( int pivotIdx){
		//most recent smaller value found
		int i = -1;
		for(int j = 0;j < pivotIdx ;j++){
			//if smaller , increment i, swap; if larger do nothing
			if(arr[j] < arr[pivotIdx]){
				i++;
				swap(i,j);
			}
		}
		swap(i+1,pivotIdx);
		return i+1;
	}

	private void swap(int i, int j){
		if (i == j) {return;}
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	@Override
	public void doSort(){
	// use last index as pivot
		sort(0 , arr.length -1);
	}

}
