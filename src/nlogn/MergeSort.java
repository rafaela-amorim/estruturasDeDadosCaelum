package nlogn;

import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> {
	
	public void mergeSort(T[] array, int leftIndex, int rightIndex) {
		if (array.length > 1 && leftIndex < rightIndex) {
			int meio = (rightIndex - leftIndex) / 2;
			
			mergeSort(array, leftIndex, meio);
			mergeSort(array, meio + 1, rightIndex);
			
			int i = 0;
			int j = 0;
			int k = 0;
			
			T[] saida = (T[]) new Comparable[array.length];
			T[] left = (T[]) new Comparable[rightIndex - leftIndex + 1];
			T[] right = (T[]) new Comparable[rightIndex - leftIndex + 1];
			
			for (int n = leftIndex; n <= rightIndex; n++) {
				if (n <= meio) 
					left[i++] = array[n];
				else 
					right[j++] = array[n];
			}
			
			i = 0;
			j = 0;
			
			while (i < left.length && j < right.length) {
				if (left[i].compareTo(right[j]) < 0)
					saida[k++] = left[i++];
				else
					saida[k++] = right[j++];
			}
			
			if (i < left.length) {
				for (int l = i; l < left.length; l++)
					saida[k++] = left[l];
			}
			if (j < right.length) {
				for (int l = j; l < right.length; l++)
					saida[k++] = right[l];
			}
			
			for (int n = leftIndex; n <= rightIndex; n++) 
				array[n] = saida[n];
		}
	}
	
	public static void main(String[] args) {
		Integer[] array = new Integer[] {10,21,24,12,46,99,52,76,133,457,650,25,432,40,271,101,420};
		MergeSort<Integer> ms = new MergeSort<>();
		ms.mergeSort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}
}
