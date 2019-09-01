package model;

import java.util.List;

public class Participant {

	private String name;
	private List<Activity> attendingTo;
	
	public Participant(String name, List<Activity> attendingTo) {	
		this.name = name;
		this.attendingTo = attendingTo;
	}

	public List<Activity> getAttendingTo() {
		return attendingTo;
	}
	

	public String getName() {
		return name;
	}

	public boolean isAttendingTo(Activity activity){
		return (this.attendingTo.contains(activity));
	}
	
	
}
