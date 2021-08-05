/*
 * Copyright (c) 2018 superblaubeere27
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package net.superblaubeere27.clientbase.modules.modules.movement;

import com.darkmagician6.eventapi.EventTarget;

import net.minecraft.block.BlockAir;
import net.minecraft.client.Minecraft;
import net.minecraft.util.BlockPos;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.superblaubeere27.clientbase.events.EventPreUpdate;
import net.superblaubeere27.clientbase.events.MotionUpdateEvent;
import net.superblaubeere27.clientbase.modules.Module;
import net.superblaubeere27.clientbase.modules.ModuleCategory;
import net.superblaubeere27.clientbase.notifications.Notification;
import net.superblaubeere27.clientbase.notifications.NotificationManager;
import net.superblaubeere27.clientbase.notifications.NotificationType;

public class AntiVoid extends Module {
	
	private boolean sendNotif = true;
	
    public AntiVoid() {
        super("AntiVoid", "let there be light", ModuleCategory.MOVEMENT);
    }
    


//    
//    @EventTarget
//    public void onMove(MotionUpdateEvent event) {
//    	if (mc.thePlayer.)
//    }
    
    @EventTarget
    private void onUpdate(MotionUpdateEvent e) {

        boolean blockUnderneath = false;
        int i = 0;
        while ((double)i < this.mc.thePlayer.posY + 1.0) { // 2
            BlockPos pos = new BlockPos(this.mc.thePlayer.posX, (double)i, this.mc.thePlayer.posZ);
            if (!(this.mc.theWorld.getBlockState(pos).getBlock() instanceof BlockAir)) {
                blockUnderneath = true;
            }
            ++i;
        }
        if (blockUnderneath) {
        	sendNotif = true;
            return;
        }
        
        if (this.mc.thePlayer.fallDistance < 1.0f) { // 2
            return;
        }
        
        
        if (!this.mc.thePlayer.onGround && !this.mc.thePlayer.isCollidedVertically) {
            this.mc.thePlayer.motionY += 0.07; // 0.07
//            mc.thePlayer.motionX += 0.01;
            mc.thePlayer.motionZ -= 0.02;
            if (sendNotif) {
            	NotificationManager.show(new Notification(NotificationType.WARNING, getName(), "Void Detected", 3));
            	sendNotif = false;
            }

        }

    }

    
}
