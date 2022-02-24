package Model;

import java.util.ArrayList;
import Controller.*;
import Library.FileLibrary;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Teacher extends Person {

    
    FileLibrary file = new FileLibrary();
    private ArrayList<Course> courses = new ArrayList<Course>();
    
    public Teacher(String userName, String password , String fullName, String role){
        super(userName, password, fullName, role);
    }
    
    public void asignCourses(Course course){
        getCourses().add(course);
    }
    
    public void AddStudent(String StudentuserName, String password, String studentFullName, String role, String subjects, String courses) throws IOException{
                
        
        if(file.FindWord(StudentuserName, "Data/usersData/dataLoginStudent.txt") == -1){
            
            ArrayList <String> studentData = new ArrayList <String>();

            //to only accept courses under direction by teacher
            if((file.FindWord(subjects, "Data/usersData/teachers/"+userName+".txt")!=-1)&&(file.FindWord(fullName, "Data/subjectsData/"+subjects+"/"+courses+".txt")!=-1)){
                
                studentData.add(StudentuserName);
                studentData.add(password);
                studentData.add(studentFullName);
                studentData.add(role);
                studentData.add("No hay registro");
                studentData.add(subjects);
                studentData.add(courses);
                studentData.add("0,0,0,0");
        
                file.WriteFile("Data/usersData/students/"+StudentuserName+".txt", studentData);
            
                studentData.clear();
                studentData.add(StudentuserName);
                studentData.add(password);
            
                file.WriteFile("Data/usersData/dataLoginStudent.txt", studentData);
                
            }else{
                JOptionPane.showMessageDialog(null, "La materia o curso que desea agregar no esta bajo su direccion.");
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Usuario ya existente.");
        }
        
        //Al llamar la funcion, debajo de esta se debe volver a llamar a la funcion StartDataBase
        //Otras palabras, en el momento en que se de al boton guardar, se debe volver a ejecutar la DataBase
        
        
    }
    
    public void uploadScores(float n1, float n2, float n3, String subjectName, Student student) throws IOException{
        //Hay que permitir solo notas del 1 al 5 Jonas y bastri
        
        float prom = (n1+n2+n3)/3;
        
        String scoreCourse = n1+","+n2+","+n3+","+ prom;
        
        file.WriteScores("Data/usersData/students/"+student.getUserName()+".txt", subjectName, scoreCourse);
        ArrayList <String> studentList = file.ReadFile("Data/usersData/students/"+student.getUserName()+".txt");
        file.FillScores(student, studentList);
        
    }
    
    /**
     * @return the courses
     */
    public ArrayList<Course> getCourses() {
        return courses;
    }

    /**
     * @param courses the courses to set
     */
    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }
    
}