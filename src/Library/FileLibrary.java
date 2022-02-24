/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

/**
 *
 * @author INGESIS
 */
import java.util.*;
import java.io.*;
import Model.Student;

public class FileLibrary {
    
    public ArrayList<String> ReadFile(String fileName) throws FileNotFoundException, IOException{
        FileReader read;
        String buffer="";
        BufferedReader storage;

        File file= new File(fileName);
        ArrayList <String> fileList = new ArrayList<String>();   
        
       if(!file.exists()) file.createNewFile();
        
       read = new FileReader(file); 
       storage = new BufferedReader(read);
       while(buffer!=null){
           buffer = (String) storage.readLine();
           if(buffer!=null)fileList.add(buffer); 
       }
       storage.close();
       read.close();
       
       return fileList;
    }
    
    public void WriteFile(String fileName, ArrayList<String> info ) throws FileNotFoundException, IOException{    //Al implementar ver que no se pueda repetir usuarios.
        
        //El file name es la direccion del archivo, al ejecutar se manda direccion con userName.txt
        File file = new File(fileName);
        FileWriter writeFile = new FileWriter(file, true);
        PrintWriter line = new PrintWriter(writeFile);
        //If it's a new file
        if(!file.exists()) file.createNewFile();
        
        for(int i=0; i<info.size();i++){
            line.println(info.get(i));
        }
        line.close();
        writeFile.close();       
    }
    
    public ArrayList<String> SplitList(int startPoint, int jump, ArrayList list) throws FileNotFoundException, IOException{
        
         ArrayList <String> splitedList = new ArrayList<String>();  
         
         for (int i = startPoint; i < list.size(); i= i+jump){
             splitedList.add((String) list.get(i));
         }
         
        return splitedList;
    }
    
    public void WriteLine(File file, String info){
        
          try {
          BufferedWriter fwriter=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true), "utf-8"));
          fwriter.write(info + "\r\n");
          fwriter.close();
       } catch (Exception ex) {
          System.out.println(ex.getMessage());
       } 
        
    }
    
    public void DeleteFile(File file){
       
        try {
         
         if(file.exists()){

           if(file.delete())System.out.println("Fichero Borrado con Exito");
         }
     } catch (Exception ex) {
         //Captura un posible error y le imprime en pantalla
          System.out.println(ex.getMessage());
     }
        
    }
    
    public void RewriteLine(String oldFileName, String infToChange, String info){
        File oldFile = new File(oldFileName);
        String newFileName = oldFile.getParent()+"\\123333.txt";
        File newFile = new File(newFileName);
        
        try {
            
            BufferedReader flee= new BufferedReader(new FileReader(oldFile));
            String sLine;                  

            while((sLine=flee.readLine())!=null){
                if(infToChange.equals(sLine)){ 
                    WriteLine(newFile,info);
                }else{
                    WriteLine(newFile,sLine);
                }
            }
                flee.close();          
                DeleteFile(oldFile);
                newFile.renameTo(oldFile);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }   
    }
    
    public int FindWord(String word, String direction) throws IOException{
        
        ArrayList <String> File = ReadFile(direction); 
        
        
            return File.indexOf(word);
        
    }
    
    public void WriteScores(String oldFileDir, String subjectName, String scores){
        File oldFile = new File(oldFileDir);
        String newFileDir = oldFile.getParent()+"\\123333.txt";
        File newFile = new File(newFileDir);
        
        try {
            
            BufferedReader flee= new BufferedReader(new FileReader(oldFile));
            String sLine;   
            int i=0;

            while((sLine=flee.readLine())!=null){
                if(subjectName.equals(sLine)) i++;
                if(i>=1) i++;
                if(i==4) WriteLine(newFile,scores);
                else WriteLine(newFile,sLine);
            }
                flee.close();          
                DeleteFile(oldFile);
                newFile.renameTo(oldFile);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }   
    }
    
    public void FillScores (Student student, ArrayList <String> studentData) throws IOException{
        
        ArrayList <String> scoreList = SplitList(7,3, studentData);
                
        float scores [][]= new float [4][student.getCourses().size()];
        
        for (int i=0; i<student.getCourses().size(); i++){
            
            String coursesScore [] = scoreList.get(i).split(",",4); 
            
            for (int k=0 ; k < 4 ; k++){
                scores [k][i] = Float.parseFloat(coursesScore [k]);
                
            } 
        }
        student.setScore (scores);   
    }
    
}