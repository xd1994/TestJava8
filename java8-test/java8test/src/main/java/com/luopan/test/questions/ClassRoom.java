package com.luopan.test.questions;

public class ClassRoom {

  public ClassRoom(){}

  public ClassRoom(Long id, String roomName, String roomNo, int studentNums) {
    this.id = id;
    this.roomName = roomName;
    this.roomNo = roomNo;
    this.studentNums = studentNums;
  }

  private Long id;

  private String roomName;

  private String roomNo;

  private int studentNums;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getRoomName() {
    return roomName;
  }

  public void setRoomName(String roomName) {
    this.roomName = roomName;
  }

  public String getRoomNo() {
    return roomNo;
  }

  public void setRoomNo(String roomNo) {
    this.roomNo = roomNo;
  }

  public int getStudentNums() {
    return studentNums;
  }

  public void setStudentNums(int studentNums) {
    this.studentNums = studentNums;
  }

  @Override
  public String toString() {
    return "ClassRoom{" +
        "id=" + id +
        ", roomName='" + roomName + '\'' +
        ", roomNo='" + roomNo + '\'' +
        ", studentNums=" + studentNums +
        '}';
  }
}
