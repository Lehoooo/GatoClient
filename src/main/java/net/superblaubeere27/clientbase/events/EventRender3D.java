
package net.superblaubeere27.clientbase.events;

import com.darkmagician6.eventapi.events.Event;

public class EventRender3D implements Event {
	private float ticks;

	public EventRender3D() {
	}

	public EventRender3D(float ticks) {
		this.ticks = ticks;
	}

	public float getPartialTicks() {
		return this.ticks;
	}

	public boolean isUsingShaders() {
		return false;
	}
}
