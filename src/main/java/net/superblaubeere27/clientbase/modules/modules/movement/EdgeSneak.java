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


import java.awt.Color;

import com.darkmagician6.eventapi.EventTarget;

import net.minecraft.block.BlockAir;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.superblaubeere27.clientbase.ClientBase;
import net.superblaubeere27.clientbase.events.MotionUpdateEvent;
import net.superblaubeere27.clientbase.events.Render2DEvent;
import net.superblaubeere27.clientbase.modules.Module;
import net.superblaubeere27.clientbase.modules.ModuleCategory;
import net.superblaubeere27.clientbase.utils.RenderUtils;
import net.superblaubeere27.clientbase.modules.modules.render.HUD;

public class EdgeSneak extends Module {
	private BlockPos currentPos;
	private EnumFacing currentFacing;
    FontRenderer fontRenderer = mc.fontRendererObj;
	private String API_KEY = "";
	    public EdgeSneak() {
        super("EdgeSneak", "aaaaaaaa", ModuleCategory.MOVEMENT);
    }
    
    
    
    public void onEnable() {
    	
    }


    public void onDisable() {
    	
    }
    
    private void setBlockAndFacing(BlockPos var1) {
    	if (mc.theWorld.getBlockState(var1.add(0, -1, 0)).getBlock() != Blocks.air) {
    		this.currentPos = var1.add(0, -1, 0);
    		currentFacing = EnumFacing.UP;
    		
    	} else if (mc.theWorld.getBlockState(var1.add(-1, 0, 0)).getBlock() != Blocks.air) {
    		this.currentPos = var1.add(-1, 0, 0);
    		currentFacing = EnumFacing.EAST;
    		
    	} else if (mc.theWorld.getBlockState(var1.add(1, 0, 0)).getBlock() != Blocks.air) {
    		this.currentPos = var1.add(1, 0, 0);
    		currentFacing = EnumFacing.WEST;
    		
    	} else if (mc.theWorld.getBlockState(var1.add(0, 0, -1)).getBlock() != Blocks.air) {
    		this.currentPos = var1.add(0, 0, -1);
    		currentFacing = EnumFacing.SOUTH;
    	} else if (mc.theWorld.getBlockState(var1.add(0, 0, 1)).getBlock() != Blocks.air) {
    		this.currentPos = var1.add(0, 0, 1);
    		currentFacing = EnumFacing.NORTH;
    	} else {
    		currentPos = null;
    		currentFacing = null;
    	}
    	
    	
    }
    
    public static int rainbow(int delay) { //  was private
        double rainbowState = Math.ceil((System.currentTimeMillis() + delay) / 20.0);
        rainbowState %= 360;
        return Color.getHSBColor((float) (rainbowState / 360.0f), 0.8f, 0.7f).getRGB();
    }
    @EventTarget
    private void render2D(Render2DEvent event) {
    	if(this.getState() == true) {
    	BlockPos pos = mc.thePlayer.getPosition().add(0, 0, 0);

        fontRenderer.drawString(mc.theWorld.getBlockState(pos).getBlock().toString(), 4, fontRenderer.FONT_HEIGHT * 3 + 70, rainbow(200), true);
        RenderUtils.rectangle(50, 50, 50, 50, 00000);
    	}
    }

    
    @EventTarget
    public void onMove(MotionUpdateEvent event) {
    	if(this.getState() == true) {
    		BlockPos pos = mc.thePlayer.getPosition().add(0, -1, 0);
//    		mc.thePlayer.sendChatMessage(mc.theWorld.getBlockState(pos).getBlock().toString());
//    		if (mc.theWorld.getBlockState(pos).getBlock() instanceof BlockAir) {
//    			this.setBlockAndFacing(pos);
	        
//    			mc.thePlayer.sendChatMessage("AIR IS NEXT");
//    			mc.thePlayer.setSneaking(true);
//    		}


    	}



    }
}
