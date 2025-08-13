/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package courseschedulermsj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author meganpurr
 */
public class ClassQueries {

    private static Connection connection;
    private static PreparedStatement addClass;
    private static PreparedStatement getClassList;

    private static ResultSet resultSet;

    public static void addClass(ClassEntry course) {
        connection = DBConnection.getConnection();
        try {
            addClass = connection.prepareStatement("insert into class (semester, courseCode, seats) values (?, ?, ?)");
            addClass.setString(1, course.getSemester());
            addClass.setString(2, course.getCourseCode());
            addClass.setInt(3, course.getSeats());
            addClass.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public static void removeSeat(String courseCode, String semester) {
        connection = DBConnection.getConnection();
        try {
            PreparedStatement updateSeats = connection.prepareStatement(
                    "UPDATE class SET seats = seats - 1 WHERE coursecode = ? AND semester = ? AND seats > 0"
            );
            updateSeats.setString(1, courseCode);
            updateSeats.setString(2, semester);
            updateSeats.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public static void addSeat(String courseCode, String semester) {
        connection = DBConnection.getConnection();
        try {
            PreparedStatement updateSeats = connection.prepareStatement(
                    "UPDATE class SET seats = seats + 1 WHERE coursecode = ? AND semester = ?"
            );
            updateSeats.setString(1, courseCode);
            updateSeats.setString(2, semester);
            updateSeats.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public static ArrayList<String> getAllClasses(String semester) {
        connection = DBConnection.getConnection();
        ArrayList<String> courseCodes = new ArrayList<String>();
        try {
            getClassList = connection.prepareStatement("select coursecode from class where semester = ?");
            getClassList.setString(1, semester);
            resultSet = getClassList.executeQuery();

            while (resultSet.next()) {
                courseCodes.add(resultSet.getString(1));
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return courseCodes;
    }

    public static int getClassSeats(String semester, String courseCode) {
        connection = DBConnection.getConnection();
        int count = 0;
        try {
            getClassList = connection.prepareStatement("select seats from class where semester = ? and coursecode = ?");
            getClassList.setString(1, semester);
            getClassList.setString(2, courseCode);
            resultSet = getClassList.executeQuery();

            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return count;
    }

    public static void dropClass(String semester, String courseCode) {
        connection = DBConnection.getConnection();
        try {
            getClassList = connection.prepareStatement("delete from class where semester = ? and coursecode = ?");
            getClassList.setString(1, semester);
            getClassList.setString(2, courseCode);
            getClassList.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
