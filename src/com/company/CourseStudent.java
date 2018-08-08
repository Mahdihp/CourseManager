package com.company;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseStudent that = (CourseStudent) o;
        return Objects.equals(course, that.course) &&
                Objects.equals(grade, that.grade);
    }

    @Override
    public int hashCode() {

        return Objects.hash(course, grade);
    }

    @Override
    public String toString() {
        return "CourseStudent{" +
                "course=" + course +
                ", student=" + student +
                ", grade=" + grade +
                '}';
    }
}
