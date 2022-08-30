package algorithm.sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args)
    {
        int[] array = {4, 6, 8, 7, 9, 2, 10, 1};
        for (int i = 0; i < array.length; i++)
        {
            int minIndex = i;
            for(int j = i + 1; j < array.length; j++)
            {
                if(array[minIndex] > array[j])
                {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
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
