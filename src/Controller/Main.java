/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import Model.*;
import java.util.Arrays;
import Library.*; //eliminar despues

/**
 *
 * @author Hamilton Jojoa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        FileLibrary fl = new FileLibrary();
        
        
        DataBase DB = new DataBase();
        DB.StartDataBase();
        
        
        /*System.out.println(DB.getTeachers().getTeacherList().get(0).getFullName());
        
        System.out.println(DB.getTeachers().getTeacherList().get(0).getCourses().get(1).getSubjectName());

        System.out.println(DB.getTeachers().getTeacherList().get(0).getCourses().get(1).getCourseName());
        
        
        System.out.println("---------------------------"); */
        
        //DB.getTeachers().getTeacherList().get(0).uploadScores(2, 5, 3, "Ingles", DB.getStudents().getStudentList().get(2));
        
        //System.out.println(DB.getTeachers().getTeacherList().get(0).getFullName());
        
        /*for(int i=0;i<2;i++){
            
            System.out.println(DB.getSubjects().getSubjectList().get(2).getCourses().get(1).getStudents().get(i).getFullName());
            
        }*/
        
       //DB.getTeachers().getTeacherList().get(0).AddStudent("prueba 1", "prueba123", "Prueba 1", "Estudiante", "Matematicas", "B");
        
        
        
        
        }

    }

