package algorithm.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args)
    {
        int[] array = {4, 3, 2, 10, 12, 1, 5, 6};
        for(int i = 1; i < array.length; i ++)
        {
            for(int j = i; j > 0; j --)
            {
                if(array[j] < array[j - 1])
                {
                    swap(array, j, j - 1);
                }
                else
                {
                    break;
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
