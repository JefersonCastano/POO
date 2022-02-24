package Model;

import Library.FileLibrary;
import java.io.IOException;
import java.util.ArrayList;

public class Student extends Person{
    
    private FileLibrary file = new FileLibrary();
    
    private String status;
    private ArrayList <String> subjects = new ArrayList<String>();
    private ArrayList <String> courses = new ArrayList<String>();
    
    private float score [][] = new float[4][getCourses().size()]; 
    //El curso es atributo de subject
    
    Student (String userName, String password, String fullName, String role, String subjects, String courses) throws IOException{     
        super(userName, password, fullName, role);
        
        getSubjects().add(subjects);
        getCourses().add(courses);
        status = "No hay registro.";  //Debe ir privado?
    }
    
    void addCourses(String subjects, String courses) throws IOException{
        getSubjects().add(subjects);
        getCourses().add(courses);
                
    }
    
    public void aproveNotes(Student student){
        
        
        boolean allRegis = true;       
        String exactStatus [][]= new String [4][getCourses().size()];
        
        //Verificar si todos los datos estan llenos. Va a tambien crear una matriz que en la fila 4 esta la info de si paso cada curso
        for (int i=0; i<getCourses().size(); i++){
            
            for (int k=0 ; k < 4 ; k++){
                
                if(student.getScore()[k][i]==0) {
                    exactStatus [k][i]="No hay registro.";
                    allRegis = false;
                }
                if(student.getScore()[k][i]>=1 && student.getScore()[k][i]<3) exactStatus [k][i]="Reprobado";
                if(student.getScore()[k][i]>=3) exactStatus [k][i]="Aprobado"; 
            } 
        }
        //Va a sacar el promedio de todas los cursos y va determinar si está aprobado o no (Se puede mostrar el promedio de ser necesario)
        //por ahora va a dar aprobado si el promedio total es mayor a 3.
        
        float prom=0;
        if(allRegis){
            for (int i=0 ; i < getCourses().size() ; i++){
                prom=+student.getScore()[3][i];
            } 
            
            prom=prom/getCourses().size();
            if(prom>=1 && prom<3) status ="Reprobado con una nota de: "+prom;
            if(prom>=3) status ="Aprobado con una nota de: "+prom;
        }
        else status = "No se han registrado todas las notas.";
        
        
    }
    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the courses
     */
    public ArrayList<String> getCourses() {
        return courses;
    }

    /**
     * @param courses the courses to set
     */
    public void setCourses(ArrayList<String> courses) {
        this.courses = courses;
    }

    /**
     * @return the file
     */
    public FileLibrary getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(FileLibrary file) {
        this.file = file;
    }

    /**
     * @return the score
     */
    public float[][] getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(float[][] score) {
        this.score = score;
    }

    /**
     * @return the subjects
     */
    public ArrayList <String> getSubjects() {
        return subjects;
    }

    /**
     * @param subjects the subjects to set
     */
    public void setSubjects(ArrayList <String> subjects) {
        this.subjects = subjects;
    }
}