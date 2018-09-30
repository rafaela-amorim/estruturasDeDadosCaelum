package linear;

import java.util.Arrays;

public class RadixSort {
	
	private static void countingSort(int[] array, int leftIndex, int rightIndex, int div) {
		int max = array[leftIndex];
		int min = array[leftIndex];
		int[] saida = new int[rightIndex - leftIndex + 1];
		
		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[i] < min) min = array[i];
			if (array[i] > max) max = array[i];
		}
		
		int[] cont = new int[max - min + 1];
		
		for (int i = leftIndex; i <= rightIndex; i++) 
			 cont[(array[i] / div) % 10]++; 
		
		for (int i = 1; i < max - min + 1; i++)
			cont[i] += cont[i - 1];
		
		for (int i = rightIndex; i >= leftIndex; i--) {
			cont[(array[i] / div) % 10]--;
			saida[cont[(array[i] / div) % 10]] = array[i];
		}
		
		for (int i = leftIndex; i <= rightIndex; i++) 
			array[i] = saida[i - leftIndex];
		
	}
	
	public static void radixSort(int[] array, int leftIndex, int rightIndex) {
		for (int i = 0; i <= 2; i++) 
			countingSort(array, leftIndex, rightIndex, (int) Math.pow(10, i));
	
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {10,21,24,12,46,99,52,76,133,457,650,25,432,40,271,101,420};
		radixSort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}
}
