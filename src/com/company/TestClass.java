package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class TestClass {


    public static void main(String[] args) {

        HashSet<String> course = new HashSet<String>();
        List<BaseCourse> baseCourseList = new ArrayList<BaseCourse>();

        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter Course Name & Student Name  & Score : ");
        for (int i = 0; i < 4; i++) {

            String courceName = sc.next();
            String student = sc.next();
            int score = sc.nextInt();
            course.add(courceName);
            baseCourseList.add(new BaseCourse(courceName, student, score));
        }

        int sum = 0;
        int courceCount = 0;
        String studentName = "";
        for (String s : course) {
            for (int j = 0; j < baseCourseList.size(); j++) {
                if (s.contains(baseCourseList.get(j).getName())) {
                    sum += baseCourseList.get(j).getScore();
                    courceCount++;
                    studentName += baseCourseList.get(j).getStudentName() + " ";
                }
            }
            System.out.println("Students Names : "+studentName + ", Course Name:  " + s + ", Avarage : " + (sum / courceCount));
            sum = 0;
            courceCount = 0;
            studentName = "";
        }

    }


}
