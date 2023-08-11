public class Teacher {

	private String tname;
	private int tage;
	private String tnric;
	private String temail;
	private String tcourse;

	

	
	    // Getters and setters for each attribute

	public Teacher(String tname, String tnric, int tage, String tcourse, String temail) {
		this.tname = tname;
        this.tage = tage;
        this.temail = temail;
        this.tnric= tnric;
        this.tcourse = tcourse;
}
		// TODO Auto-generated constructor stub
	

	public String getTname() {
		return tname;
	}

	public int getTage() {
		return tage;
	}

	public String getTemail() {
		return temail;
	}

	public void setTemail(String temail) {
		this.temail = temail;
	}

	public String getTnric() {
		return tnric;
	}

	public String getTcourse() {
		return tcourse;
	}

	public void setTcourse(String tcourse) {
		this.tcourse = tcourse;
	}

}
//
