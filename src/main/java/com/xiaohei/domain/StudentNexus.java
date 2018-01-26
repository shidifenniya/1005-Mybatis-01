package com.xiaohei.domain;

import java.io.Serializable;

public class StudentNexus implements Serializable {

    private int id;

    private String studentName;

    private String password;

    public StudentNexus() {
    }

    public StudentNexus(String studentName, String password) {
        this.studentName = studentName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "StudentNexus{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
