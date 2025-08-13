package courseschedulermsj;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author meganpurr
 */
public class MultiTableQueries 
{
    private static Connection connection;
    private static PreparedStatement getAllClassDescriptions;
    private static ResultSet resultSet;
    private static PreparedStatement getStudents;
    
    public static ArrayList<ClassDescriptions> getAllClassDescriptions(String semester) {
        connection = DBConnection.getConnection();
        ArrayList<ClassDescriptions> classDescriptions = new ArrayList<>();
        try 
        {
            getAllClassDescriptions = connection.prepareStatement(
                "select class.courseCode, description, seats from class, course where semester = ? and class.courseCode = course.courseCode order by class.courseCode"
            );
            getAllClassDescriptions.setString(1, semester);
            resultSet = getAllClassDescriptions.executeQuery();
           
            while (resultSet.next()) 
            {
                String courseCode = resultSet.getString(1);
                String description = resultSet.getString(2);
                int seats = resultSet.getInt(3);
                classDescriptions.add(new ClassDescriptions(courseCode, description, seats));
            }
            return classDescriptions;
        } 
        
        catch (SQLException sqlException) 
        {
            sqlException.printStackTrace();
        }
        return classDescriptions;
    }
    public static ArrayList<StudentEntry> getScheduledStudentsByClass(String semester, String courseCode)
    {   
        ArrayList<StudentEntry> scheduledStudents = new ArrayList<>();
        try{
             PreparedStatement getStudents = connection.prepareStatement("SELECT s.studentid, st.firstname, st.lastname " +
                     "FROM schedule s " +
                     "JOIN student st ON s.studentid = st.studentid " +
                     "WHERE s.status = 's' AND s.coursecode = ? AND s.semester = ?"); {

            getStudents.setString(1, courseCode);
            getStudents.setString(2, semester);

            try (ResultSet resultSet = getStudents.executeQuery()) {
                while (resultSet.next()) {
                    String studentId = resultSet.getString("studentid");
                    String firstName = resultSet.getString("firstname");
                    String lastName = resultSet.getString("lastname");

                    scheduledStudents.add(new StudentEntry(studentId, firstName, lastName));
                }
            }
        }

        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            e.printStackTrace();
        }

        return scheduledStudents;
    }
    public static ArrayList<StudentEntry> getWaitlistedStudentsByClass(String semester, String courseCode) {
        ArrayList<StudentEntry> waitlistedStudents = new ArrayList<>();

        try{
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT s.studentid, st.firstname, st.lastname " +
                     "FROM schedule s " +
                     "JOIN student st ON s.studentid = st.studentid " +
                     "WHERE status = 'w' AND s.coursecode = ? AND s.semester = ?"); 

            preparedStatement.setString(1, courseCode);
            preparedStatement.setString(2, semester);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String studentId = resultSet.getString("studentid");
                    String firstName = resultSet.getString("firstname");
                    String lastName = resultSet.getString("lastname");

                    waitlistedStudents.add(new StudentEntry(studentId, firstName, lastName));
                }
            }

        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            e.printStackTrace();
        }

        return waitlistedStudents;
    }
}