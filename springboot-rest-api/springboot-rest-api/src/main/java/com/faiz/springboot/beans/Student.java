package com.faiz.springboot.beans;

import java.util.Objects;

public class Student {
    private long id;
    private String name;
    private String college;

    public Student() {
    }
    public Student(long id, String name, String college) {
        this.id = id;
        this.name = name;
        this.college = college;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCollege() {
        return college;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(name, student.name) && Objects.equals(college, student.college);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, college);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", college='" + college + '\'' +
                '}';
    }
}
