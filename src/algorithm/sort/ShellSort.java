package algorithm.sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args){
        int[] arr = {80, 30, 60, 40, 20, 10, 50, 70};
        shellSort_divided(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort_divided(int[] arr){
        // gap为步长，每次缩小一半
        for(int gap = arr.length / 2; gap > 0; gap /= 2){
            // 对于每一个组，进行插入排序
            for(int i = 0; i < gap; i ++){
                groupSort(arr, i, gap);
            }
        }
    }

    private static void groupSort(int[] arr, int i, int gap) {
        for(int j = i + gap; j < arr.length; j += gap){
            // 下面的部分类似于插入排序的回溯部分
            if(arr[j] < arr[j - gap]){
                int tmp = arr[j];
                int previous_index = j - gap;
                while(previous_index >= 0 && arr[previous_index] > tmp){
                    arr[previous_index + gap] = arr[previous_index];
                    previous_index -= gap;
                }
                arr[previous_index + gap] = tmp;
            }
        }
    }

}
