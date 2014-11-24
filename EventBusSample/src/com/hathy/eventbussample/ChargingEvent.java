package com.hathy.eventbussample;

public class ChargingEvent {
	private String data;
	
	public ChargingEvent(String data){			
		this.data = data;
	}
	
	public String getData(){
		return data;
	}
}
