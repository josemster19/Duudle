package view_controller;

import java.util.*;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.*;

@ManagedBean
@SessionScoped
public class Duudle {
	private String participantName;
	private Map<Activity, Boolean> selectedActivitiesForParticipant = new HashMap<>();
	
	@EJB ActivityDatabase activityDatabase;
		
	public Duudle() {
		this.participantName = "";
		
	}

	

	

	public String getParticipantName() {
		return participantName;
	}

	public void setParticipantName(String participantName) {
		this.participantName = participantName;
	}

	public Map<Activity, Boolean> getSelectedActivitiesForParticipant() {
		return selectedActivitiesForParticipant;
	}
	public void setSelectedActivitiesForParticipant(Map<Activity, Boolean> selectedActivitiesForParticipant) {
		this.selectedActivitiesForParticipant = selectedActivitiesForParticipant;
	}
	
	public ActivityDatabase getActivityDatabase() {
		return activityDatabase;
	}
	
	public void setActivityDatabase(ActivityDatabase activityDatabase) {
		this.activityDatabase = activityDatabase;
	}


	public boolean isFormReadyToSubmit(){
		boolean ready = false;
		
		if(!selectedActivitiesForParticipant.isEmpty() && !participantName.isEmpty()){
			if(selectedActivitiesForParticipant.containsValue(true)) {
				System.out.println("ENTRA");
				ready = true;
			}			
		}
		return ready;
		
}
	
	public void registerParticipantToActivities(){
		List<Activity> attendingTo = new ArrayList<>();
		
		//Añadimos las actividades que sean TRUE
		for(Activity a: selectedActivitiesForParticipant.keySet()) {
			if(selectedActivitiesForParticipant.get(a)) {
				attendingTo.add(a);
			}
		}
		
		Participant participant = new Participant(participantName,attendingTo);
		activityDatabase.getParticipants().add(participant);
	}
}
