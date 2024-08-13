package AppointmentClass;

import java.util.Date;

public class Appointment {
	
	private String ID;
	private Date date;
	private String description;
	
	/**
	 * validates the ID
	 * @param ID
	 * @return boolean
	 */
	
	private final boolean validateID(String ID) {
		if(ID == null || ID.length() > 10) {
			return false;
		}
		return true;
	}
	
	/**
	 * validates the date
	 * @param date
	 * @return boolean
	 */
	private final boolean validateDate(Date date) {
		if(date == null || date.before(new Date())) {
			return false;
		}
		return true;
	}
	
	/**
	 * validates the description
	 * @param description
	 * @return boolean
	 */
	private final boolean validateDescription(String description) {
		if(description == null || description.length() > 50 || description.equals("")) {
			return false;
		}
		return true;
	}
	
	public Appointment(String ID, Date date, String description) {
		if(!this.validateID(ID)) {
			throw new IllegalArgumentException("Invalid ID");
		}
		if(!this.validateDate(date)) {
			throw new IllegalArgumentException("Invalid Date");
		}
		if(!this.validateDescription(description)) {
			throw new IllegalArgumentException("Invalid Description");
		}
		
		setID(ID);
		setDate(date);
		setDescription(description);
	}
	
	public int getID() {
		return Integer.valueOf(ID);
	}
	
	private void setID(String ID) {
		this.ID = ID;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		if(!this.validateDate(date)) {
			throw new IllegalArgumentException("Invalid Date");
		}
		this.date = date;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		if(!this.validateDescription(description)) {
			throw new IllegalArgumentException("Invalid Description");
		}
		this.description = description;
	}

}
