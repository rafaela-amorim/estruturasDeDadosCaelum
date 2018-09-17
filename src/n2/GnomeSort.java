package n2;

import java.util.Arrays;

import util.Swap;

public class GnomeSort {
	// talvez seja bom usar generics
	
	public static void gnomeSort(Integer[] array, int leftIndex, int rightIndex) {
		int pivo = leftIndex + 1;
		
		while (pivo <= rightIndex - leftIndex) {
			if (array[pivo] >= array[pivo - 1])
				pivo++;
			else {
				Swap.swap(array, pivo, pivo - 1);
				if (pivo > 1)
					pivo--;
				else
					pivo++;
			}
		}
		
	}
	
	public static void main(String[] args) {
		Integer[] array = new Integer[] {10,21,24,12,46,99,52,76,133,457,650,25,432,40,271,101,420,150,23,165,14,35};
		GnomeSort.gnomeSort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}
	
}
