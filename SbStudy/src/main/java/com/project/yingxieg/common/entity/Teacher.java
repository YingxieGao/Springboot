package com.project.yingxieg.common.entity;


public class Teacher {

  private String uuid;
  private String name;
  private java.sql.Date age;
  private String sex;
  private java.sql.Timestamp createTime;


  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public java.sql.Date getAge() {
    return age;
  }

  public void setAge(java.sql.Date age) {
    this.age = age;
  }


  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }

}
