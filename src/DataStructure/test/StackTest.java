package DataStructure.test;

import DataStructure.linear.Stack;

import java.util.LinkedList;

public class StackTest {
    public static void main(String[] args){
        // 创建栈对象
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        // 返回栈顶元素
        System.out.println("栈顶元素是" + stack.peek());
        // 遍历
        for (String s : stack) {
            System.out.println(s);
        }
        System.out.println("------------------------------");
        // 测试弹栈
        String result = stack.pop();
        System.out.println("弹出的元素是："+result);
        System.out.println("剩余的元素个数："+stack.size());

    }
}
