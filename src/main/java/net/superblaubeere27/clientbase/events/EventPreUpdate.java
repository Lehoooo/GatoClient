package net.superblaubeere27.clientbase.events;

import com.darkmagician6.eventapi.events.Event;

public class EventPreUpdate implements Event {
	private float yaw;
	public static float pitch;
	public double y;
	private boolean ground;
	public static boolean rotatingPitch;

	public EventPreUpdate(float yaw, float pitch, double y, boolean ground) {
		this.yaw = yaw;
		this.pitch = pitch;
		this.y = y;
		this.ground = ground;
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
		this.rotatingPitch = true;
	}

	public double getY() {
		return this.y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public boolean isOnground() {
		return this.ground;
	}

	public void setOnground(boolean ground) {
		this.ground = ground;
	}
}
