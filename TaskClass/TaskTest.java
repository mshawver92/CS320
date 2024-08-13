package TaskClass;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class TaskTest {

	@AfterEach
	void tearDown() throws Exception{
		TaskService.tasks.clear();
	}
	
	@DisplayName("Add a Task")
	@Test
	void testAddTask() {
		String ID = "0";
		String name = "Rory Targaryen";
		String description = "This is a description";
		
		TaskService tempTask = new TaskService();
		
		assertEquals(0, TaskService.tasks.size());
		
		tempTask.addTaskID(name, description);
		
			assertTrue(TaskService.tasks.containsKey(ID));
			assertEquals(name, TaskService.tasks.get(ID).getName());
			assertEquals(description, TaskService.tasks.get(ID).getDescription());
			
	}
	
	@DisplayName("Test Delete a Contact")
	@Test
	void testDeleteTask() {
		
		String name = "Rory Targaryen";
		String description = "This is a description";
		
		TaskService tempTask = new TaskService();
		
		assertEquals(0, TaskService.tasks.size());
		
		tempTask.addTaskID(name, description);
		tempTask.addTaskID(name, description);
		tempTask.addTaskID(name, description);
		
			assertEquals(3, TaskService.tasks.size());
			
			tempTask.deleteTask("1");
			
			assertEquals(2, TaskService.tasks.size());
			assertFalse(TaskService.tasks.containsKey("1"));
	}
	
	@DisplayName("Test Update a Task with a good ID")
	@Test
	void testUpdateTask() {
		
		String ID = "0";
		String name = "Rory Targaryen";
		String description = "This is a description";
		
		TaskService tempTask = new TaskService();
		
		tempTask.addTaskID(name, description);
		
		tempTask.updateTask(ID, name, "New description");
		assertEquals("New description", TaskService.tasks.get(ID).getDescription());
		assertEquals(name, TaskService.tasks.get(ID).getName());
		
	}
	
	@DisplayName("Test Update Task with a bad ID")
	@Test
	void testBadTaskUpdate() {
		String ID = "0";
		String name = "Rory Targaryen";
		String description = "This is a description";
		
		TaskService tempTask = new TaskService();
		
		tempTask.addTaskID(name, description);
		
		tempTask.updateTask("1", name, "New description");
		assertNotEquals("New description", TaskService.tasks.get(ID).getDescription());
		assertEquals(name, TaskService.tasks.get(ID).getName());
	}


}
