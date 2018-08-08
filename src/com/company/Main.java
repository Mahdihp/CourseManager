package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static List<Course> courseList = new ArrayList<>();
    private static List<Student> studentList = new ArrayList<>();
    private static List<CourseStudent> courseStudentList = new ArrayList<>();

    private final static String EXIT = "exit";
    private final static String DELIMITER = " ";

    public static void main(String[] args) {
        readData();
        menuCli();
    }

    private static void menuCli() {
        boolean again = true;
        while (again) {
            System.out.println("0: Exit");
            System.out.println("1: Course List");
            System.out.println("2: Student List");

            int i = scanner.nextInt();
            switch (i) {
                case 0:
                    again = false;
                    break;
                case 1:
                    courseList();
                    break;
                case 2:
                    studentList();
                    break;
                default:
                    System.out.println("wrong number");
            }
        }
    }

    private static void studentList() {
        System.out.println(studentList);
    }

    private static void courseList() {
        System.out.println(courseList);
    }

    public static void readData() {
        while (true) {

            String line = scanner.nextLine();
            if (line.equals(EXIT)) {
                break;
            }

            String[] parts = line.split(DELIMITER);
            if (parts.length < 3)
                throw new IllegalArgumentException("wrong input : " + line);

            Course course = new Course(parts[0]);
            Student student = new Student(parts[1]);
            Double grade = Double.valueOf(parts[2]);
            CourseStudent courseStudent = new CourseStudent(course, student, grade);

            if (!courseList.contains(course))
                courseList.add(course);
            if (!studentList.contains(student))
                studentList.add(student);
            courseStudentList.add(courseStudent);
        }

    }

}
