package com.project.yingxieg.common.entity;

import java.io.Serializable;
import java.sql.Date;

public class Student implements Serializable {

    private static final long serialVersionUID = -7377495917766506587L;

    private String SId;
    private String Sname;
    private Date Sage;
    private String Ssex;


    public Student() {
    }

    public String getSId() {
        return SId;
    }

    public void setSId(String SId) {
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
