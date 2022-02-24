
package Model;

import java.util.ArrayList;

public class Course {
    
    
    private String courseName;
    private String subjectName;
    private String teacherName;
    private ArrayList<Student> students = new ArrayList<Student>();  //Asignar
    
    
    Course (String courseName, String subjectName, String teacherName){
        this.courseName = courseName;
        this.subjectName = subjectName;
        this.teacherName = teacherName;
    }
    
    void addStudent(Student student){
        getStudents().add(student);
    }

    /**
     * @return the courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @param courseName the courseName to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
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
     * @return the teacherName
     */
    public String getTeacherName() {
        return teacherName;
    }

    /**
     * @param teacherName the teacherName to set
     */
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    /**
     * @return the students
     */
    public ArrayList<Student> getStudents() {
        return students;
    }

    /**
     * @param students the students to set
     */
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    /**
     * @return the score
     */

}
