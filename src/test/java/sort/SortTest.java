package sort;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SortTest {
	@Test
	public void testQuicksort(){

		int[] input = new int[]{5,2,3,1,4};
		int[] output= new int[]{1,2,3,4,5};
		Sort qs = new Quicksort();
		qs.setArray(input);
		qs.doSort();
		assertArrayEquals(output, input);
	}
}
