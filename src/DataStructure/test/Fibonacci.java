package DataStructure.test;

import java.util.ArrayList;
import java.util.HashMap;

// 斐波那契数列求解
public class Fibonacci {
    public static void main(String[] args){
        System.out.println(Fibonacci.caculate(10));
        System.out.println(Fibonacci.caculateRecursion(10));
        System.out.println(Fibonacci.caculateRecursion_Optimization(10));
    }

    // 循环版 时间复杂度O(n)
    public static int caculate(int num){
        if(num < 1){
            return -1;
        }
        else if(num == 1){
            return 0;
        }
        else if(num == 2){
            return 1;
        }
        int low = 0;
        int high = 1;
        int sum = 0;
        for(int i = 3; i <= num; i ++){
            sum = low + high;
            low = high;
            high = sum;
        }
        return sum;
    }

    // 递归版 时间复杂度O(2^n)
    public static int caculateRecursion(int num){
        if(num == 1){
            return 0;
        }
        else if(num == 2){
            return 1;
        }
        else{
            return caculateRecursion(num - 1) + caculateRecursion(num - 2);
        }
    }

    // 递归优化法 时间复杂度O(n)
    // 递归法最大的一个缺点，就是有大量重复计算的节点，这个可以使用HashMap解决
    // 其实key为第几个元素，value为实际的值
    public static int caculateRecursion_Optimization(int num){
        HashMap<Integer, Integer> map = new HashMap<>();
        if(num == 1){
            map.put(1, 0);
            return 0;
        }
        else if(num == 2){
            map.put(2, 1);
            return 1;
        }
        int result = caculateRecursion_Optimization(num - 1) + caculateRecursion_Optimization(num - 2);
        map.put(num, result);
        if(map.containsKey(num)){
            return result;
        }
        return result;
    }
}
