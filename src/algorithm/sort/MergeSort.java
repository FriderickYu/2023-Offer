package algorithm.sort;

import java.util.Arrays;

public class MergeSort {
    // 将一个数组中的两个相邻有序区间合并成一个
    public static void merge(int[] array, int low, int middle, int high){
        // 临时数组
        int[] tmp = new int[high - low + 1];
        // 第一个区间的头索引
        int i = low;
        // 第二个区间的头索引
        int j = middle + 1;
        // 指向临时数组的索引
        int k = 0;
        // 当i还在第一个区间，且j还在第二个区间时（防止越界）
        while(i <= middle && j <= high){
            if(array[i] <= array[j]){
                tmp[k ++] = array[i ++];
            }
            else{
                tmp[k ++] = array[j ++];
            }
        }
        while(i <= middle){
            tmp[k ++] = array[i ++];
        }
        while(j <= high){
            tmp[k ++] = array[j ++];
        }
        // 将临时数组中排序好的元素，逐个整合到原数组当中
        for(i = 0; i < k; i ++){
            array[low + i] = tmp[i];
        }
    }

    // 归并排序，从上往下
    public static void mergeSortUp2Down(int[] array, int low, int high){
        if(array == null || low >= high){
            return;
        }
        int middle = low + (high - low) / 2;
        mergeSortUp2Down(array, low, middle);
        mergeSortUp2Down(array, middle + 1, high);
        merge(array, low, middle, high);
    }

    public static void main(String[] args){
        int[] array = {80, 30, 60, 40, 20, 10, 50, 70};
        System.out.println("before sort");
        System.out.println(Arrays.toString(array));
        mergeSortUp2Down(array, 0, array.length - 1);
        System.out.println("after sort");
        System.out.println(Arrays.toString(array));
    }
}
