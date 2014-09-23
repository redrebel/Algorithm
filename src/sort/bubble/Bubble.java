package sort.bubble;

/**
 * Bubble sort
 * 
 * @author cjred77@gmail.com
 * 14.09.10
 * 
 * Do 
 *   swapped = false
 *   for i = 1 to numOfElements exclusive
 *     if leftElement > rightElement
 *       swap(leftElement, rightElement)
 *       swapped = true
 * while swapped
 * 
 * enhanced
 * do swapped = false
 *   for i=1 to indexOfLastUnsortedElement
 *     if lefrElement > rightElement
 *       swap(leftElement, rightElement)
 *       swapped =true
 * while swapped
 * 
 */
public class Bubble {

	/**
	 * bubble sort
	 * @param arr
	 */
	public static int sort(int[] arr) {
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
	public static int enhanceSort(int[] arr){
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
		for(int a:arr)
			System.out.print(a+",");
		System.out.println();
		int cntSwap;
		//cntSwap = bubbleSort(arr);
		cntSwap = enhanceSort(arr);
		for(int a:arr)
			System.out.print(a+",");
		System.out.println();
		System.out.println("cntSwap : " + cntSwap);
	}

}
