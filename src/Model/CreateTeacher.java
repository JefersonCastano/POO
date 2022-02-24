
package Model;

import Model.LoginData;
import Model.*;
import java.util.ArrayList;
import Library.FileLibrary;
import java.io.IOException;


public class CreateTeacher { 
    
    private ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
    
    public void CreateList(ArrayList <Subject> subjectList) throws IOException {
        
        FileLibrary file = new FileLibrary();
        LoginData userName = new LoginData();
    
        
        ArrayList <String> userList = userName.ReadUser("Data/usersData/dataLoginTeacher.txt");
        ArrayList<String> bufferList = new ArrayList<String>();
        
        
        for(int i=0; i<userList.size(); i++){
            
            bufferList = file.ReadFile("Data/usersData/teachers/"+userList.get(i)+".txt");
            Teacher teacher = new Teacher(bufferList.get(0), bufferList.get(1), bufferList.get(2), bufferList.get(3));
            

            for(int j=4; j < bufferList.size(); j+=2){
                
                teacher.asignCourses(subjectList.get(file.FindWord(bufferList.get(j),"Data/subjectsData/subjects.txt")).getCourses().get(file.FindWord(bufferList.get(j+1), "Data/subjectsData/"+bufferList.get(j)+"/"+bufferList.get(j)+".txt")));
                
            } 
            
            getTeacherList().add(teacher);
            
        }
    }

    /**
     * @return the teacherList
     */
    public ArrayList<Teacher> getTeacherList() {
        return teacherList;
    }

    /**
     * @param teacherList the teacherList to set
     */
    public void setTeacherList(ArrayList<Teacher> teacherList) {
        this.teacherList = teacherList;
    }
   
    
    
    
}
