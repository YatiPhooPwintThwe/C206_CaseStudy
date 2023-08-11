public class Attendance {
    private Student student;
    private String courseCode;
    private int lessonNo;
    private String date;
    private char attendanceStatus;

    public Attendance(Student student, String courseCode, int lessonNo, String date, char attendanceStatus) {
        this.student = student;
        this.courseCode = courseCode;
        this.lessonNo = lessonNo;
        this.date = date;
        this.attendanceStatus = attendanceStatus;
    }

    public Student getStudent() {
        return student;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public int getLessonNo() {
        return lessonNo;
    }

    public String getDate() {
        return date;
    }

    public char getAttendanceStatus() {
        return attendanceStatus;
    }
}
