/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package courseschedulermsj;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author meganpurr
 */
public class StudentEntry 
{

    private String studentID;
    private String firstName;
    private String lastName;

    public StudentEntry(String studentID, String firstName, String lastName) 
    {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public String toString(){
        return lastName+", "+firstName;
    }
    
    public String getStudentID() {return studentID;}

    public String getFirstName() {return firstName;}

    public String getLastName() {return lastName;}
    
    public String lastFirstName() 
    {
    return lastName + ", " + firstName;
}
    }
