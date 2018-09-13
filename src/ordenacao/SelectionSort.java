package ordenacao;

import util.Sorting;

public class SelectionSort<T extends Comparable<T>> implements Sorting<T> {

	@Override
	public void sort(T[] elements) {
		int menor;
		T temp;
		int tam = elements.length;
		
		for (int i = 0; i < tam; i++) {
			menor = i;						// guarda o indice do menor
			for (int j = i + 1; j < tam; j++) {
				if (elements[menor].compareTo(elements[j]) > 0) 
					menor = j; 				// troca o indice
			}
			
			// troca os elementos do array
			temp = elements[i];
			elements[i] = elements[menor];
			elements[menor] = temp;
		}
		
	}
	
}
