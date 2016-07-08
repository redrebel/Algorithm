package sort.insertion;
/**
 * @author cjred77@gmail.com
 * 14.09.23
 * 
 * Insertion sort
 * Mark first element as sorted
 * for each unsorted element
 *   'extract' the element
 *   for j = lastSortedIndex to 0
 *     if currentSorted Element > extractedElement
 *       move sorted element to the right by 1
 *     else : insert extracted element
 */
public class Insertion {

	public static void sort(int[] arr){
		//int lastSortedIndex = 0;	// mark first element as sorted
		for(int i=1; i<arr.length; i++){	// for each unsorted element
			int extract = arr[i];	// 'extract' the element
			int j;
			for(j=i; j>=0; j--){	//for j=lastSortedIndex to 0
				if(arr[j] > extract){	//if currentSortedElement > extractedElement
					arr[j+1] = arr[j];	//move sorted element to the right by 1
				}else{
					break;	
				}
			}
			arr[j+1] = extract;	// insert extracted element
			//lastSortedIndex++;
		}
	}

	public static void sort2(int[] arr){
		int lastSortedIndex = 0;	// mark first element as sorted
		for(int i=lastSortedIndex+1; i<arr.length; i++){	// for each unsorted element
			int extract = arr[i];	// 'extract' the element
			int j;
			for(j=lastSortedIndex; j>=0; j--){	//for j=lastSortedIndex to 0
				if(arr[j] > extract){	//if currentSortedElement > extractedElement
					arr[j+1] = arr[j];	//move sorted element to the right by 1
				}else{
					break;
				}
			}
			arr[j+1] = extract;	// insert extracted element
			lastSortedIndex++;
		}
	}
	public static void main(String[] args) {
		int[] arr = { 3, 4, 16, 2 ,8, 32, 88, 1};
		for(int a:arr)
			System.out.print(a+",");
		System.out.println();
		sort2(arr);
		for(int a:arr)
			System.out.print(a+",");
	}

}
