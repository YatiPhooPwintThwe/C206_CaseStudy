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
	
	private String course_code;
	private String fee_type;
	private int amount;
	private String month;
	private Date due_date;
	
	public Fee (String course_code, String fee_type, int amount, String month, Date due_date) {
        this.course_code = course_code;
        this.fee_type = fee_type;
        this.amount = amount;
        this.month= month;
        this.due_date = due_date;
	}

	public String getCourse_code() {
		return course_code;
	}
	public void setCourse_code(String course_code) {
		this.course_code = course_code;
	}
	public String getFee_type() {
		return fee_type;
	}
	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
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
	public Date getDue_date() {
		return due_date;
	}
	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}
	


}
