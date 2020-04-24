package cn.jast.sort;

import java.util.Arrays;

public class Merge {
    /**
     * 
     * @param arr
     * @param low 
     * @param high
     */
    private static void mergeSort(int[] arr, int low, int high) {
        if (low == high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge1(arr, low, mid + 1 , high);
    }

    /**
     * 要考虑递归调用
     * 将数组拆分成左右两个数组，右数组包含mid，将左、右数组合并到数组low到high的位置上
     * @param arr
     * @param low
     * @param mid 
     * @param high
     */
    private static void merge1(int[] arr, int low, int mid, int high) {
        int leftSize = mid-low;
        int rightSize = high-mid+1;
        //取出左、右数组
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        int k = low;
        int i;
        for(i = 0;i < leftSize ; i++){
            left[i] = arr[k++];
        }
        k= mid;
        for(i = 0;i < rightSize ;i++){
            right[i] = arr[k++];
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
       
        //合并成拆分的数组到arr中
        i = 0;
        int j = 0;
        int index = low; //！！注意
        while(i < leftSize && j < rightSize){
            if(left[i]<right[j]){
                arr[index++] = left[i++];
            }else{
                arr[index++] = right[j++];
            }
        }
        while(i<leftSize){
            arr[index++] = left[i++];
        }
        while(j<rightSize){
            arr[index++] = right[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,2,8,10,3,1,6,9,5};
        // arr = new int[]{5,6,7,8,1,2,3,4};
        // merge1(arr,0,4,7);
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
