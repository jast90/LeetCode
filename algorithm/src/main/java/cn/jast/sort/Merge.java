package cn.jast.sort;

import java.util.Arrays;

public class Merge {
    private static void splitAndSort(int[] arr, int low, int high) {
        if (low == high) {
            return;
        }
        int mid = (low + high) / 2;
        splitAndSort(arr, low, mid);
        splitAndSort(arr, mid + 1, high);
        merge1(arr, low, mid, high);
    }

    private static void merge1(int[] arr, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int index = 0;
        int[] temp = new int[arr.length];
        while (i <= mid && j <= high) {
            temp[index++] = arr[i] <= arr[j++] ? arr[i++] : arr[j++];
        }
        while (i <= mid) {
            temp[index++] = arr[i++];
        }
        while (j <= high) {
            temp[index++] = arr[j++];
        }
        for (index = 0; index < arr.length; index++) {
            arr[index] = temp[index];
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,2,8,10,3,1,6,9,5};
        splitAndSort(arr,0,arr.length-1);
        System.out.printf(Arrays.toString(arr));
    }
}
