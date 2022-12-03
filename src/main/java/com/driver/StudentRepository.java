package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepository {

    Map<String,Student> studentMap=new HashMap<>();

    Map<String,Teacher> teacherMap=new HashMap<>();

    Map<String, List<String>> teacherStudentMap =new HashMap<>();
    public void addStudentsIntoDB(Student student){
        studentMap.put(student.getName(),student);
    }

    public void addTeachersIntoDB(Teacher teacher){
        teacherMap.put(teacher.getName(), teacher);
    }

    public void addTeacherStudentsIntoDB(String teacherName,String studentName){

        if(studentMap.containsKey(studentName)&&teacherMap.containsKey(teacherName)){
            List<String> currentStudent=new ArrayList<>();
            if(teacherStudentMap.containsKey(teacherName)){
                currentStudent=teacherStudentMap.get(teacherName);
            }
            currentStudent.add(studentName);
            teacherStudentMap.put(teacherName,currentStudent);
        }
    }

    public Student getStudentByNameFromDB(String name){
        return studentMap.get(name);
    }

    public Teacher getTeacherByNameFromDB(String name){
        return teacherMap.get(name);
    }

    public List<String> getListOfStudentsByTeacherFromDB(String name){
        List<String> listOfStudents=new ArrayList<>();
        if(teacherStudentMap.containsKey(name)){
            listOfStudents=teacherStudentMap.get(name);
        }
        return listOfStudents;
    }

    public List<String> getAllStudentsAddedIntoDB(){
        List<String> allstudents=new ArrayList<>();

        for(String studentName:studentMap.keySet()){
            allstudents.add(studentName);
        }

        return allstudents;
    }

    public void deleteTeacherAndStudents(String teacherName){
        List<String> currentStudents=new ArrayList<>();
        if(teacherStudentMap.containsKey(teacherName)) {
            currentStudents = teacherStudentMap.get(teacherName);
            for(String name:currentStudents){
                if(studentMap.containsKey(name)){
                    studentMap.remove(name);
                }
            }
            teacherStudentMap.remove(teacherName);
        }
        if(teacherMap.containsKey(teacherName)){
            teacherMap.remove(teacherName);
        }

    }

    public void deleteAllTeachersAndStudentsFromDB(){
        HashSet<String> allStudents=new HashSet<>();

        for(List<String> teacherName:teacherStudentMap.values()){
            for(String studentName:teacherName){
                allStudents.add(studentName);
            }

        }

        for(String name:allStudents){
            if(studentMap.containsKey(name)){
                studentMap.remove(name);
            }
        }
        for(String teacherName:teacherStudentMap.keySet()){
            if(teacherMap.containsKey(teacherName)) {
                teacherMap.remove(teacherName);
            }
            teacherStudentMap.remove(teacherName);
        }

    }


}
