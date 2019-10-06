package com.wchr.algs.sort;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Quicksort implements Sort {

	private int[] arr;
    private static final Logger LOGGER = LogManager.getLogger(Quicksort.class.getName());
	// pivot is last index of array
	public void sort(int arr[], int lo, int hi) {
		//call partition around it, lower values left, highe ones right
		LOGGER.debug("Sorting between indexes {} and {} ",lo,hi);
		if (hi <= lo){
			LOGGER.debug("lo {} and hi {} same or crossed, exiting method com.wchr.ds.sort",lo,hi);
			return;
			}
		LOGGER.debug("calling partition with lo {} and hi {}",lo,hi);
		int newPivot = partition(arr,lo,hi);
		LOGGER.debug("New pivot index = {}",newPivot);
		// recursively call quicksort on each side
		LOGGER.debug("calling com.wchr.ds.sort on the left with lo  {} and hi {}",lo,newPivot-1);
		sort(arr,lo,newPivot-1);
		LOGGER.debug("calling com.wchr.ds.sort on the right with lo  {} and hi {}",newPivot+1,hi);
		sort(arr,newPivot+1,hi);
	}

	public int partition(int arr[], int lo, int pivotIdx){
		//most recent smaller value found
		int i = lo -1;
		LOGGER.debug("Set initial indes for smaller values to {}",i);
		for(int j = lo;j < pivotIdx ;j++){
			//if smaller , increment i, swap; if larger do nothing
			LOGGER.debug("Comparing j {} to pivotIdx {}",j,pivotIdx);
			if(arr[j] < arr[pivotIdx]){
				LOGGER.debug("arr[j] {} is less than arr[pivotIdx] {} incrementing i",arr[j],arr[pivotIdx]);
				i++;
				LOGGER.debug("Swapping arr[i] {} with arr[j] {}",arr[i],arr[j]);
				swap(arr,i,j);
			}
		}
		LOGGER.debug("Lastly Swapping pivot {} with latest small value {}",arr[i+1],arr[pivotIdx]);
		swap(arr,i+1,pivotIdx);
		LOGGER.debug("after partition, array now is:{}",arr);
		return i+1;
	}

	private void swap(int arr[],int i, int j){
		if (i == j) {return;}
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	@Override
	public void doSort(int[] arr){
	// use last index as pivot
		LOGGER.debug("Starting quick com.wchr.ds.sort");
		LOGGER.debug("Input Array: {}",arr);
		sort(arr,0 , arr.length -1);
	}

}
