package DataStructure.test;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReversePolishNotionTest {
    public static void main(String[] args) {
        //中缀表达式 3*（17-15）+18/6 的逆波兰表达式如下 6+3=9
        String[] notation = {"3", "17", "15", "-", "*", "18", "6", "/", "+"};
        int result = caculate(notation);
        System.out.println("逆波兰表达式的结果为：" + result);
    }

    private static int caculate(String[] notation) {
        // 定义一个栈对象
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        // 遍历整个逆波兰表达式
        for (String s1 : notation) {
            // 拿到每一个元素
            Integer num1;
            Integer num2;
            // num1和num2的运算结果
            Integer result;
            switch (s1) {
                // 如果遇到的是符号,+,-*,/，则在栈中弹出2个数，进行对应计算，并把结果重新压入栈中
                case "+" -> {
                    num1 = stack.pop();
                    num2 = stack.pop();
                    result = num1 + num2;
                    stack.push(result);
                }
                case "-" -> {
                    num1 = stack.pop();
                    num2 = stack.pop();
                    result = num2 - num1;
                    stack.push(result);
                }
                case "*" -> {
                    num1 = stack.pop();
                    num2 = stack.pop();
                    result = num2 * num1;
                    stack.push(result);
                }
                case "/" -> {
                    num1 = stack.pop();
                    num2 = stack.pop();
                    result = num2 / num1;
                    stack.push(result);
                }
                // 如果碰到的元素是数，则需要将其从String转换成Integer，并压入栈中
                default -> stack.push(Integer.parseInt(s1));
            }
        }
        // 不要忘记最后的计算结果，还在栈中，需要弹出
        return stack.pop();
    }
}
