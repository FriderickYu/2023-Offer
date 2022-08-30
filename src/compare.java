import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class compare {
    public static void main(String[] args)
    {
        Student s1 = new Student();
        s1.setUsername("ytq");
        s1.setAge(30);
        Student s2 = new Student();
        s2.setUsername("qty");
        s2.setAge(25);
        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        Collections.sort(list, new StuComparator());
        System.out.println(list);
    }

}

class StuComparator implements Comparator<Student>
{

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getAge() - o2.getAge();
    }
}

class Student implements Comparable<Student>{
    private String username;
    private int age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }


    @Override
    public int compareTo(Student o) {
        return this.getAge() - o.getAge();
    }


}