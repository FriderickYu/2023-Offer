package DataStructure.linear;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedList_Practice {
    public static void main(String[] args)
    {
        // 创建链表
        LinkedList<String> list = new LinkedList<>();
        // 向链表中添加元素
        list.add("Dog");
        list.add("Cat");
        list.add("Horse");

        LinkedList<String> list2 = new LinkedList<>();
        list2.add("crocodile");
        list2.add("whale");
        // 将list2中所有元素都添加到list当中（将一个链表添加到另一个链表当中）
        list.addAll(list2);
        System.out.println("LinkedList: " + list);
        System.out.println("---------------------------");
        // 访问元素
        String str = list.get(2);
        System.out.println("索引2处的元素:" + str);
        // 遍历整个链表
        // 创建Iterator对象
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next());
            System.out.print(", ");
        }
        // 检查某一元素是否存在于该链表
        if(list.contains("Dog")){
            System.out.println("存在");
        }
        // 修改元素
        list.set(0, "ytq");
        System.out.println("新的链表为:" + list);
        // 删除元素
        list.remove("ytq");
        // list.remove(0);
        System.out.println("新的链表为:" + list);

    }
}
