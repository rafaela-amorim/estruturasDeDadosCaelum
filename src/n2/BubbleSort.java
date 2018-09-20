package n2;

import util.Swap;

public class BubbleSort<T extends Comparable<T>> {
	
	public void bubbleSort(T[] array, int leftIndex, int rightIndex) {
		for (int i = leftIndex; i <= rightIndex; i++) {
			for (int j = leftIndex + 1; j <= rightIndex - i; j++) {
				if (array[j - 1].compareTo(array[j]) > 0)
					Swap.swap(array, j, j - 1);
			}
		}
	}
	
}
