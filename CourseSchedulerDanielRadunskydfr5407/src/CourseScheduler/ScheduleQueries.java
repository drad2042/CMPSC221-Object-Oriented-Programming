package CourseScheduler;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ScheduleQueries {
    private static Connection connection;
    private static PreparedStatement addScheduleEntry;
    private static PreparedStatement getScheduleByStudent;
    private static ResultSet result;

    public static void addScheduleEntry(ScheduleEntry entry) {
        connection = DBConnection.getConnection();
        
        try {
            addScheduleEntry = connection.prepareStatement("insert into APP.SCHEDULE (SEMESTER, STUDENTID, COURSECODE, STATUS, TIMESTAMP) values (?, ?, ?, ?, ?)");
            addScheduleEntry.setString(1, entry.getSemester());
            addScheduleEntry.setString(2, entry.getStudentID());
            addScheduleEntry.setString(3, entry.getCourseCode());
            addScheduleEntry.setString(4, entry.getStatus());
            addScheduleEntry.setTimestamp(5, entry.getTimestamp());
            addScheduleEntry.executeUpdate();
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public static ArrayList<ScheduleEntry> getScheduleByStudent(String semester, String studentID) {
        ArrayList<ScheduleEntry> schedules = new ArrayList<ScheduleEntry>();
        connection = DBConnection.getConnection();
        
        try {
            getScheduleByStudent = connection.prepareStatement("select semester, coursecode, studentid, status, timestamp from app.schedule where studentid = ? and semester = ?");
            getScheduleByStudent.setString(1, studentID);
            getScheduleByStudent.setString(2, semester);
            result = getScheduleByStudent.executeQuery();
            
            while(result.next()) {
                String getSem = result.getString(1);
                String getCoursecode = result.getString(2);
                String getID = result.getString(3);
                String getStatus = result.getString(4);
                schedules.add(new ScheduleEntry(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getTimestamp(5)));
            }

        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
            
        }
        return schedules;
    }

    public static int getScheduledStudentCount(String currentSemester, String courseCode) {
        int count = 0;
        connection = DBConnection.getConnection();
        
        try {
            getScheduleByStudent = connection.prepareStatement("select STUDENTID from APP.SCHEDULE where SEMESTER = ? and COURSECODE = ?");
            getScheduleByStudent.setString(1, currentSemester);
            getScheduleByStudent.setString(2, courseCode);
            result = getScheduleByStudent.executeQuery();
            
            while(result.next()) {
                count++;
            }
            
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return count;
    }

    public static ArrayList<ScheduleEntry> getScheduledStudentsByCourse(String semester, String courseCode) {
        connection = DBConnection.getConnection();
        ArrayList<ScheduleEntry> newList = new ArrayList<ScheduleEntry>();
        
        try {
            getScheduleByStudent = connection.prepareStatement("select STUDENTID, TIMESTAMP from APP.SCHEDULE where SEMESTER = ? and COURSECODE = ? and STATUS = ?");
            getScheduleByStudent.setString(1, semester);
            getScheduleByStudent.setString(2, courseCode);
            getScheduleByStudent.setString(3, "s");
            result = getScheduleByStudent.executeQuery();
            
            while(result.next()) {
                newList.add(new ScheduleEntry(semester, courseCode, result.getString(1), "s", result.getTimestamp(2)));
            }
            
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        
        return newList;
    }

    public static ArrayList<ScheduleEntry> getWaitlistedStudentsByCourse(String semester, String courseCode) {
        connection = DBConnection.getConnection();
        ArrayList<ScheduleEntry> newList = new ArrayList<ScheduleEntry>();
        
        try {
            getScheduleByStudent = connection.prepareStatement("select studentid, timestamp from app.schedule where semester = ? and courseCode = ? and status = ?");
            getScheduleByStudent.setString(1, semester);
            getScheduleByStudent.setString(2, courseCode);
            getScheduleByStudent.setString(3, "w");
            result = getScheduleByStudent.executeQuery();
            
            while(result.next()) {
                newList.add(new ScheduleEntry(semester, courseCode, result.getString(1), "w", result.getTimestamp(2)));
            }
            
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return newList;
    }

    public static void dropStudentScheduleByCourse(String semester, String studentID, String courseCode) {
        connection = DBConnection.getConnection();
        
        try {
            getScheduleByStudent = connection.prepareStatement("DELETE FROM APP.SCHEDULE WHERE SEMESTER = ? AND STUDENTID = ? AND COURSECODE = ?");
            getScheduleByStudent.setString(1, semester);
            getScheduleByStudent.setString(2, studentID);
            getScheduleByStudent.setString(3, courseCode);
            getScheduleByStudent.executeUpdate();
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public static void dropScheduleByCourse(String semester, String courseCode) {
        connection = DBConnection.getConnection();
        
        try {
            getScheduleByStudent = connection.prepareStatement("delete from app.schedule where semester = ? and coursecode = ?");
            getScheduleByStudent.setString(1, semester);
            getScheduleByStudent.setString(2, courseCode);
            getScheduleByStudent.executeUpdate();
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public static void updateScheduleEntry(String semester, ScheduleEntry entry) {
        connection = DBConnection.getConnection();
        
        try {
            getScheduleByStudent = connection.prepareStatement("update app.schedule set status = 's' where semester = ? and studentid = ? and coursecode = ?");
            getScheduleByStudent.setString(1, semester);
            getScheduleByStudent.setString(2, entry.getStudentID());
            getScheduleByStudent.setString(3, entry.getCourseCode());
            getScheduleByStudent.executeUpdate();
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
