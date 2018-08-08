package com.company;

public class CourseStudent {

    private Course course;
    private Student student;
    private Double grade;

    public CourseStudent(Course course, Student student, Double grade) {
        this.course = course;
        this.student = student;
        this.grade = grade;
    }

    public CourseStudent() {
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
}
