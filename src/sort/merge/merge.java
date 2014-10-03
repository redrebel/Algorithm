package sort.merge;

/**
 * Merge sort
 * Created by cjred77@gmail.com on 2014. 10. 3..
 *
 * Split each element into partitions of size 1
 * recursively merge adjancent partitions
 *   for i = leftPartStartIndex to rightPartLastIndex
 *     if leftPartHeadValue <= rightPartHeadValue
 *       copy leftPartHeadValue
 *     else : copy rightPartHeadValue
 * copy elements back to original array
 *
 */
public class merge {

    public static void unitSort(int arr[], int s, int m, int e){

        int p1 = m-s+1;
        int p2 = e-m;
        m++;

        int[] leftArr = new int[p1+1];
        int[] rightArr = new int[p2+1];

        leftArr[p1] = Integer.MAX_VALUE;
        rightArr[p2] = Integer.MAX_VALUE;

        for(int i=0;i<p1;i++){
            leftArr[i] = arr[s+i];
        }
        for(int i:leftArr)
            System.out.print(i+",");
        System.out.println();

        for(int i=0;i<p2;i++){
            rightArr[i] = arr[m+i];
        }
        for(int i:rightArr)
            System.out.print(i+",");
        System.out.println();

        int leftIdx = 0;
        int rightIdx = 0;
        for(int i=s;i<=e;i++){
            if(leftArr[leftIdx]<=rightArr[rightIdx]){
                arr[i] = leftArr[leftIdx++];
            }
            else{
                arr[i] = rightArr[rightIdx++];
            }
        }
        System.out.print("result : ");
        for(int i:arr)
            System.out.print(i+",");
        System.out.println();
        System.out.println();

    }

    public static void mergeSort(int arr[], int s, int e){
        if(s<e) {
            int m = (e + s) / 2;

            mergeSort(arr,s,m);
            mergeSort(arr,m+1,e);
            unitSort(arr,s,m,e);
        }
        //System.out.print(arr[s]+",");
    }
    public static void sort(int arr[]){
        mergeSort(arr,0,arr.length-1);
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
