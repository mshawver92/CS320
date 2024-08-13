package TaskClass;

import java.util.HashMap;

public class TaskService {
	
	int idNumber = 0;
	
	public static HashMap<String, Task> tasks = new HashMap<String, Task>();
	
	public void addTaskID(String name, String description) {
		
		String ID = Integer.toString(idNumber);
		Task tTask = new Task(ID, name, description);
		tasks.put(ID, tTask);
		
		++idNumber;
	}
	
	public void deleteTask(String ID) {
		
		if(tasks.containsKey(ID)) {
			tasks.remove(ID);
		}
	}
	
	public void updateTask(String ID, String name, String description) {
		
		if(tasks.containsKey(ID)) {
			
			tasks.get(ID).setName(name);
			tasks.get(ID).setDescription(description);
		}
	}

}
