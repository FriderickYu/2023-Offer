package algorithm.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args){
        int[] arr = {9, 4, 6, 8, 3, 10, 4, 6};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序的结果是");
        System.out.println(Arrays.toString(arr));
    }
    /*
    * arr -- 待排序的数组
    * left -- 数列的左边界，从数组的起始位置开始，初始化为0
    * right -- 数列的右边界，从数组的最后一个位置开始，初始化为arr.length - 1
    * */
    public static void quickSort(int[] arr, int left, int right){
        int i, j;
        // 记录基准值
        int benchmark;
        // 如果左边界>=右边界，直接返回
        if(left >= right){
            return;
        }
        // 基准值初始化为数组内的第一个元素
        benchmark = arr[left];
        i = left;
        j = right;
        while(i < j){
            // 从右往左找比基准值小的数，如果不是则继续往左找
            while(arr[j] >= benchmark && i < j){
                j --;
            }
            // 从左往右找基准值大的数，如果不是则继续往右找
            while(arr[i] <= benchmark && i < j){
                i ++;
            }
            // 将左数列中找到的第一个大于基准值的数，与右数列中找到的第一个小于基准值的数，进行交换
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        // 把基准值放到i位置上
        arr[left] = arr[i];
        arr[i] = benchmark;
        // 对基准数的左数列进行递归
        quickSort(arr, left, j - 1);
        // 对基准数的右数列进行递归
        quickSort(arr, j + 1, right);
    }
}
