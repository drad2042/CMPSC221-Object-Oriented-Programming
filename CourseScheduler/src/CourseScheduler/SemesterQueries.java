package CourseScheduler;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author acv
 */
public class SemesterQueries {
    private static Connection connection;
    private static PreparedStatement addSemester;
    private static PreparedStatement getSemesterList;
    private static ResultSet result;
    
    public static void addSemester(String semester) {
        connection = DBConnection.getConnection();
        
        try {
            addSemester = connection.prepareStatement("insert into APP.SEMESTER (SEMESTER) values (?)");
            addSemester.setString(1, semester);
            addSemester.executeUpdate();
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        
    }
    
    public static ArrayList<String> getSemesterList() {
        connection = DBConnection.getConnection();
        ArrayList<String> semester = new ArrayList<String>();
        
        try {
            getSemesterList = connection.prepareStatement("select SEMESTER from APP.SEMESTER order by SEMESTER");
            result = getSemesterList.executeQuery();
            
            while(result.next()) {
                semester.add(result.getString(1));
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return semester;
        
    }
    
    
}
