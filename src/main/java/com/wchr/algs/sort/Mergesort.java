package com.wchr.algs.sort;

public class Mergesort implements Sort {
        //recursive method on each half
    public void sort(int[] arr,int[] copy, int lo, int hi){
    // in recursive method - 
       // if lo == hi  return, down to single element array
      if (hi <= lo){return;} 
        //get mid point
      int mid = (lo + hi)/2;
     //call recursive method on each half
      sort(arr,copy,lo,mid);
      sort(arr,copy,mid + 1, hi);
     
      int i = lo;
      int j = mid + 1;
      int copyIdx = lo;

      // walk thru array comparing , copying lower value to copy array
      while (i <= mid && j <= hi){
         if (arr[j] < arr[i]){
                 copy[copyIdx++] = arr[j++];
         } else {
                 copy[copyIdx++] = arr[i++];
             }
         }

          //after going thru array, copy each remaining  array elements
         if (j <= hi){
             for (int k = j; k <= hi; k++){
                 copy[copyIdx++] = arr[k];
             }
         }
         if (i <= mid){
             for (int l = i; l <= mid; l++){
                 copy[copyIdx++] = arr[l];
             }
         }
     // copy back to orig array
     for(int m = lo;m <= hi;m++){
         arr[m] = copy[m];
     }
     
    }
    @Override
    public void doSort(int[] arr){
        sort(arr,new int[arr.length], 0,arr.length - 1);
    }
}
