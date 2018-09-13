package util;

import java.util.Comparator;

public interface Sorting<T extends Comparable<T>> {
	
	public void sort(T[] elements);
	
}
