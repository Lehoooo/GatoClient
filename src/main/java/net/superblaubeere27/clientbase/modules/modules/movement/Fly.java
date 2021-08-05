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
import net.superblaubeere27.clientbase.events.MotionUpdateEvent;
import net.superblaubeere27.clientbase.modules.Module;
import net.superblaubeere27.clientbase.modules.ModuleCategory;
import net.superblaubeere27.clientbase.valuesystem.ModeValue;

public class Fly extends Module {
	private ModeValue modeValue = new ModeValue("Mode:", "Vanilla", "Vanilla", "Hypixel");
    public Fly() {
        super("Fly", "idk", ModuleCategory.MOVEMENT);
    }
    
    public boolean ShouldFly = false;
    
    public void onEnable() {
    	ShouldFly = true;
    }
    
    @EventTarget
    private void onMove(MotionUpdateEvent event) {
       	if (ShouldFly == true) {
        	mc.thePlayer.capabilities.isFlying = true;
    	}
    	else {
    		if (mc.thePlayer.capabilities.isCreativeMode == false) {
        		mc.thePlayer.capabilities.isFlying = false;
        		mc.thePlayer.capabilities.allowFlying = false;
    		}
    		else if (mc.thePlayer.capabilities.isCreativeMode == true) {
        		mc.thePlayer.capabilities.allowFlying = true;

    		}
    	}

    }
    public void onDisable() {
    	ShouldFly = false;
    }
}
