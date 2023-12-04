package CourseScheduler;

import java.sql.Timestamp;

public class ScheduleEntry {
    private String Semester;
    private String CourseCode;
    private String StudentID;
    private String Status;
    private Timestamp Timestamp;

    public ScheduleEntry(String Semester, String CourseCode, String StudentID, String Status, Timestamp Timestamp) {
        this.Semester = Semester;
        this.CourseCode = CourseCode;
        this.StudentID = StudentID;
        this.Status = Status;
        this.Timestamp = Timestamp;
    }

    public String getSemester() {
        return this.Semester;
    }
    
    public String getCourseCode() {
        return this.CourseCode;
    }
    
    public String getStudentID() {
        return this.StudentID;
    }
    public String getStatus() {
        return this.Status;
    }
    public Timestamp getTimestamp(){
        return this.Timestamp;
    }
}
