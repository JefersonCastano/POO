
package Controller;

import Model.*;
import java.io.IOException;
import java.util.ArrayList;

public class LoginController {

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }
    
    private String role="";
   
    public boolean isUserValid(String idUser, String password) throws IOException{
        
        String nameFile="Data/usersData/dataLoginStudent.txt";
        
        LoginData datos = new LoginData();
        ArrayList <String> userList = new ArrayList<String>();
        ArrayList <String> passList = new ArrayList<String>();
        
        
        if (datos.ReadUser(nameFile).indexOf(idUser) != -1){
            userList = datos.ReadUser(nameFile);
            passList = datos.ReadPass(nameFile);
            setRole("Student");
        }
        else {
            nameFile = "Data/usersData/dataLoginTeacher.txt";
            userList = datos.ReadUser(nameFile);
            passList = datos.ReadPass(nameFile);
            setRole("Teacher");
        }


        return ((userList.indexOf(idUser)!=-1)  && (passList.indexOf(password)!=-1)) && ((userList.indexOf(idUser))  == (passList.indexOf(password)));
    }
    
}
