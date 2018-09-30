package n2;

import util.Sorting;

public class InsertionSort<T extends Comparable<T>> implements Sorting<T> {

	@Override
	public void sort(T[] elements) {
		int tam = elements.length;
		T aux;
		int j;
		int pivot;
		
		for (int i = 0; i < tam - 1; i++) {
			j = i + 1;
			pivot = i;
			
			while (j > 0 && elements[j].compareTo(elements[pivot]) > 0) {
				aux = elements[j];
				elements[j] = elements[pivot];
				elements[pivot] = aux;
				j--;
				pivot--;
			}
			
		}
		
	}
	
	
}
