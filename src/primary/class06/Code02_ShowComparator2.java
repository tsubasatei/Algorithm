package primary.class06;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author xt
 * @Desc
 */
public class Code02_ShowComparator2 {

    public static class MyComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
    public static class Student {
        private Integer id;
        private String name;
        private Integer age;

        public Student(String name, Integer id, Integer age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }
    }

    public static class IdComparator implements Comparator<Student> {
        // 如果返回负数，认为第一个参数应该排在前面
        // 如果返回正数，认为第二个参数应该排在前面
        // 如果返回0，认为谁放前面无所谓
        @Override
        public int compare(Student o1, Student o2) {
            return o2.id - o1.id;
        }
    }

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "b";
        System.out.println(str1.compareTo(str2));
        PriorityQueue<Student> heap = new PriorityQueue<>(new IdComparator());
        Student s1 = new Student("张三", 5, 27);
        Student s2 = new Student("李四", 1, 17);
        Student s3 = new Student("王五", 4, 29);
        Student s4 = new Student("赵六", 3, 9);
        Student s5 = new Student("左七", 2, 34);
        heap.add(s1);
        heap.add(s2);
        heap.add(s3);
        heap.add(s4);
        heap.add(s5);
        System.out.println("=========");
        while (!heap.isEmpty()) {
            Student s = heap.poll();
            System.out.println(s.name + ", " + s.id + ", " + s.age);
        }
    }
}
