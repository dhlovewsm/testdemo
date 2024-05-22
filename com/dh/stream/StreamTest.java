package com.dh.stream;

import com.dh.set.Student;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {

        List<Double> scores = new ArrayList<>();
        Collections.addAll(scores, 88.5, 100.0, 60.0, 99.0, 9.5, 99.6, 25.0);

        //找出大于等于60并升序输出
        System.out.println("---------------------------------------");
        scores.stream().filter(x -> x >= 60)
                .sorted()
                .forEach(System.out::println);


        List<Student> students = new ArrayList<>();
        Student s1 = new Student("蜘蛛精", 26, 155.7);
        Student s2 = new Student("蜘蛛精", 26, 155.7);
        Student s3 = new Student("紫霞", 23, 163.9);
        Student s4 = new Student("至尊宝", 25, 167.8);
        Student s5 = new Student("牛魔王", 35, 180.8);
        Student s6 = new Student("牛夫人", 34, 162.8);

        Collections.addAll(students, s1, s2, s3, s4, s5, s6);

        //找出年龄大于等于23，小于等于30的人，并按年龄降序输出
        System.out.println("---------------------------------------");
        students.stream().filter(x -> x.getAge() >= 23 && x.getAge() <= 30)
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .forEach(System.out::println);


        //找出身高最高的前3名输出
        System.out.println("---------------------------------------");
        students.stream()
                .sorted((x1, x2) -> Double.compare(x2.getHeight(), x1.getHeight()))
                .limit(3)
                .forEach(System.out::println);

        //去除身高倒数的2名
        System.out.println("---------------------------------------");
        students.stream()
                .sorted((x1, x2) -> Double.compare(x2.getHeight(), x1.getHeight()))
                .distinct()
                .skip(students.size() - 2)
                .forEach(System.out::println);

        //找出身高超过150的学生名字，去除重复的名字
        System.out.println("---------------------------------------");
        students.stream().filter(x -> x.getHeight() > 150)
                .map(Student::getName)
                .distinct()
                .forEach(System.out::println);

        //计算超过168身高的有几个
        System.out.println("---------------------------------------");
        System.out.println(students.stream().filter(x -> x.getHeight() > 168).count());

        //找出最高的学生，输出
        System.out.println("---------------------------------------");
        System.out.println(students.stream()
                .max((Comparator.comparingDouble(Student::getHeight)))
                .get());

        //找出最矮的学生，输出
        System.out.println("---------------------------------------");
        System.out.println(students.stream()
                .min((Comparator.comparingDouble(Student::getHeight)))
                .get());

        //找出超过170的学生对象，放进新集合中返回
        System.out.println("---------------------------------------");
        List<Student> collect = students.stream().filter(x -> x.getHeight() > 170).collect(Collectors.toList());
        System.out.println(collect);

        //找出身高超过170的学生，把学生的名字和身高放入map集合返回
        System.out.println("---------------------------------------");
        Map<String, Double> map = students.stream().filter(x -> x.getHeight() > 170)
                .distinct()
                .collect(Collectors.toMap(Student::getName, Student::getHeight));
        System.out.println(map);
    }

}
