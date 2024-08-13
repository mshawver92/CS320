package TaskClass;

public class Task {
	
	private String taskID;
	private String fullName;
	private String description;
	
	private final boolean validateID(String taskID) {
		if(taskID == null || taskID.length() > 10) {
			return false;
		}
		return true;
	}
	
	private final boolean validateName(String fullName) {
		if(fullName == null || fullName.length() > 20 || fullName.equals("")) {
			return false;
		}
		return true;
	}
	
	private final boolean validateDescription(String description) {
		if(description == null || description.length() > 50 || description.equals("")) {
			return false;
		}
		return true;
	}
	
	public Task(String taskID, String fullName, String description) {
		if(!this.validateID(taskID)) {
			throw new IllegalArgumentException("Invalid ID");
		}
		
		if(!this.validateName(fullName)) {
			throw new IllegalArgumentException("Invalid Name");
		}
		
		if(!this.validateDescription(description)) {
			throw new IllegalArgumentException("Invalid Description");
		}
		
		setID(taskID);
		setName(fullName);
		setDescription(description);
	}
	
	public int getTaskID() {
		return Integer.valueOf(taskID);
	}
	
	private void setID(String taskID) {
		this.taskID = taskID;
	}
	
	public String getName() {
		return fullName;
	}
	
	public void setName(String fullName) {
		if(!this.validateName(fullName)) {
			throw new IllegalArgumentException("Invalid Name");
		}
		this.fullName = fullName;
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
