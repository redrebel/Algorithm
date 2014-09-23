package sort.selection;

/**
 * Selection Sort
 * @author cjred77@gmail.com
 * 14.09.20
 * 
 * 
 */
public class Selection {

	public static void sort(int[] arr){
		int arrLen = arr.length;
		int actCnt = 0;
		for(int i = 0; i < arrLen; i++){
			int mini = arr[i];
			int miniIdx = i;
			for(int j=i+1;j<arrLen;j++){
				if(mini > arr[j]){
					mini = arr[j];
					miniIdx = j;
				}
				actCnt++;
			}
			int temp = arr[i];
			arr[i] = arr[miniIdx];
			arr[miniIdx] = temp;
		}
		System.out.println(actCnt);
	}
	
	public static void main(String[] args) {
		int[] arr = { 3, 4, 16, 2 ,8, 32, 88, 1};
		for(int a:arr)
			System.out.print(a+",");
		System.out.println();
		sort(arr);
		for(int a:arr)
			System.out.print(a+",");
	}

}
