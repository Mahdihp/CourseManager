package com.company;

public class BaseCourse {

    private String name;
    private String studentName;
    private int score;

    public BaseCourse(String name, String studentName, int score) {
        this.name = name;
        this.studentName = studentName;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
