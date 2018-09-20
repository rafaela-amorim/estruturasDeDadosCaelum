package linear;

import java.util.Arrays;

public class CountingSort {

	public static void sort(int[] array, int leftIndex, int rightIndex) {
		if (array.length > leftIndex) {		// indice valido ou array de tam > 0
			
			int min = array[leftIndex];
			int max = array[leftIndex];
			int[] saida = new int[rightIndex - leftIndex + 1];
			
			for (int i = leftIndex; i <= rightIndex; i++) {
				if (array[i] < min) min = array[i];
				if (array[i] > max) max = array[i];
			}
			
			// cria array de contador do tamanho maior el. menos menor + 1 (intervalo fechado)
			int[] count = new int[max - min + 1];	
			
			// incrementa +1 em count toda vez q encontrar tal elemento array[i]
			for (int i = leftIndex; i <= rightIndex; i++) 
				count[array[i] - min]++;
			
			// soma uma pos de count com seu anterior (array de soma)
			for (int i = 1; i <= max - min; i++) 
				count[i] += count[i - 1];
			
			// decrementa o indice armazenado no count[] e adiciona o num em array[i] à saída
			for (int i = rightIndex; i >= leftIndex; i--) 
				saida[--count[array[i] - min]] = array[i];		
			
			// se leftIndex for a metade do array p.e., na saida será 0 pois começou a ser ordenado de leftIndex.
			for (int i = leftIndex; i <= rightIndex; i++) 
				array[i] = saida[i - leftIndex];
			
		}
		
	}
	public static void main(String[] args) {
		///int[] array = new int[] {10,21,24,12,46,99,52,76,133,457,650,25,432,40,271,101,420};
		int[] array = new int[] {6,0,2,0,1,3,4,6,1,3,2};
		CountingSort.sort(array, 0, array.length - 1);
		
		
		System.out.println(Arrays.toString(array));
	}
	
}


