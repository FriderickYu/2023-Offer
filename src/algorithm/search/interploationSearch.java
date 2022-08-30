package algorithm.search;

public class interploationSearch {
    public static void main(String[] args)
    {
        int[] array = {10, 14, 19, 26, 27, 31, 33, 35, 42, 44};
        int target = 26;
        System.out.println(interploationSearch.findValue(array, target));
        System.out.println(16 / 17);
    }

    public static int findValue(int[] arr, int target)
    {
        int low = 0;
        int high = arr.length - 1;
        int mid = low + (((target - arr[low]) / (arr[high] - arr[low])) * (high - low));
        while(low <= high)
        {
            if(arr[mid] == target)
            {
                return mid;
            }
            else if(arr[mid] < target)
            {
                low = mid + 1;
                mid = low + (((target - arr[low]) / (arr[high] - arr[low])) * (high - low));
            }
            else if(arr[mid] > target)
            {
                high = mid - 1;
                mid = low + (((target - arr[low]) / (arr[high] - arr[low])) * (high - low));
            }
        }
        return -1;
    }
}
