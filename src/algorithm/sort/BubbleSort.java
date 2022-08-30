package algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args)
    {
        int[] array = {4, 5, 6, 3, 2, 1};
        for(int i = array.length - 1; i >= 0; i --)
        {
            for(int j = 0; j < i; j ++)
            {
                if(array[j] > array[j + 1])
                {
                    BubbleSort.swap(array, j, j + 1);
                }
            }
        }
        System.out.println(Arrays.toString(array));


    }
    public static void swap(int[] arr, int i, int j)
    {
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

