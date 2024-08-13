package AppointmentClass;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Calendar;
import java.util.Date;


class AppointmentServiceTest {

	@AfterEach
	void tearDown() throws Exception{
		AppointmentService.appointments.clear();
	}
	
	@DisplayName("Add an Appointment")
	@Test
	void testAddAppt() {
		
		String ID = "0";
		String desc = "This is a description";
		Calendar c = Calendar.getInstance();
		
		c.set(Calendar.MONTH, Calendar.DECEMBER);
		c.set(Calendar.DATE, 19);
		c.set(Calendar.DATE, 2024);
		
		Date goodDate = c.getTime();
		
		AppointmentService tempAppointment = new AppointmentService();
		
		assertEquals(0, AppointmentService.appointments.size());
		
		tempAppointment.addAppointment(goodDate, desc);
		
		assertTrue(AppointmentService.appointments.containsKey(ID));
		assertEquals(goodDate, AppointmentService.appointments.get(ID).getDate());
		assertEquals(desc, AppointmentService.appointments.get(ID).getDescription());
		
	}
	
	@DisplayName("Add an Appointment with an Empty Description")
	@Test
	void testAddEmptyDesc() {
		
		String desc = "";
		Calendar c = Calendar.getInstance();
		
		c.set(Calendar.MONTH, Calendar.DECEMBER);
		c.set(Calendar.DATE, 19);
		c.set(Calendar.DATE, 2024);
		
		Date goodDate = c.getTime();
		
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			AppointmentService tempAppointment = new AppointmentService();
			tempAppointment.addAppointment(goodDate, desc);
		});
		
		assertEquals("Invalid Description", exception.getMessage());
	}
	
	@DisplayName("Add an Appointment with a Null Description")
	@Test
	void testNullDesc() {
		
		String desc = null;
		Calendar c = Calendar.getInstance();
		
		c.set(Calendar.MONTH, Calendar.DECEMBER);
		c.set(Calendar.DATE, 19);
		c.set(Calendar.DATE, 2024);
		
		Date goodDate = c.getTime();
		
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			AppointmentService tempAppointment = new AppointmentService();
			tempAppointment.addAppointment(goodDate, desc);
		});
		
		assertEquals("Invalid Description", exception.getMessage());
	}
	
	
	@DisplayName("Test Delete an Appointment")
	@Test
	void testDeleteAppt() {
		
		String ID = "0";
		String desc = "This is a description";
		Calendar c = Calendar.getInstance();
		
		c.set(Calendar.MONTH, Calendar.DECEMBER);
		c.set(Calendar.DATE, 19);
		c.set(Calendar.DATE, 2024);
		
		Date goodDate = c.getTime();
		
		AppointmentService tempAppointment = new AppointmentService();
		
		assertEquals(0, AppointmentService.appointments.size());
		
		tempAppointment.addAppointment(goodDate, desc);
		tempAppointment.addAppointment(goodDate, desc);
		tempAppointment.addAppointment(goodDate, desc);
		
		assertEquals(3, AppointmentService.appointments.size());
		
		tempAppointment.deleteAppointment("1");
		
		assertEquals(2, AppointmentService.appointments.size());
		assertFalse(AppointmentService.appointments.containsKey("1"));
		
		tempAppointment.deleteAppointment("1");
		assertEquals(2, AppointmentService.appointments.size());
	}
	
	@DisplayName("Test Update an Appointment a Good ID")
	@Test
	void testUpdateAppt() {
		
		String ID = "0";
		String desc = "This is a description";
		Calendar c = Calendar.getInstance();
		
		c.set(Calendar.MONTH, Calendar.DECEMBER);
		c.set(Calendar.DATE, 19);
		c.set(Calendar.DATE, 2024);
		
		Date goodDate = c.getTime();
		
		AppointmentService tempAppointment = new AppointmentService();
		
		tempAppointment.addAppointment(goodDate, desc);
		
		tempAppointment.updateAppointment(ID, goodDate, "New Description");
		assertEquals("New Description", AppointmentService.appointments.get(ID).getDescription());
		assertEquals(goodDate, AppointmentService.appointments.get(ID).getDate());
	}
	
	@DisplayName("Test Update Appointment with a Bad ID")
	@Test
	void testUpdateBadID() {
		String ID = "0";
		String desc = "This is a description";
		Calendar c = Calendar.getInstance();
		
		c.set(Calendar.MONTH, Calendar.DECEMBER);
		c.set(Calendar.DATE, 19);
		c.set(Calendar.DATE, 2024);
		
		Date goodDate = c.getTime();
		
		AppointmentService tempAppointment = new AppointmentService();
		
		tempAppointment.addAppointment(goodDate, desc);
		
		tempAppointment.updateAppointment("1", goodDate, desc);
		assertNotEquals("New Description", AppointmentService.appointments.get(ID).getDescription());
		assertEquals(goodDate, AppointmentService.appointments.get(ID).getDate());
	}

}
