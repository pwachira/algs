package sort;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SortTest {
	@Test
	public void testQuicksort(){

		int[] input = new int[]{6,4,2,7,5,1,3,8};
		int[] output= new int[]{1,2,3,4,5,6,7,8};
		Sort qs = new Quicksort();
		qs.setArray(input);
		qs.doSort();
		assertArrayEquals(output, input);
	}
}
