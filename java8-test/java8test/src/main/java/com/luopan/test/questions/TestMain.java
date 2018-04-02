package com.luopan.test.questions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestMain {

  private static List<Student> studentLists = new ArrayList<>();
  private static List<Grade> grades = new ArrayList<>();
  private static List<ClassRoom> classRooms = new ArrayList<>();

  static {
    studentLists.add(new Student(1L,"曹操", 21, "苏州",LocalDateTime.now().minusYears(20) ,1L));
    studentLists.add(new Student(2L,"赵云", 22, "南通",LocalDateTime.now().minusYears(21) ,1L));
    studentLists.add(new Student(3L,"马超", 21, "苏州",LocalDateTime.now().minusYears(20) ,2L));
    studentLists.add(new Student(4L,"黄忠", 24, "镇江",LocalDateTime.now().minusYears(23) ,2L));
    studentLists.add(new Student(5L,"刘备", 25, "无锡",LocalDateTime.now().minusYears(24) ,2L));
    studentLists.add(new Student(6L,"貂蝉", 27, "苏州",LocalDateTime.now().minusYears(26) ,3L));
    studentLists.add(new Student(7L,"张郃", 25, "上海",LocalDateTime.now().minusYears(24) ,3L));
    studentLists.add(new Student(8L,"典韦", 22, "苏州",LocalDateTime.now().minusYears(21) ,3L));
    studentLists.add(new Student(9L,"孙权", 24, "上海",LocalDateTime.now().minusYears(23) ,1L));
    studentLists.add(new Student(10L,"吕布", 28, "苏州",LocalDateTime.now().minusYears(27) ,1L));

    classRooms.add(new ClassRoom(1L,"1班", "001", 4));
    classRooms.add(new ClassRoom(2L,"2班", "002", 4));
    classRooms.add(new ClassRoom(3L,"3班", "003", 4));

    grades.add(new Grade(1L, 1L,80D,1L, "物理"));
    grades.add(new Grade(1L, 1L,90D,1L, "化学"));
    grades.add(new Grade(1L, 2L,86D,1L, "物理"));
    grades.add(new Grade(1L, 2L,59D,1L, "化学"));
    grades.add(new Grade(1L, 3L,89D,1L, "物理"));
    grades.add(new Grade(1L, 3L,95D,1L, "化学"));
    grades.add(new Grade(1L, 4L,87D,1L, "物理"));
    grades.add(new Grade(1L, 4L,86.5D,1L, "化学"));
    grades.add(new Grade(1L, 5L,84.5D,1L, "物理"));
    grades.add(new Grade(1L, 5L,84.5D,1L, "化学"));
    grades.add(new Grade(1L, 6L,56D,1L, "物理"));
    grades.add(new Grade(1L, 6L,84D,1L, "化学"));
    grades.add(new Grade(1L, 7L,92D,1L, "物理"));
    grades.add(new Grade(1L, 7L,79D,1L, "化学"));
    grades.add(new Grade(1L, 8L,88D,1L, "物理"));
    grades.add(new Grade(1L, 8L,95D,1L, "化学"));
    grades.add(new Grade(1L, 9L,95D,1L, "物理"));
    grades.add(new Grade(1L, 9L,98D,1L, "化学"));
    grades.add(new Grade(1L, 10L,100D,1L, "物理"));
    grades.add(new Grade(1L, 10L,92D,1L, "化学"));

  }

  public  static  void CollectionsByGrade(List<Grade> list){
    if(list==null){
      return;
    }
    Collections.sort(list,(s1,s2)->s1.getGrade().compareTo(s2.getGrade()));
    list.foreach(System.out::println);
  }


  public static void main(String[] args) {
    //1. 将成绩单按成绩从高到低排序
    CollectionsByGrade(grades);

    //2. 统计学生都来自哪些不同的城市,（过滤重复）
    List<Student> list1=studentLists.stream().map(i->i.getAddress()).distinct().collect(Collectors.toList());

    //3. 统计来自苏州学生的成绩，从低到高排序
    List<Student> list2=studentLists.stream().filter(str->str.getAddress().equals("苏州")).sorted().collect(Collectors.toList());

    //4. 统计每个班级学生的平均成绩
    IntSummaryStatistics stats = grades.stream().mapToInt((x) -> x.getClassId()).summaryStatistics();
    System.out.println("平均成绩 : " + stats.getGrade().getAverage());
    //5. 如果一个班级有一个学生成绩不及格，这个班级就是差班，统计差班的班级名称（60分及格）
    grades.stream().filter(x->x.getGrade()<60).map(y->y).foreach(System.out::println);


    //6. 判断 是否有上海的学生成绩不及格（60分及格）
    for (Student stu: studentLists) {
       if("上海".equals(stu.getAddress())){
         Long id=stu.getId();
         for (Grade g:grades) {
           if(g.getStudentId==id && g.getGrade()<60){
             System.out.println("来自上海的学生"+stu.getName()+"的成绩不及格！");
           }
         }
       }
    }

    // 7. 统计每位学生的总成绩
    Map<Double,Double> mapStudentToGrade=new HashMap<Double,Double>();
    for (Grade grade: grades){
      if(mapStudentToGrade.contains(grade.getStudentId())){
        Double grades=mapStudentToGrade.get(grade.getStudentId());
        grades+=grade.getGrade();
        mapStudentToGrade.put(grade.getStudentId(),grades);
      }else{
        mapStudentToGrade.put(grade.getStudentId(),0D);
      }
    }
    if(mapStudentToGrade!=null){
      Set<Double> studentKeys=mapStudentToGrade.keySet();
      for (Double d:studentKeys) {
        System.out.println("学号为"+d+"的同学的成绩为"+mapStudentToGrade.get(d));
      }
    }


    // 8.统计物理的最高分，和化学的最低分
    IntSummaryStatistics stats2 = grades.stream().filter(item->"物理".equals(item.getSubject())).summaryStatistics();
    System.out.println("物理最高成绩 : " + stats2.getGrade().getMax());
    IntSummaryStatistics stats3 = grades.stream().filter(item->"化学".equals(item.getSubject())).summaryStatistics();
    System.out.println("化学最低成绩 : " + stats3.getGrade().getMin());

    // 9. 统计94年出生的学生物理最高分
    grades.stream().filter(a->a.getBirthday().before(LocalDate.of(1994,Month.DECEMBER,31)).After(LocalDate.of(1994,Month.JANUARY,1))).filter(sub->sub)

    // 10. 根据班级单位将每位学生进行分组

    Map<Double,List<Student>> mapStudentToClass=new HashMap<>();
    for (Student student: studentLists){
      if(mapStudentToClass.contains(student.getClassId())){
        List<Student> stuList =mapStudentToClass.get(student.getClassId);
        stuList.add(student);
        mapStudentToClass.put(student.getClassId(),stuList);
      }else{
        mapStudentToClass.put(student.getClassId(),new List<Student>());
      }
    }

    // 11. 统计  以85分为单位，物理成绩高于85分的打A, 低于85的打B, 低于60的打 C
    grades.stream().map((gradeItem)->{
      if("物理".equals(gradeItem.getSubject())){

          if(gradeItem.getGrade()>85 ){
            return "A";
          }else if(gradeItem.getGrade()>=60){
            return "B";
          }else{
            return "C";
          }
      }
    }).forEach(System.out::println);

  }

}
