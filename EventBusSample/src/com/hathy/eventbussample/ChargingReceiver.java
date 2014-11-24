package com.hathy.eventbussample;

import de.greenrobot.event.EventBus;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.format.Time;

public class ChargingReceiver extends BroadcastReceiver {

	private EventBus bus = EventBus.getDefault(); 
	
	@Override
	public void onReceive(Context context, Intent intent) {
		ChargingEvent event = null;
		
		// Get current time
		Time now = new Time();
		now.setToNow();		
		String timeOfEvent = now.format("%H:%M:%S");
		
		String eventData = "@" + timeOfEvent + " this device started ";
		if(intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)){
			event=new ChargingEvent(eventData+"charging.");
		} else if(intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)){
			event=new ChargingEvent(eventData+"discharging.");
		}
		
		// Post the event
		bus.post(event);
	}

}
