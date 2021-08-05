package net.superblaubeere27.clientbase.events;

import com.darkmagician6.eventapi.events.*;
import net.minecraft.network.Packet;

public class EventPacketSend implements Event {
    private Packet packet;

    public EventPacketSend(Packet packet) {
        this.packet = packet;
    }

    public Packet getPacket() {
        return this.packet;
    }

    public void setPacket(Packet packet) {
        this.packet = packet;
    }
}
