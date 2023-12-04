package CourseScheduler;


public class CourseEntry {
    private final String Semester;
    private final String CourseCode;
    private final String Description;
    private final int Seats;

    public CourseEntry(String Semester, String CourseCode, String Description, int Seats) {
        this.Semester = Semester;
        this.CourseCode = CourseCode;
        this.Description = Description;
        this.Seats = Seats;
    }

    public String getSemester() {
        return this.Semester;
    }
    
    public String getCourseCode() {
        return this.CourseCode;
    }
    
    public String getDescription() {
        return this.Description;
    }
    
    public int getSeats() {
        return this.Seats;
    }
}
