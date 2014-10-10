package sort.quick;

/**
 * Created by cjred77@gmail.com on 2014-10-10.
 */
public class Quick {

    private static void qsort(int[] arr, int left, int right){
        if(left >= right){
            return;
        }
        for(int a=left;a<=right;a++)
            System.out.print(arr[a]+",");
        System.out.println();
        int pivotIndex = left;
        int storeIndex = pivotIndex+1;

        for(int i = storeIndex; i<=right; i++){
            if(arr[pivotIndex] > arr[i]){
                int temp = arr[storeIndex];
                arr[storeIndex] = arr[i];
                arr[i] = temp;

                storeIndex++;
            }
        }
        int temp;
        temp = arr[pivotIndex];
        arr[pivotIndex] = arr[storeIndex-1];
        arr[storeIndex-1] = temp;

        qsort(arr, pivotIndex, storeIndex-2);
        qsort(arr, storeIndex, right);
    }
    public static void sort(int[] arr){
        qsort(arr,0,arr.length-1);
    }

    public static void main(String[] args) {
        int[] arr = { 3, 4, 16, 2 ,8, 32, 88, 1};
        for(int a:arr)
            System.out.print(a+",");
        System.out.println();
        sort(arr);
        for(int a:arr)
            System.out.print(a+",");
        System.out.println();
        //System.out.println("cntSwap : " + cntSwap);

        //unitSort(new int[]{4,2},0,0,1);
    }
}
