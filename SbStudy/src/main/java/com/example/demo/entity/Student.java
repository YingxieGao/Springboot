package com.example.demo.entity;

import java.sql.Date;

public class Student {
    private int SId;
    private String Sname;
    private Date Sage;
    private String Ssex;

    public Student() {
    }

    public int getSId() {
        return SId;
    }

    public void setSId(int SId) {
        this.SId = SId;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public Date getSage() {
        return Sage;
    }

    public void setSage(Date sage) {
        Sage = sage;
    }

    public String getSsex() {
        return Ssex;
    }

    public void setSsex(String ssex) {
        Ssex = ssex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "SId='" + SId + '\'' +
                ", Sname='" + Sname + '\'' +
                ", Sage=" + Sage +
                ", Ssex='" + Ssex + '\'' +
                '}';
    }
}
