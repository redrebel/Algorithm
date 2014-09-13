package p140910;

import java.util.ArrayList;

/**
 * bubble sort
 * 
 * @author red
 * 
 */
public class Bubble {

	private void swap(int leftE, int rightE) {
		int tmp;
		tmp = leftE;
		leftE = rightE;
		rightE = tmp;
	}

	/**
	 * bubble sort
	 * @param arr
	 */
	public static int bubbleSort(int[] arr) {
		int cntSwap = 0;
		boolean swapped;
		do {
			swapped = false;
			for (int i = 1; i < arr.length; i++) {
				if (arr[i - 1] > arr[i]) {
					int tmp;
					tmp = arr[i - 1];
					arr[i - 1] = arr[i];
					arr[i] = tmp;
					swapped = true;
					cntSwap++;
				}
			}
		}while(swapped);
		return cntSwap;
	}
	
	/**
	 * enhanced bubble sort
	 * @param arr
	 * @return
	 */
	public static int enhancedBubbleSort(int[] arr){
		int cntSwap = 0;
		boolean swapped;
		int lastIndex = arr.length;
		do{
			swapped = false;
			for(int i = 1; i<lastIndex; i++){
				if(arr[i-1] > arr[i]){
					int tmp = arr[i-1];
					arr[i-1] = arr[i];
					arr[i] = tmp;
					swapped = true;
					cntSwap++;
				}
			}
			lastIndex--;
		}while(swapped);
		
		return cntSwap;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 4, 16, 2 ,8, 32, 88, 1};
		// Bubble b = new Bubble();
		for(int a:arr)
			System.out.print(a+",");
		System.out.println();
		int cntSwap;
		//cntSwap = bubbleSort(arr);
		cntSwap = enhancedBubbleSort(arr);
		for(int a:arr)
			System.out.print(a+",");
		System.out.println();
		System.out.println("cntSwap : " + cntSwap);
	}

}
