package util;

public class Swap {
	
	public static void swap(Object[] array, int indice1, int indice2) {
		Object temp = array[indice1];
		array[indice1] = array[indice2];
		array[indice2] = temp;
	}
	
}
