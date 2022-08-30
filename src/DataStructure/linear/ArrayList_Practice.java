package DataStructure.linear;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayList_Practice {
    public static void main(String[] args)
    {
        ArrayList<String> list = new ArrayList<String>();

        // 增加元素
        list.add("Item1");
        list.add("Item2");

        // 将元素放到指定索引位置上
        list.add(2, "Item3");
        list.add("Item4");
        System.out.println("The arraylist contains the following elements: " + list);

        // 检查元素的位置
        int pos = list.indexOf("Item2");
        System.out.println("The index of Item2 is: " + pos);

        // 检查数组链表是否为空
        boolean check = list.isEmpty();
        System.out.println("Checking if the arraylist is empty: " + check);

        // 获取链表的大小
        int size = list.size();
        System.out.println("The size of the list is: " + size);

        // 检查数组链表中是否包含某元素
        boolean element = list.contains("Item5");
        System.out.println("Checking if the arraylist contains" +
                "the object Item5: " + element);

        // 遍历ArrayList中的元素
        // 1.循环使用元素的索引和链表的大小
        System.out.println("Retrieving items with loop using index and size list");
        for(int i = 0; i < list.size(); i++)
        {
            System.out.println("Index: " + i + " - Item: " + list.get(i));
        }

        // 2.使用foreach循环
        System.out.println("Retrieving items using foreach loop");
        for(String str : list)
        {
            System.out.println("Item is: " + str);
        }

        // 3.使用迭代器
        // hasNext(): 返回true表示链表中还有元素
        // next(): 返回下一个元素
        System.out.println("Retrieving items using iterator");
        for(Iterator<String> it = list.iterator(); it.hasNext();)
        {
            System.out.println("Item is: " + it.next());
        }

        // 替换元素
        list.set(1, "NewItem");
        System.out.println("The arraylist after the replacement is: " + list);

        // 移除元素
        // 移除第0个位置上的元素
        list.remove(0);
        System.out.println(list);

        // 移除第一次找到的"Item3"的元素
        list.remove("Item3");
        System.out.println("The final contents of the arraylist are: " + list);

        // 将ArrayList转换为Array
        String[] simpleArray = list.toArray(new String[list.size()]);
        System.out.println("The array created after the conversion of our arraylist is: " + Arrays.toString(simpleArray));

    }
}
