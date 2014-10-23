package mergeSort;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;


public class ForkJoinMergeSort<E extends Comparable> {
	public ForkJoinMergeSort(){}


	public long sort(E[] array){
		//E[] array = array;
		//E[] dest = array.clone();
		 E[] dest =Arrays.copyOfRange(array, 0, array.length);
		//Object dest = new Object[array2.length + 1];
		ForkJoinPool pool = new ForkJoinPool();

		MergeSortTask task = new MergeSortTask(array,dest,0,array.length);
		long start = System.nanoTime();
		pool.invoke(task);
		long stop = System.nanoTime();

		return stop - start;
	}
}
