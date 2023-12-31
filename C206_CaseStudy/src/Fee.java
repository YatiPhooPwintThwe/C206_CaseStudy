import java.util.Date;

/**
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * mahaa, 11 Aug 2023, 9:33:56 am
 */

/**
 * @author mahaa
 *
 */
public class Fee {
	
    private String studentName;
    private String nric;
	private String courseCode;
	private String feeType;
	private int amount;
	private String month;
	private String dueDate;
	
	public Fee (String studentName, String nric, String courseCode, String feeType, int amount, String month, String dueDate) {
        this.studentName = studentName;
        this.nric = nric;
        this.courseCode = courseCode;
        this.feeType = feeType;
        this.amount = amount;
        this.month= month;
        this.dueDate = dueDate;
	}

        public String getStudentName(){
                return studentName;
        }
        public void setStudentName(String studentName) {
        	this.studentName = studentName;
        }
        
        public String getNric(){
                return nric;
        }
        public void setNric(String nric) {
        	this.nric = nric;
        }
        
        public String getCourseCode() {
        	return courseCode;
        }
        public void setCourseCode(String courseCode) {
        	this.courseCode = courseCode;
        }
        public String getFeeType() {
        	return feeType;
        }
        public void setFeeType(String feeType) {
        	this.feeType = feeType;
        }
        public int getAmount() {
        	return amount;
        }
        public void setAmount(int amount) {
        	this.amount = amount;
        }
        public String getMonth() {
        	return month;
        }
        public void setMonth(String month) {
        	this.month = month;
        }
        public String getDueDate() {
        	return dueDate;
        }
        public void setDue_date(String dueDate) {
        	this.dueDate = dueDate;
        }
	
}
//maha