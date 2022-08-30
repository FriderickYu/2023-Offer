package DataStructure.test;

import DataStructure.linear.Stack;

import java.util.ArrayDeque;

public class BracketMatchTest {
    public static void main(String[] args) {
        String str = "上海(长安)()";
        boolean match = isMatch(str);
        System.out.println(str+"中的括号是否匹配："+match);
    }

    private static boolean isMatch(String str) {
        // 创建一个栈对象，用来存储左括号
        Stack<String> stack = new Stack<>();
        // 从左往右挨个遍历字符串，并拿到每一个字符
        for (int i = 0; i < str.length(); i++) {
            String s = str.charAt(i) + "";
            // 判断拿到的字符是否为左括号,是则压入栈中
            if(s.equals("("))
            {
                stack.push(s);
            }
            // 判断拿到的字符是否为右括号，则栈中对应弹出一个左括号
            else if(s.equals(")"))
            {
                String s1 = stack.pop();
                // 判断弹出的结果是否为Null
                if(s1 == null){
                    // 如果为null，则证明左括号少，不匹配
                    return false;
                }
            }
        }
        // 判断栈中是否还存在元素，如果存在，则证明右括号少，不匹配
        if(!stack.isEmpty())
        {
            return false;
        }
        return true;
    }

}
