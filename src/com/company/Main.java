package com.company;

import java.util.*;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static List<Course> courseList = new ArrayList<>();
    private static List<Student> studentList = new ArrayList<>();
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
        Double sum = 0d;
        int count = 0;
        for (Student s : studentList) {
            for (CourseStudent cs : courseStudentList) {
                if (s.equals(cs.getStudent())) {
                    sum += cs.getGrade();
                    count++;
                }
            }
            double ave = sum / count;
            System.out.println(s.getName() + "  " + ave);
            count = 0;
            sum = 0d;
        }
    }

    public static double getAvrage(Student s) {
        int sum = 0;
        int count = 0;
        for (CourseStudent cs : courseStudentList) {
            if (s.equals(cs.getStudent())) {
                sum += cs.getGrade();
                count++;
            }
        }
        return sum / count;
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
            double ave = sum / count;
            System.out.println(c.getName() + "  " + ave);
            count = 0;
            sum = 0d;
        }
    }

    private static void courseStudentList() {
        for (CourseStudent cs : courseStudentList)
            System.out.println(cs);
    }

    private static void studentList() {
        Collections.sort(studentList, new StudentAverageComparator());
        for (Student s : studentList)
            System.out.println(s);
    }

    private static void courseList() {
        Collections.sort(courseList);
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

            courseList.add(course);
            studentList.add(student);
            courseStudentList.add(courseStudent);
        }

    }
}

class StudentAverageComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return Double.valueOf(Main.getAvrage(o1) - Main.getAvrage(o2)).intValue();
    }
}