package FinalProject;

import java.util.PriorityQueue;

/**
 * This class implements six different comparison sorts (and an optional heap
 * sort for extra credit):
 * 
 * insertion sort selection sort shell sort quick sort bubble sort merge sort
 * (extra credit) heap sort
 * 
 * It also has a method that runs all the sorts on the same input array and
 * prints out statistics.
 */

public class SortingComparisons {

	/** The method for sorting the numbers */

	/**
	 * Sorts the given array using the insertion sort algorithm. Note: after this
	 * method finishes the array is in sorted order.
	 * 
	 * @param   <T> the type of values to be sorted
	 * @param A the array to sort
	 */
	public static <T extends SortObject> void insertionSort(T[] A) {
		for (int i = 1; i < A.length; i++) {
			/* Insert A[i] into a sorted subA A[0..i-1] so that A[0..i] is sorted. */
			SortObject currentElement = new SortObject(); // Need to use SortObject Class
			currentElement.assignTo(A[i]); // T currentElement = A[i];

			int k;
			for (k = i - 1; k >= 0 && A[k].compareTo(currentElement) > 0; k--) {
				A[k + 1].assignTo(A[k]); // A[k + 1] = A[k];
			}

			// Insert the current element into A[k + 1]
			A[k + 1].assignTo(currentElement); // A[k + 1] = currentElement;
		}

	}

	/**
	 * Sorts the given array using the selection sort algorithm. Note: after this
	 * method finishes the array is in sorted order.
	 * 
	 * @param   <T> the type of values to be sorted
	 * @param A the array to sort
	 */
	public static <T extends SortObject> void selectionSort(T[] A) {
		for (int i = 0; i < A.length - 1; i++) {
			// find the min number of unsorted list
			int index = i;
			for (int j = i + 1; j < A.length; j++) {
				if (A[index].compareTo(A[j]) > 0) { // A[index]>A[j]
					index = j; // A[index]=A[j];
				}
			}

			/* swap A[index] with A[j]) */
			SortObject temp = new SortObject(); // Need to use SortObject Class
			temp.assignTo(A[index]); // T temp = A[index];
			A[index].assignTo(A[i]); // A[index] = A[i];
			A[i].assignTo(temp); // A[i] = temp;
		}
	}

	/**
	 * Sorts the given array using the bubble sort algorithm. Note: after this
	 * method finishes the array is in sorted order.
	 * 
	 * @param   <T> the type of values to be sorted
	 * @param A the array to sort
	 */
	public static <T extends SortObject> void bubbleSort(T[] A) {
		boolean needNextPass = true;
		for (int k = 1; k < A.length && needNextPass; k++) {
			// Array may be sorted and next pass not needed
			needNextPass = false;
			for (int i = 0; i < A.length - k; i++) {
				if (A[i].compareTo(A[i + 1]) > 0) { // A[i] > A[i + 1]
					// Swap A[i] with A[i + 1]
					SortObject temp = new SortObject(); // Need to use SortObject Class
					temp.assignTo(A[i]); // T temp = A[i];
					A[i].assignTo(A[i + 1]); // A[i] = A[i + 1];
					A[i + 1].assignTo(temp); // A[i + 1] = temp;
					needNextPass = true; // Next pass still needed
				}
			}
		}

	}

	/**
	 * Sorts the given array using the shell sort algorithm. Note: after this method
	 * finishes the array is in sorted order.
	 * 
	 * @param   <T> the type of values to be sorted
	 * @param A the array to sort
	 */
	public static <T extends SortObject> void shellSort(T[] A) {
		// TODO: implement this sorting algorithm
		int n = A.length;
		for (int gap = n / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < n; i++) {
				SortObject temp = new SortObject(); // Need to use SortObject Class
				temp.assignTo(A[i]); // T temp = A[i];
				int j;
				for (j = i; j >= gap && A[j - gap].compareTo(temp) > 0; j -= gap)
					A[j].assignTo(A[j - gap]);// A[j] = A[j - gap]
				A[j].assignTo(temp);// A[j] = temp;
			}
		}
	} // end shellSort

	/**
	 * Recursive mergeSort Sorts the given array using the merge sort algorithm.
	 * Note: after this method finishes the array is in sorted order.
	 * 
	 * @param   <T> the type of values to be sorted
	 * @param A the array to sort
	 */

	public static <T extends SortObject> void mergeSort(T[] A) {
		if (A == null) {
			return;
		}

		if (A.length > 1) {
			int mid = A.length / 2;

			// Split left part
			SortObject[] left = new SortObject[mid]; // T[] left = (T[]) new Object[mid];
			for (int i = 0; i < mid; i++) {
				left[i] = new SortObject();
				left[i].assignTo(A[i]); // left[i] = A[i];

			}

			// Split right part
			SortObject[] right = new SortObject[A.length - mid]; // T[] right = (T[]) new Object[A.length - mid];
			for (int i = mid; i < A.length; i++) {
				right[i - mid] = new SortObject(); // right[i - mid] = A[i];
				right[i - mid].assignTo(A[i]); // right[i - mid] = A[i];
			}

			mergeSort(left);
			mergeSort(right);

			int i = 0;
			int j = 0;
			int k = 0;

			// Merge left and right As
			while (i < left.length && j < right.length) {
				if (left[i].compareTo(right[j]) < 0) { // left[i] < right[j]
					A[k].assignTo(left[i]); // A[k] = left[i];
					i++;
				} else {
					A[k].assignTo(right[j]);// A[k] = right[j];
					j++;
				}
				k++;
			}
			// Collect remaining elements
			while (i < left.length) {
				A[k].assignTo(left[i]); // A[k] = left[i];
				i++;
				k++;
			}
			while (j < right.length) {
				A[k].assignTo(right[j]);// A[k] = right[j];
				j++;
				k++;
			}
		}

	}

	/**
	 * Sorts the given array using the quick sort algorithm, using the median of the
	 * first, last, and middle values in each segment of the array as the pivot
	 * value. Note: after this method finishes the array is in sorted order.
	 * 
	 * @param   <T> the type of values to be sorted
	 * @param A the array to sort
	 */
	public static <T extends SortObject> void quickSort(T[] A) {
		quickSort(A, 0, A.length - 1);
	}

	private static <T extends SortObject> void quickSort(T[] A, int first, int last) {
		if (last > first) {
			int pivotIndex = partition(A, first, last);
			quickSort(A, first, pivotIndex - 1);
			quickSort(A, pivotIndex + 1, last);
		}
	}

	/**
	 * Partition the array A[first..last]
	 * 
	 * @return
	 */
	private static int partition(SortObject[] A, int first, int last) {
		SortObject pivot = new SortObject(); // Need to use SortObject Class
		pivot.assignTo(A[first]); // int pivot = A[first]; Choose the first element as the pivot
		int low = first + 1; // Index for forward search
		int high = last; // Index for backward search

		while (high > low) {
			// Search forward from left
			while (low <= high && A[low].compareTo(pivot) <= 0) // A[low] <= pivot
				low++;

			// Search backward from right
			while (low <= high && A[high].compareTo(pivot) > 0) // A[high] > pivot
				high--;

			// Swap two elements in the Array
			if (high > low) {
				SortObject temp = new SortObject();
				temp.assignTo(A[high]); // int temp = A[high];
				A[high].assignTo(A[low]);// A[high] = A[low];
				A[low].assignTo(temp);// A[low] = temp;
			}
		}

		while (high > first && A[high].compareTo(pivot) >= 0)
			high--;

		// Swap pivot with A[high]
		if (pivot.compareTo(A[high]) > 0) {
			A[first].assignTo(A[high]);
			A[high].assignTo(pivot);
			return high;
		} else {
			return first;
		}
	}

	/**
	 * Sorts the given array using the heap sort algorithm outlined below. Note:
	 * after this method finishes the array is in sorted order.
	 * 
	 * The heap sort algorithm is:
	 * 
	 * for each i from 1 to the end of the array insert A[i] into the heap
	 * (contained in A[0]...A[i-1])
	 * 
	 * for each i from the end of the array up to 1 remove the max element from the
	 * heap and put it in A[i]
	 * 
	 * 
	 * @param   <T> the type of values to be sorted
	 * @param A the array to sort
	 */
	public static <T extends SortObject> void heapSort(T[] A) {
		// TODO: implement this sorting algorithm
		PriorityQueue<T> heap = new PriorityQueue<T>();

		SortObject[] elements = new SortObject[A.length];
		// Add elements to the heap
		for (int i = 0; i < A.length; i++)
			heap.add(A[i]);
		for (int i = 0; i < A.length; i++) {
			elements[i] = heap.remove();// A[i].assignTo(heap.remove());
			elements[i].assignTo(A[i]);// A[i].assignTo(heap.remove());
		}
	}

	/**
	 * Internal helper for printing rows of the output table.
	 * 
	 * @param sort         name of the sorting algorithm
	 * @param compares     number of comparisons performed during sort
	 * @param moves        number of data moves performed during sort
	 * @param milliseconds time taken to sort, in milliseconds
	 */
	@SuppressWarnings("unused")
	private static void printStatistics(final String sort, final int compares, final int moves,
			final long milliseconds) {
		System.out.format("%-23s%,15d%,15d%,15d\n", sort, compares, moves, milliseconds);
	}

	/**
	 * Sorts the given array using the six (heap sort with the extra credit)
	 * different sorting algorithms and prints out statistics. The sorts performed
	 * are:
	 * 
	 * insertion sort selection sort shell sort quick sort bubble sort merge sort
	 * (extra credit) heap sort
	 * 
	 * The statistics displayed for each sort are: number of comparisons, number of
	 * data moves, and time (in milliseconds).
	 * 
	 * Note: each sort is given the same array (i.e., in the original order).
	 * 
	 * @param A the array to sort
	 */
	public static <T extends SortObject> void runAllSorts(T[] A) {
		System.out.format("%-23s%15s%15s%15s\n", "algorithm", "data compares", "data moves", "milliseconds");
		System.out.format("%-23s%15s%15s%15s\n", "---------", "-------------", "----------", "------------");
		// TODO: run each sort and print statistics about what it did

		long startTime, endTime;
		T[] arr = reset(A);
		startTime = System.nanoTime();
		insertionSort(arr);
		endTime = System.nanoTime();

		System.out.format("%-23s%15s%15s%15s\n", "insertion sort", SortObject.getCompares(),
				SortObject.getAssignments(), (endTime - startTime) / 1000000);

		arr = reset(A);
		startTime = System.nanoTime();
		selectionSort(arr);
		endTime = System.nanoTime();
		System.out.format("%-23s%15s%15s%15s\n", "selection sort", SortObject.getCompares(),
				SortObject.getAssignments(), (endTime - startTime) / 1000000);

		arr = reset(A);
		startTime = System.nanoTime();
		shellSort(arr);
		endTime = System.nanoTime();
		System.out.format("%-23s%15s%15s%15s\n", "shell sort", SortObject.getCompares(), SortObject.getAssignments(),
				(endTime - startTime) / 1000000);

		arr = reset(A);
		startTime = System.nanoTime();
		quickSort(arr);
		endTime = System.nanoTime();
		System.out.format("%-23s%15s%15s%15s\n", "quick sort", SortObject.getCompares(), SortObject.getAssignments(),
				(endTime - startTime) / 1000000);

		arr = reset(A);
		startTime = System.nanoTime();
		heapSort(arr);
		endTime = System.nanoTime();
		System.out.format("%-23s%15s%15s%15s\n", "heap sort", SortObject.getCompares(), SortObject.getAssignments(),
				(endTime - startTime) / 1000000);

		arr = reset(A);
		startTime = System.nanoTime();
		bubbleSort(arr);
		endTime = System.nanoTime();
		System.out.format("%-23s%15s%15s%15s\n", "bubble sort", SortObject.getCompares(), SortObject.getAssignments(),
				(endTime - startTime) / 1000000);

		arr = reset(A);
		startTime = System.nanoTime();
		mergeSort(arr);
		endTime = System.nanoTime();
		System.out.format("%-23s%15s%15s%15s\n", "merge sort", SortObject.getCompares(), SortObject.getAssignments(),
				(endTime - startTime) / 1000000);
	}

	@SuppressWarnings("unchecked")
	private static <T extends SortObject> T[] reset(T[] A) {

		SortObject[] arr = TestSort.makeCopy(A, A.length);
		SortObject.resetCompares();
		SortObject.resetAssignments();
		return (T[]) arr;

	}
}
