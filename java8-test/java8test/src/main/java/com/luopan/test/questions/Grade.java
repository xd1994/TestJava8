package com.luopan.test.questions;

public class Grade {

  public Grade(){

  }

  public Grade(Long id, Long studentId, Double grade, Long subjectId, String subject) {
    this.id = id;
    this.studentId = studentId;
    this.grade = grade;
    this.subjectId = subjectId;
    this.subject = subject;
  }

  private Long id;

  private Long studentId;

  private Double grade;
  /**
   * 课程id
   */
  private Long subjectId;
  /**
   * 课程
   */
  private String subject;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getStudentId() {
    return studentId;
  }

  public void setStudentId(Long studentId) {
    this.studentId = studentId;
  }

  public Double getGrade() {
    return grade;
  }

  public void setGrade(Double grade) {
    this.grade = grade;
  }

  public Long getSubjectId() {
    return subjectId;
  }

  public void setSubjectId(Long subjectId) {
    this.subjectId = subjectId;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  @Override
  public String toString() {
    return "Grade{" +
        "id=" + id +
        ", studentId=" + studentId +
        ", grade=" + grade +
        ", subjectId=" + subjectId +
        ", subject='" + subject + '\'' +
        '}';
  }
}
