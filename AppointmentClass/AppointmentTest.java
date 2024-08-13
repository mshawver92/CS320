package AppointmentClass;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.Calendar;

import AppointmentClass.Appointment;

class AppointmentTest {

	@DisplayName("Test a Good Constructor")
	@Test
	void testGoodAppt() {
		
		String ID = "5";
		Calendar c = Calendar.getInstance();
		String description = "This is a description";
		
		c.set(Calendar.MONTH, Calendar.SEPTEMBER);
		c.set(Calendar.DATE, 12);
		c.set(Calendar.YEAR, 2025);
		
		Date goodDate = c.getTime();
		
		Appointment tempAppointment = new Appointment(ID, goodDate, description);
		
		assertEquals(5, tempAppointment.getID());
		assertEquals(goodDate, tempAppointment.getDate());
		assertEquals(description, tempAppointment.getDescription());
		
	}
	
	@DisplayName("Test a Bad Constuctor with too long of an ID")
	@Test
	void TestBadID() {
		
		String ID = "555666777888999444";
		Date date = new Date();
		String description = "This is a description";
		
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(ID, date, description);
		});
		
		assertEquals("Invalid ID", exception.getMessage());
	}
	
	
	@DisplayName("Test Null ID")
	@Test
	void testNullID() {
		
		String ID = null;
		Date date = new Date();
		String description = "This is a description";
		
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(ID, date, description);
		});
		
		assertEquals("Invalid ID", exception.getMessage());
	}
	
	@DisplayName("Test Past Date")
	@Test
	void testPastDate() {
		
		String ID = "5";
		Calendar c = Calendar.getInstance();
		String description = "This is a description";
		
		c.set(Calendar.MONTH, Calendar.SEPTEMBER);
		c.set(Calendar.DATE, 12);
		c.set(Calendar.YEAR, 1996);
		
		Date pastDate = c.getTime();

		
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(ID, pastDate, description);
		});
		
		assertEquals("Invalid Date", exception.getMessage());
	}
	
	@DisplayName("Test Bad Constructor Null Date")
	@Test
	void testNullDate() {
		
		String ID = "5";
		Date badDate = null;
		String description = "This is a good description";
		
		Calendar c = Calendar.getInstance();
		
		c.set(Calendar.MONTH, Calendar.SEPTEMBER);
		c.set(Calendar.DATE, 12);
		c.set(Calendar.YEAR, 2025);
		
		Date goodDate = c.getTime();
		
		Appointment tempAppointment = new Appointment(ID, goodDate, description);
		
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(ID, badDate, description);
		});
		
		assertEquals("Invalid Date", exception.getMessage());
		
		exception = assertThrows(IllegalArgumentException.class, () -> {
			tempAppointment.setDate(null);
		});
		
		assertEquals("Invalid Date", exception.getMessage());
	}
	
	@DisplayName("Test Too Long of a Description")
	@Test
	void testLongDesc() {
		
		String ID = "5";
		Calendar c = Calendar.getInstance();
		String description = "This is a very looooooong description for it to be valid and should throw an error";
		
		c.set(Calendar.MONTH, Calendar.SEPTEMBER);
		c.set(Calendar.DATE, 12);
		c.set(Calendar.YEAR, 2025);
		
		Date goodDate = c.getTime();
		
		Appointment tempAppointment = new Appointment(ID, goodDate, "test");
		
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(ID, goodDate, description);
		});
		
		exception = assertThrows(IllegalArgumentException.class, () -> {
			tempAppointment.setDescription(description);
		});
		
		assertEquals("Invalid Description", exception.getMessage());
	}
	
	@DisplayName("Test a Null Description")
	@Test
	void testNullDescr() {
		
		String ID = "5";
		Calendar c = Calendar.getInstance();
		String description = null;
		
		c.set(Calendar.MONTH, Calendar.SEPTEMBER);
		c.set(Calendar.DATE, 12);
		c.set(Calendar.YEAR, 2025);
		
		Date goodDate = c.getTime();
		
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			new Appointment (ID, goodDate, description);
		});
		
		assertEquals("Invalid Description", exception.getMessage());
	}
	
	@DisplayName("Test an Empty Description")
	@Test
	void testEmptyDescr() {
		
		String ID = "5";
		Calendar c = Calendar.getInstance();
		String description = "";
		
		c.set(Calendar.MONTH, Calendar.SEPTEMBER);
		c.set(Calendar.DATE, 12);
		c.set(Calendar.YEAR, 2025);
		
		Date goodDate = c.getTime();
		
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(ID, goodDate, description);
		});
		
		assertEquals("Invalid Description", exception.getMessage());
		
	}
}