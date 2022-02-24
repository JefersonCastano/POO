/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import java.io.IOException;

/**
 *
 * @author INGESIS
 */
public class DataBase {
    
    private CreateTeacher teachers = new CreateTeacher();
    private CreateSubject subjects = new CreateSubject();
    private CreateStudent students = new CreateStudent();
    
    public void StartDataBase () throws IOException{
        
        getSubjects().CreateList();
        getTeachers().CreateList(subjects.getSubjectList());
        getStudents().CreateList(subjects.getSubjectList());
        
    }

    /**
     * @return the teachers
     */
    public CreateTeacher getTeachers() {
        return teachers;
    }

    /**
     * @param teachers the teachers to set
     */
    public void setTeachers(CreateTeacher teachers) {
        this.teachers = teachers;
    }

    /**
     * @return the subjects
     */
    public CreateSubject getSubjects() {
        return subjects;
    }

    /**
     * @param subjects the subjects to set
     */
    public void setSubjects(CreateSubject subjects) {
        this.subjects = subjects;
    }

    /**
     * @return the students
     */
    public CreateStudent getStudents() {
        return students;
    }

    /**
     * @param students the students to set
     */
    public void setStudents(CreateStudent students) {
        this.students = students;
    }
    
}
