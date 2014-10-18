package sort.quick;

/**
 * Created by cjred77@gmail.com on 2014-10-10.
 */
public class Quick {

    /**
     * Left Pivot
     * @param arr
     * @param left
     * @param right
     */
    private static void qsort_left(int[] arr, int left, int right){
        if(left >= right){
            return;
        }
//        for(int a=left;a<=right;a++)
//            System.out.print(arr[a]+",");
//        System.out.println();
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

        qsort_left(arr, pivotIndex, storeIndex-2);
        qsort_left(arr, storeIndex, right);
    }

    private static void qsort_middle(int[] arr, int left, int right){
        int i = left;
        int j = right;
        int pivot = arr[(i+j)/2];

//        for(int a=left;a<=right;a++)
//            System.out.print(arr[a]+",");
//        System.out.println();

        while(i<=j){
            while(arr[i]<pivot) i++;
            while(arr[j]>pivot) j--;

            if(i <= j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }


        if(left<j) qsort_middle(arr,left,j);
        if(i<right) qsort_middle(arr, i, right);

    }

    public static void sort(int[] arr){

        qsort_left(arr,0,arr.length-1);
        qsort_middle(arr, 0, arr.length-1);
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
