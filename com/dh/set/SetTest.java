package com.dh.set;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {


    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(6);
        set.add(5);
        set.add(5);
        set.add(7);
        System.out.println(set);

//        Set<Student> students = new TreeSet<>(new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
////                if (o1.getHeight() > o2.getHeight()){
////                    return 1;
////                } else if (o1.getHeight() < o2.getHeight()) {
////                    return -1;
////                }
////                return 0;
//                return Double.compare(o1.getHeight(), o2.getHeight());
//            }
//        });
        Set<Student> students = new TreeSet<>(Comparator.comparingDouble(Student::getHeight));
        students.add(new Student("蜘蛛精", 20, 165.7));
        students.add(new Student("紫霞", 21, 165.9));
        students.add(new Student("至尊宝", 22, 169.8));
        students.add(new Student("牛魔王", 21, 166.8));
        System.out.println(students);
    }
}
