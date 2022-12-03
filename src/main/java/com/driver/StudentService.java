package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentrepository;

    public void addStudents(Student student){
        studentrepository.addStudentsIntoDB(student);
    }

    public void addTeachers(Teacher teacher){
        studentrepository.addTeachersIntoDB(teacher);
    }

    public void addTeacherStudents(String teacherName,String studentName){
        studentrepository.addTeacherStudentsIntoDB(teacherName,studentName);
    }

    public Student getstudentsByName(String name){
        return studentrepository.getStudentByNameFromDB(name);
    }

    public Teacher getTeachersByName(String name){
        return studentrepository.getTeacherByNameFromDB(name);
    }

    public List<String> getStudentsByTeacher(String name){
        return studentrepository.getListOfStudentsByTeacherFromDB(name);
    }

    public List<String> getAllStudents(){
        return studentrepository.getAllStudentsAddedIntoDB();
    }

    public void deleteTeacherAndStudent(String name){
        studentrepository.deleteTeacherAndStudents(name);
    }

    public void deleteAllTeachersAndStudents(){
        studentrepository.deleteAllTeachersAndStudentsFromDB();
    }

}
