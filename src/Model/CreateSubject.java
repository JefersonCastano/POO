/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Library.FileLibrary;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author jefit
 */
public class CreateSubject {
    
    
    
    private ArrayList<Subject> subjectList = new ArrayList<Subject>();
    
    
    public void CreateList() throws IOException{
        
        FileLibrary file = new FileLibrary();
        ArrayList <String> subjectList = file.ReadFile("Data/subjectsData/subjects.txt");
        ArrayList<String> bufferList = new ArrayList<String>();
        
        
        for(int i=0; i<subjectList.size(); i++){
            
            ArrayList <String> CourseList = file.ReadFile("Data/subjectsData/"+subjectList.get(i)+"/"+subjectList.get(i)+".txt");
            bufferList = file.ReadFile("Data/subjectsData/"+subjectList.get(i)+"/"+CourseList.get(0)+".txt");
            Subject subject = new Subject (bufferList.get(0), bufferList.get(1));
            
            for (int k=1; k<CourseList.size(); k++){
                bufferList.clear();
                bufferList = file.ReadFile("Data/subjectsData/"+subjectList.get(i)+"/"+CourseList.get(k)+".txt");
                subject.addCourse(bufferList.get(1));
                 
            }
            
            getSubjectList().add(subject);
            
        }
        
    }
    
    
   /**
     * @return the subjectList
     */
    public ArrayList<Subject> getSubjectList() {
        return subjectList;
    }

    /**
     * @param subjectList the subjectList to set
     */
    public void setSubjectList(ArrayList<Subject> subjectList) {
        this.subjectList = subjectList;
    }
    
}

    
