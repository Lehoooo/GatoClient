/*
 * Copyright (c) 2018 superblaubeere27
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package net.superblaubeere27.clientbase.modules.modules.render;

import com.darkmagician6.eventapi.EventTarget;

import net.minecraft.client.Minecraft;
import net.superblaubeere27.clientbase.events.MotionUpdateEvent;
import net.superblaubeere27.clientbase.modules.Module;
import net.superblaubeere27.clientbase.modules.ModuleCategory;

public class Fullbright extends Module {
    public Fullbright() {
        super("Fullbright", "let there be light", ModuleCategory.RENDER);
    }
    
    public float CurrentGamma = 1;
    public boolean ShouldChangeGamma = false;
    
    public void onEnable() {
    	ShouldChangeGamma = true;
    	
    }


    public void onDisable() {
    	ShouldChangeGamma = false;
    	
    }
    
    @EventTarget
    public void onMove(MotionUpdateEvent event) {
    	if (ShouldChangeGamma == true) {
    		mc.gameSettings.gammaSetting = 9999;
    		
    	}
    	else if (ShouldChangeGamma == false) {
    		mc.gameSettings.gammaSetting = CurrentGamma;
    	}
    }

    
}
