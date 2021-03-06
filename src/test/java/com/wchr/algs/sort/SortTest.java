package com.wchr.algs.sort;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.wchr.algs.sort.Quicksort;
import com.wchr.algs.sort.Sort;

public class SortTest {
	@Test
	public void testQuicksort(){

		int[] input = new int[]{6,4,2,7,5,1,3,8};
		int[] output= new int[]{1,2,3,4,5,6,7,8};
		Sort qs = new Quicksort();
		qs.doSort(input);
		assertArrayEquals(output, input);
	}

	@Test
	public void testMergesort(){

		int[] input = new int[]{6,4,2,7,5,1,3,8};
		int[] output= new int[]{1,2,3,4,5,6,7,8};
		Sort qs = new Mergesort();
		qs.doSort(input);
		assertArrayEquals(output, input);
	}
}
