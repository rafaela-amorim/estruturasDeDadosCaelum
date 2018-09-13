package linear;

import java.util.Arrays;

public class CountingSort<T extends Comparable<T>> {

	//public T[] sort(T[] array, T[] resposta, int range) {
	
	public static int[] sort(int[] array, int[] resposta, int range) {
		
		int[] count = new int[range];
		
		for (int i = 0; i < array.length; i++) 
			count[array[i] - 1]++;
		
		for (int i = 1; i < range; i++) 
			count[i] += count[i - 1]; 
		
		for (int i = array.length - 1; i >= 0; i--) {
			count[array[i] - 1]--;
			resposta[count[array[i] - 1]] = array[i];
		}
		
		return resposta;
	}
	
	/*
	private T[] offset(T[] array) {
		T max = array[0];
		T min = array[0];
		T[] tupla = (T[]) new Comparable[2];
		
		for (int i = 1; i < array.length; i++) {
			if (array[i].compareTo(min) < 0) 
				min = array[i];
			if (array[i].compareTo(max) > 0)
				max = array[i];
		}
		tupla[0] = min;
		tupla[1] = max;
		
		return tupla; 
	}
	*/
	
	public static void main(String[] args) {
		
		int[] array = new int[] {4,1,3,1};
		
		int[] ans = sort(array, new int[array.length], 5);
		
		System.out.println(Arrays.toString(ans));
	}
}


