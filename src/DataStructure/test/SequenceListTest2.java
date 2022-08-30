package DataStructure.test;

import DataStructure.linear.SequenceList;

public class SequenceListTest2 {
    public static void main(String[] args)
    {
        SequenceList<String> s1 = new SequenceList<>(3);
        s1.insert("张三");
        s1.insert("赵四");
        s1.insert("王五");
        s1.insert("预留");
        for (String s : s1) {
            System.out.println(s);
        }
    }
}
