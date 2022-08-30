package DataStructure.test;

import javax.sound.midi.SysexMessage;

public class RecursionDemo1 {
    public static void main(String[] args){
        System.out.println(caculateSum_recursion(1, 5));
    }

    // 循环求法
    public static int calculateSum(int start, int end){
        int sum = 0;
        for(int i = start; i <= end; i ++){
            sum += i;
        }
        return sum;
    }
    // 递归求法
    public static int caculateSum_recursion(int start, int end){
        // 1 + 2 + 3 + 4 举例
        // 1 + (2->4)
        // 2 + (3->4)
        // 3 + (4->4)
        // (4->4) == 4

        // 边界条件
        if(start == end){
            return end;
        }
        return start + caculateSum_recursion(start + 1, end);
    }
}
