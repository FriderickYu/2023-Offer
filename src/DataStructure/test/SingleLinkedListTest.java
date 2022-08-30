package DataStructure.test;

import DataStructure.linear.SequenceList;
import DataStructure.linear.SingleLinkedList;

public class SingleLinkedListTest {
    public static void main(String[] args)
    {
        // 创建单向链表对象
        SingleLinkedList<String> s1 = new SingleLinkedList<>();
        // 测试插入
        s1.insert("姚明");
        s1.insert("科比");
        s1.insert("麦迪");
        s1.insert(1, "詹姆斯");
        for (String s : s1) {
            System.out.println(s);
        }
        System.out.println("-------------------------");
        // 测试获取
        String getResult = s1.get(1);
        System.out.println("索引1的元素是" + getResult);

        // 测试查找
        int index = s1.indexOf("科比");
        System.out.println("科比在第"+ index +"位置");
        // 测试删除
        String removeResult = s1.remove(1);
        System.out.println("删除的元素是" + removeResult);
        for (String s : s1) {
            System.out.println(s);
        }
        System.out.println("-------------------------");
        // 测试清空
        s1.clear();
        for(String s : s1)
        {
            System.out.println(s);
        }
        System.out.println("清空后的元素个数" + s1.length());

    }
}
