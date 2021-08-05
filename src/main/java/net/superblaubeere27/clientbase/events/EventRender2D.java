
package net.superblaubeere27.clientbase.events;

import com.darkmagician6.eventapi.events.Event;

public class EventRender2D implements Event {
	private float partialTicks;

	public EventRender2D(float partialTicks) {
		this.partialTicks = partialTicks;
	}

	public float getPartialTicks() {
		return this.partialTicks;
	}

	public void setPartialTicks(float partialTicks) {
		this.partialTicks = partialTicks;
	}
}
