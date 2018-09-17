package linear;

import java.util.Arrays;

public class BucketSort {
	
	public static void sort(int[] array, int leftIndex, int rightIndex) {
		int[][] buckets = new int[10][array.length];
		int[] contAux = new int[10];
		int temp;
		
		for (int i = leftIndex; i <= rightIndex; i++) {
			temp = array[i] / 10;			// modificando o divisor aumenta o range de cada bucket
			buckets[temp][contAux[temp]++] = array[i];
		}
		
		for (int i = 0; i < 10; i++) {
			if (contAux[i] > 0)
				CountingSort.sort(buckets[i], 0, contAux[i] - 1);
		}
		
		int k = leftIndex;
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < contAux[i]; j++) 
				array[k++] = buckets[i][j];
		}

	}
	
	public static void main(String[] args) {
		int[] array = new int[] {10,21,24,12,46,99,52,76,133,457,650,25,432,40,271,101,420};
		BucketSort.sort(array, 0, array.length - 1);
		
		System.out.println(Arrays.toString(array));
	}
}
