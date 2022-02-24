package Model;

import java.util.ArrayList;

public class Subject {


    
    private String subjectName;
    private ArrayList<Course> courses = new ArrayList<Course>();
    private String nameCourse []= {"A","B","C","D"};  //Modificar para archivos
    private int i=0;
    
    Subject(String subjectName, String teacherUserName){
        this.subjectName = subjectName;
        Course course = new Course(getNameCourse()[getI()], subjectName, teacherUserName);
        i++;
        courses.add(course);
    }
    //Poner restriccion numero de cursos.
    public void addCourse(String teacherName){
        Course course = new Course(getNameCourse()[getI()], getSubjectName(), teacherName);
        getCourses().add(course);
        setI(getI() + 1);
    }

    /**
     * @return the subjectName
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * @param subjectName the subjectName to set
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
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

    /**
     * @return the nameCourse
     */
    public String[] getNameCourse() {
        return nameCourse;
    }

    /**
     * @param nameCourse the nameCourse to set
     */
    public void setNameCourse(String[] nameCourse) {
        this.setNameCourse(nameCourse);
    }

    /**
     * @return the i
     */
    public int getI() {
        return i;
    }

    /**
     * @param i the i to set
     */
    public void setI(int i) {
        this.i = i;
    }
    
    
}
