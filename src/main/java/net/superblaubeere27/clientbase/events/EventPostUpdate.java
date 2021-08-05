
package net.superblaubeere27.clientbase.events;

import com.darkmagician6.eventapi.events.Event;

public class EventPostUpdate implements Event {
	private float yaw;
	public static float pitch;
	public static boolean rotatingPitch;

	public EventPostUpdate(float yaw, float pitch) {
		this.yaw = yaw;
		this.pitch = pitch;
	}

	public float getYaw() {
		return this.yaw;
	}

	public void setYaw(float yaw) {
		this.yaw = yaw;
	}

	public float getPitch() {
		return this.pitch;
	}

	public void setPitch(float pitch) {
		this.pitch = pitch;
		rotatingPitch = true;
	}
}
