package com.wchr.algs.sort;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
   
  class InsertionSort{
    void sort(int[] arr){
      int fwdPtr;
      for (fwdPtr = 1; fwdPtr < arr.length ; fwdPtr++){
           int backPtr = fwdPtr - 1;
           int swapVal = arr[fwdPtr];
        while (backPtr >=0 && arr[backPtr] > swapVal){
          System.out.println
            (String.format("fwdPtr= {%d} fwdVal = {%d} swapVal = {%d} backPtr = {%d} backVal ={%d}",
                           fwdPtr,arr[fwdPtr],swapVal,backPtr,arr[backPtr]));
            System.out.println(String.format("copy backVal{%d} to nextIdx {%d}",arr[backPtr], backPtr+1));
          arr[backPtr +1] = arr[backPtr];
                 System.out.println("After 1st step of swap new Array" + Arrays.toString( arr)); 
          backPtr--;
        
        }
        
        arr[backPtr +1] =swapVal; 
        System.out.println("After 2nd step of swap outside  while; new Array = " + Arrays.toString( arr)); 

      }
    }
  }
  
  public static void main(String[] args) {
    InsertionSort is = new Solution().new InsertionSort();
    int[] arr = new int[]{7,4,6,5,3};
        System.out.println(Arrays.toString(arr));
    is.sort(arr);
    
    
    System.out.println(Arrays.toString(arr));
  }
  


}