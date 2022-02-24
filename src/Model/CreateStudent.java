
package Model;

import Library.FileLibrary;
import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class CreateStudent {
    
    private ArrayList<Student> StudentList = new ArrayList<Student>();
    
    FileLibrary file = new FileLibrary();
    ArrayList<String> studentSubjects;
    ArrayList<String> studentCourses;
    
    public void CreateList(ArrayList <Subject> subjectList) throws IOException{
        
      
        LoginData userName = new LoginData();
    
        
        ArrayList <String> userList = userName.ReadUser("Data/usersData/dataLoginStudent.txt");
        ArrayList<String> bufferList = new ArrayList<String>();

        for(int i=0; i<userList.size(); i++){
            bufferList = file.ReadFile("Data/usersData/students/"+userList.get(i)+".txt");
            Student student = new Student (bufferList.get(0), bufferList.get(1), bufferList.get(2), bufferList.get(3), bufferList.get(5),bufferList.get(6));
            
            //add student to course
            
            subjectList.get(file.FindWord(bufferList.get(5),"Data/subjectsData/subjects.txt")).getCourses().get(file.FindWord(bufferList.get(6), "Data/subjectsData/"+bufferList.get(5)+"/"+bufferList.get(5)+".txt")).addStudent(student);
            
            studentSubjects = file.SplitList(8, 3, bufferList);
            studentCourses = file.SplitList(9, 3, bufferList);
            
            for(int j=0; j < studentSubjects.size(); j++){
                student.addCourses(studentSubjects.get(j),studentCourses.get(j));
                
                //add student to course
                subjectList.get(file.FindWord(studentSubjects.get(j),"Data/subjectsData/subjects.txt")).getCourses().get(file.FindWord(studentCourses.get(j), "Data/subjectsData/"+studentSubjects.get(j)+"/"+studentSubjects.get(j)+".txt")).addStudent(student);
                
            }
            
           file.FillScores (student, bufferList);
            getStudentList().add(student);
            
        }
        
        
    }

    /**
     * @return the StudentList
     */
    public ArrayList<Student> getStudentList() {
        return StudentList;
    }

    /**
     * @param StudentList the StudentList to set
     */
    public void setStudentList(ArrayList<Student> StudentList) {
        this.StudentList = StudentList;
    }
    
       
       
   

}
