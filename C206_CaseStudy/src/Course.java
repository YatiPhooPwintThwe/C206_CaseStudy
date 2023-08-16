
public class Course {

	private String code;
	private String title;
	private String instructor;
	private String day;
	private String time;

	public Course(String code, String title, String instructor, String day, String time) {
		this.code = code;
		this.title = title;
		this.instructor = instructor;
		this.day = day;
		this.time = time;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}