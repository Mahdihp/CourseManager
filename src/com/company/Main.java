package com.company;

import java.util.*;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Set<Course> courseList = new HashSet<>();
    private static Set<Student> studentList = new HashSet<>();
    private static Set<CourseStudent> courseStudentList = new HashSet<>();

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
            System.out.println("3: Course Student List");
            System.out.println("4: Avarage Course Score List");
            System.out.println("5: Avarage Student List");

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
                case 3:
                    courseStudentList();
                    break;
                case 4:
                    avarageCourse();
                    break;
                case 5:
                    avarageStudent();
                    break;
                default:
                    System.out.println("wrong number");
            }
        }
    }

    private static void avarageStudent() {
        for ()
    }

    private static void avarageCourse() {
        Double sum = 0d;
        int count = 0;
        for (Course c : courseList) {
            for (CourseStudent cs : courseStudentList) {
                if (c.equals(cs.getCourse())) {
                    sum += cs.getGrade();
                    count++;
                }
            }
            System.out.println(sum / count);
            count = 0;
            sum = 0d;
        }
    }

    private static void courseStudentList() {
        for (CourseStudent cs : courseStudentList)
            System.out.println(cs);
    }

    private static void studentList() {
        for (Student s : studentList)
            System.out.println(s);
    }

    private static void courseList() {
        for (Course c : courseList)
            System.out.println(c);
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
