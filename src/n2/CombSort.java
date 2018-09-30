package n2;

import java.util.Arrays;

import util.Swap;

public class CombSort {
	
	public static void combSort(Integer[] array, int leftIndex, int rightIndex) {
		int gap = rightIndex - leftIndex + 1;
		int i;
		
		while (gap > 1) {
			gap /= 1.25;
			if (gap < 1) gap = 1;
			i = 0;
			
			while (i + gap <= rightIndex - leftIndex) {
				if (array[i] > array[i + gap]) 
					Swap.swap(array, i, i + gap);
				i++;
			}
		}
	}
	
	public static void main(String[] args) {
		Integer[] array = new Integer[] {10,21,24,12,46,99,52,76,133,457,650,25,432,40,271,101,420};
		CombSort.combSort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}
	
}
