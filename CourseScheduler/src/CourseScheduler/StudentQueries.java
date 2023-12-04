package CourseScheduler;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentQueries {
    private static Connection connection;
    
    private static PreparedStatement addStudent;
    private static PreparedStatement getAllStudents;
    private static ResultSet result;

    public static void addStudent(StudentEntry student) {
        connection = DBConnection.getConnection();
        try {
            addStudent = connection.prepareStatement("insert into APP.STUDENT (STUDENTID, FIRSTNAME, LASTNAME) values (?, ?, ?)");
            addStudent.setString(1, student.getStudentID());
            addStudent.setString(2, student.getFirstName());
            addStudent.setString(3, student.getLastName());
            addStudent.executeUpdate();
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public static ArrayList<StudentEntry> getAllStudents() {
        ArrayList<StudentEntry> schedules = new ArrayList<StudentEntry>();
        connection = DBConnection.getConnection();
        
        try {
            getAllStudents = connection.prepareStatement("select STUDENTID, FIRSTNAME, LASTNAME from APP.STUDENT");
            result = getAllStudents.executeQuery();
            while(result.next()) {
                schedules.add(new StudentEntry(result.getString(1), result.getString(2), result.getString(3)));
            }

        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
            
        }
        return schedules;
    }

    public static StudentEntry getStudent(String studentID) {
        connection = DBConnection.getConnection();
        
        try {
            getAllStudents = connection.prepareStatement("select STUDENTID, FIRSTNAME, LASTNAME from APP.STUDENT where STUDENTID = ?");
            getAllStudents.setString(1, studentID);
            result = getAllStudents.executeQuery();
            
            result.next();
            return new StudentEntry(result.getString(1), result.getString(2), result.getString(3));
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
    }

    public static void dropStudent(String studentID) {
        connection = DBConnection.getConnection();
        
        try {
            getAllStudents = connection.prepareStatement("delete from APP.STUDENT where STUDENTID = ?");
            getAllStudents.setString(1, studentID);
            getAllStudents.executeUpdate();
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
