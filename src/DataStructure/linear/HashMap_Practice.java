package DataStructure.linear;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class HashMap_Practice {
    public static void main(String[] args)
    {
        Student s = new Student("Xiao Ming", 99);
        Map<String, Student> map = new HashMap<>();
        // 往HashMap里面放key-value
        map.put("Xiao Ming", s);
        // 通过key来访问value
        Student target = map.get("Xiao Ming");
        System.out.println(target == s); // 是一个对象
        System.out.println(target.score); // 99
        Student another = map.get("Bob"); // null
        System.out.println(another);
        System.out.println(map.containsKey("Xiao Ming")); // 判断是否含有某key
        System.out.println(map.containsValue(s)); // 判断是否含有某value
        System.out.println("-----------------------------------------------");
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("apple", 123);
        map1.put("pear", 456);
        map1.put("banana", 789);
        // 通过key来遍历KeySet
        for (String key : map1.keySet()) {
            Integer value = map1.get(key);
            System.out.println(key + " = " + value);
        }
        System.out.println("-----------------------------------------------");
        // 同时遍历key和value可以使用循环遍历Map对象的entrySet()集合，其包含每一个key-value映射
        for(Map.Entry<String, Integer> entry : map1.entrySet())
        {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " = " + value);
        }
    }
}

class Student{
    public String name;
    public int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}