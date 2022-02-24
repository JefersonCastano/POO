      
package Model;
import java.io.*;
import java.util.*;
import Library.*;

public class LoginData {  //Crear una funcion para que sea ella la unica que lea archivos para evitar tanta variable
    
        
       
        
    
    public ArrayList<String> ReadUser(String archivo) throws FileNotFoundException, IOException{
        
        ArrayList <String> idUser = new ArrayList<String>();   
        FileLibrary file = new FileLibrary();
        
        idUser = file.SplitList(0, 2, file.ReadFile(archivo)); // Intentar que los int sean mas globales


       return idUser;
    }
    public ArrayList<String> ReadPass(String archivo) throws FileNotFoundException, IOException{
        
        ArrayList <String> password = new ArrayList<String>();   
        FileLibrary file = new FileLibrary();
        
        password = file.SplitList(1, 2, file.ReadFile(archivo)); // Intentar que los int sean mas globales
        
        
       return password;
    }
    
    
    
}
