package com.kir138;

import java.util.ArrayList;
import java.util.Objects;

public class Students {
    /**
     * фамилия;имя;курс;список_оценок(список оценок тоже через ; )
     */
    private String surname;
    private String name;
    private int course;
    private ArrayList grades = new ArrayList<>();

    public Students() {
    }

    public Students(String surname, String name, int course, ArrayList<Integer> grades) {
        this.surname = surname;
        this.name = name;
        this.course = course;
        this.grades = grades;
    }

    public void add(int num) {
        this.grades.add(num);
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Students students = (Students) o;
        return course == students.course && Objects.equals(surname, students.surname) &&
                Objects.equals(name, students.name) && Objects.equals(grades, students.grades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, course, grades);
    }

    @Override
    public String toString() {
        return "Students{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", course=" + course +
                ", res=" + grades +
                '}';
    }

    public String toCSV() {
        return this.surname + ";" + this.name + ";" + this.course + ";" + this.grades;
    }
}
