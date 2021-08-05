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

import java.util.ArrayList;
import java.util.Collections;

import org.lwjgl.opengl.GL11;

import com.darkmagician6.eventapi.EventTarget;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.superblaubeere27.clientbase.events.EventRender2D;
import net.superblaubeere27.clientbase.events.MotionUpdateEvent;
import net.superblaubeere27.clientbase.events.Render2DEvent;
import net.superblaubeere27.clientbase.modules.Module;
import net.superblaubeere27.clientbase.modules.ModuleCategory;
import net.superblaubeere27.clientbase.utils.RenderUtils;
import net.superblaubeere27.clientbase.valuesystem.ModeValue;
import net.superblaubeere27.clientbase.valuesystem.NumberValue;

public class SpeedGraph extends Module {
	
    public ArrayList<Double> speeds = new ArrayList<>(Collections.nCopies(50, 0.0));
//	private NumberValue XLocation = new NumberValue<Number>("X LOCATION", 2, 1, 500);
//	private NumberValue YLocation = new NumberValue<Number>("Y LOCATION", 160, 1, 500);

	private int ticks = 5;
	private int maxHeight = 80;
//	private int maxHeight = (int) YLocation.getObject() + 500;


    public SpeedGraph() {
        super("SpeedGraph", "let there be light", ModuleCategory.RENDER);
    }
    
    public void onEnable() {
    }


    public void onDisable() {
        speeds = new ArrayList<>(Collections.nCopies(50, 0.0));
    }
    
    @EventTarget
    private void onUpdate(MotionUpdateEvent e) {
    	if (this.getState()) {


        if (!mc.thePlayer.isEntityAlive()) return;
	    double speed = Math.sqrt(mc.thePlayer.motionX * mc.thePlayer.motionX + mc.thePlayer.motionZ * mc.thePlayer.motionZ) * 100;
//	    speeds.add().0);
//	    mc.thePlayer.sendChatMessage(speeds.size() + "");
        if (speeds.size() > ticks) {
            speeds.remove(0);
        }
        speeds.add(speed);
        

    }
    
  }
    
    
    
    @EventTarget
    private void render2D(Render2DEvent event) {
    	if (this.getState()) {
//    		mc.thePlayer.sendChatMessage("rendering");
	        int posX = 2;
//	        int posX = (int) XLocation.getObject();
//	        int posY = (int) YLocation.getObject();

	        int posY = 160; //  160
	        GL11.glDisable(2929);
	        GL11.glEnable(3042);
	        GL11.glDisable(3553);
	        GL11.glBlendFunc(770, 771);
	        GL11.glDepthMask(true);
	        GL11.glEnable(2848);
	        GL11.glHint(3154, 4354);
	        GL11.glHint(3155, 4354);
	
	        GL11.glBegin(GL11.GL_QUADS);
	            GlStateManager.color(4 / 255.0f, 7 / 255.0f, 32 / 255.0f, 153 / 255.0f);
	            GL11.glVertex2f(1,posY-maxHeight-2);
	            GL11.glVertex2f(1, posY);
	            GL11.glVertex2f(2+speeds.size(), posY); // 2
	            GL11.glVertex2f(2+speeds.size(), posY-maxHeight-2); // 2
	        GL11.glEnd();
	
	        GL11.glEnable(GL11.GL_LINE_SMOOTH);
	        GlStateManager.color(1f, 1f, 1f, 1f);
	        GL11.glBegin(GL11.GL_LINE_STRIP);
	            float lastPoint = posY;
	            for (double speed : speeds) {
	                float pos = MathHelper.clamp_float((float) (posY - speed*2), 160 - maxHeight, 160); // 2
	                GL11.glVertex2f(posX, lastPoint);
	                GL11.glVertex2f(posX, pos);
	                lastPoint = pos;
	                posX++;
	            }
	        GL11.glEnd();
	        GL11.glEnable(3553);
	        GL11.glDisable(3042);
	        GL11.glEnable(2929);
	        GL11.glDisable(2848);
	        GL11.glHint(3154, 4352);
	        GL11.glHint(3155, 4352);
    	}
    }    
}
