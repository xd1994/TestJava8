package com.luopan.test.questions;

import java.time.LocalDateTime;

public class Student {

  public Student(){}

  public Student(Long id, String name, Integer age, String address, LocalDateTime birthday,
      Long classId) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.address = address;
    this.birthday = birthday;
    this.classId = classId;
  }

  private Long id;

  private String name;

  private Integer age;

  private String address;

  private LocalDateTime birthday;

  private Long classId;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public LocalDateTime getBirthday() {
    return birthday;
  }

  public void setBirthday(LocalDateTime birthday) {
    this.birthday = birthday;
  }

  public Long getClassId() {
    return classId;
  }

  public void setClassId(Long classId) {
    this.classId = classId;
  }

  @Override
  public String toString() {
    return "Student{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", age=" + age +
        ", address='" + address + '\'' +
        ", birthday=" + birthday +
        ", classId=" + classId +
        '}';
  }
}
