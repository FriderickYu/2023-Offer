package algorithm.search;

public class binarySearch {
    public static void main(String[] args)
    {
        int[] array = {10, 14, 19, 26, 27, 31, 33, 35, 42, 44};
        int target = 42;
        System.out.println(binarySearch.findValue_recursion(array, target, 0, array.length - 1));
    }

    public static int findValue_recursion(int[] arr, int target, int low, int high)
    {
        int mid = low + (high - low) / 2;

        // 边界条件1
        if(low > high)
        {
            return -1;
        }
        // 边界条件2
        if(arr[mid] == target)
        {
            return mid;
        }
        else if(arr[mid] < target)
        {
            return findValue_recursion(arr, target, mid + 1, high);
        }
        else if(arr[mid] > target)
        {
            return findValue_recursion(arr, target, low, mid - 1);
        }
        return -1;

    }

    public static int findValue(int[] arr, int target)
    {
        int low = 0;
        int high = arr.length - 1;
        int mid = (low + high) / 2;
        while(low <= high)
        {
            if(arr[mid] < target)
            {
                low = mid + 1;
                mid = (low + high) / 2;
            }
            else if(arr[mid] > target)
            {
                high = mid - 1;
                mid = (low + high) / 2;
            }
            else
            {
                return mid;
            }
        }
        return -1;
    }
}
