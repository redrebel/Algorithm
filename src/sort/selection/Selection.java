package sort.selection;

/**
 * Selection Sort
 * @author cjred77@gmail.com
 * 14.09.20
 * 
 * 
 */
public class Selection {

	/**
	 * print array
	 * @param arr
	 */
	public static void printArray(int arr[]){
		for(int a:arr)
			System.out.print(a+",");
		System.out.println();
	}

	public static void sort(int[] arr, int arrLen){
		int actCnt = 0;
		for(int i = 0; i < arrLen; i++){
			int miniIdx = i;
			System.out.print("arr[" + miniIdx + "]=" + arr[miniIdx]);

			for(int j=i+1;j<arrLen;j++){
				if(arr[miniIdx] > arr[j]){
					miniIdx = j;
				}
				actCnt++;
			}
			System.out.print(" <-> arr[" + miniIdx + "]=" + arr[miniIdx] + " -> "  );

			int temp = arr[i];
			arr[i] = arr[miniIdx];
			arr[miniIdx] = temp;
			printArray(arr);
		}
		System.out.println("Compare count : " + actCnt);
	}

	
	public static void main(String[] args) {
		int arr[] = new int[8];

		// random array
		for(int i=0; i < arr.length; i++){
			arr[i] = (int)(Math.random()*100) + 1;
		}
		printArray(arr);
		sort(arr, arr.length);
		printArray(arr);
	}

}
