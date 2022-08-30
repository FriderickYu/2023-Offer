package DataStructure.linear;

import javax.swing.plaf.DesktopIconUI;
import java.util.*;
import java.util.Queue;


class test {
    public static void main(String[] args){
        int[] arr = {2, 3, 5, 4, 3, 2, 6, 7};
        System.out.println(findRepeatNumber(arr, 1, arr.length - 1));
    }

    public static int findRepeatNumber(int[] nums, int low, int high) {
        // 数组的长度为nums.length，则元素范围为1~nums.length - 1
        int mid = (low + high) / 2;
        if(low == high){
            return mid;
        }
        int count_lower = 0;
        int count_higher = 0;
        for(Integer i : nums){
            if(i >= low && i <= mid){
                count_lower ++;
            }
            else if(i > mid && i <= high){
                count_higher ++;
            }
        }

        if(count_lower > mid - low + 1){
            return findRepeatNumber(nums, low, mid);

        }
        else if(count_higher > high - mid){
            return findRepeatNumber(nums, mid + 1, high);
        }
        return mid;
    }
}

