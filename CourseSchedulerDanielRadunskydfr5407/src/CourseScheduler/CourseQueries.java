package CourseScheduler;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourseQueries {
    private static Connection connection;
    
    private static PreparedStatement addCourse;
    private static PreparedStatement dropCourse;
    private static PreparedStatement getCourseList;
    private static ResultSet result;

    public static ArrayList<CourseEntry> getAllCourses(String semester) {
        connection = DBConnection.getConnection();
        ArrayList<CourseEntry> courses = new ArrayList<CourseEntry>();
        try {
            getCourseList = connection.prepareStatement("select COURSECODE, DESCRIPTION, SEATS from APP.COURSE where SEMESTER = '" + semester + "'");
            getCourseList.setString(0, semester);
            result = getCourseList.executeQuery();
            
            while(result.next()) {
                courses.add(new CourseEntry(result.getString(1), result.getString(2), result.getString(3), result.getInt(4)));
            }
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return courses;
    }

    public static void addCourse(CourseEntry course) {
        connection = DBConnection.getConnection();
        try {
            addCourse = connection.prepareStatement("insert into APP.COURSE (SEMESTER,COURSECODE,DESCRIPTION,SEATS) values (?,?,?,?)");
            addCourse.setString(1, course.getSemester());
            addCourse.setString(2, course.getCourseCode());
            addCourse.setString(3, course.getDescription());
            addCourse.setInt(4, course.getSeats());
            addCourse.executeUpdate();
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public static ArrayList<String> getAllCourseCodes(String semester) {
        connection = DBConnection.getConnection();
        ArrayList<String> courseCodes = new ArrayList<String>();
        try {
            getCourseList = connection.prepareStatement("select COURSECODE from APP.COURSE where SEMESTER = ?");
            getCourseList.setString(1, semester);
            result = getCourseList.executeQuery();
            
            while(result.next())
            {
                courseCodes.add(result.getString(1));
            }
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return courseCodes;
    }

    public static int getCourseSeats(String semester, String courseCode) {
        connection = DBConnection.getConnection();
        int count = 0;
        try {
            getCourseList = connection.prepareStatement("select SEATS from APP.COURSE where SEMESTER = ? and COURSECODE = ?");
            getCourseList.setString(1, semester);
            getCourseList.setString(2, courseCode);
            result = getCourseList.executeQuery();
            
            while(result.next())
                count = result.getInt(1);
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return count;
    }

    public static void dropCourse(String semester, String courseCode) {
        connection = DBConnection.getConnection();
        
        try {
            getCourseList = connection.prepareStatement("delete from APP.COURSE where SEMESTER = ? and COURSECODE = ?");
            getCourseList.setString(1, semester);
            getCourseList.setString(2, courseCode);
            getCourseList.executeUpdate();
        }
        
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
