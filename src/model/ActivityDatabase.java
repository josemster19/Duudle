package model;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;

@Singleton
public class ActivityDatabase {
	private List<Activity> activities;
	private List<Participant> participants;
	
	public ActivityDatabase(){
		this.activities = new ArrayList<>();
		activities.add(new Activity("Room Scape"));
		activities.add(new Activity("Team Sports"));
		activities.add(new Activity("Building"));
		activities.add(new Activity("Cooking"));
		
		this.participants = new ArrayList<>();
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public List<Participant> getParticipants() {
		return participants;
	}
	
	
}
