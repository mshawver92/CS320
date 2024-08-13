package AppointmentClass;

import java.util.HashMap;
import java.util.Date;


public class AppointmentService {
	
	int currIDNum = 0;
	
	public static HashMap<String, Appointment> appointments = new HashMap<String, Appointment>();
	
	public void addAppointment(Date date, String description) {
		
		String ID = Integer.toString(currIDNum);
		Appointment tempAppointment = new Appointment(ID, date, description);
		appointments.put(ID, tempAppointment);
		
		++currIDNum;
	}
	
	public void deleteAppointment(String ID) {
		
		if(appointments.containsKey(ID)) {
			appointments.remove(ID);
		}
	}
	
	public void updateAppointment(String ID, Date date, String description) {
		if(appointments.containsKey(ID)) {
			appointments.get(ID).setDate(date);
			appointments.get(ID).setDescription(description);
		}
	}

}
