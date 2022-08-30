package DataStructure.linear;

import java.util.Iterator;

public class SequenceList<T> implements Iterable<T>{
    private T[] elems; // 存储元素的数组
    private int N; // 数组的长度

    public SequenceList(int capacity)
    {
        // 初始化数组
        this.elems = (T[]) new Object[capacity];
        // 初始化长度
        this.N = 0;

    }

    // 清空线性表
    public void clear()
    {
        for (int i = 0; i < elems.length; i++) {
            elems[i] = null;
        }
        N = 0;
    }

    // 判断线性表是否为空表
    public boolean isEmpty()
    {
        return N == 0;
    }

    // 获取线性表的长度
    public int length()
    {
        return  N;
    }

    // 获取指定位置上的元素
    public T get(int i)
    {
        return elems[i];
    }

    // 向线性表末尾添加元素
    public void insert(T t)
    {
        if(N == elems.length)
        {
            resize(2 * elems.length);
        }
        elems[N] = t;
        N ++;
    }

    // 在指定索引i处增加元素
    public void insert(int i, T t)
    {
        if(N == elems.length)
        {
            resize(2 * elems.length);
        }
        for(int index = N; index > i; index --)
        {
            elems[index] = elems[index - 1];
        }
        // 将元素放进i位置
        elems[i] = t;
        // 整体元素个数+1
        N ++;
    }

    // 删除指定索引上的元素，并返回给元素
    public T remove(int i)
    {
        // 先记录索引i处的值
        T current = elems[i];
        // 索引i处后的所有元素均往前移动一位
        for(int index = i; index < N - 1; index ++)
        {
            elems[index] = elems[index + 1];
        }
        // 整体元素个数-1
        N --;
        if(N < elems.length / 4)
        {
            resize(elems.length / 2);
        }
        return current;
    }

    // 查找t元素地由此出现的位置
    public int indexOf(T t)
    {
        for(int i = 0; i < N; i ++)
        {
            if(elems[i].equals(t))
            {
                return i;
            }
        }
        return -1;
    }

    // 根据参数newCapacity，重置数组的大小
    public void resize(int newCapacity)
    {
        // 定义一个临时数组，指向原数组
        T[] temp = elems;
        // 创建新数组
        elems = (T[]) new Object[newCapacity];
        // 把原数组的数据拷贝到新数组即可
        for(int i = 0; i < N; i++)
        {
            elems[i] = temp[i];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new SIteraotr();
    }

    // 定义内部类，实现iterator
    private class SIteraotr implements Iterator{
        private int cursor;

        public SIteraotr() {
            this.cursor = 0;
        }

        @Override
        public boolean hasNext() {
            return cursor < N;
        }

        @Override
        public Object next() {
            return elems[cursor++];
        }
    }
}
