/*
 * Copyright (c) 2018 superblaubeere27
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package net.superblaubeere27.clientbase.modules.modules.combat;

import com.darkmagician6.eventapi.EventTarget;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.superblaubeere27.clientbase.events.MotionUpdateEvent;
import net.superblaubeere27.clientbase.modules.Module;
import net.superblaubeere27.clientbase.modules.ModuleCategory;
import net.superblaubeere27.clientbase.valuesystem.ModeValue;

public class Killaura extends Module {
	private ModeValue shouldAttack = new ModeValue("Mode:", "Players", "Players", "Monsters");

    public Killaura() {
        super("Killaura", "killl", ModuleCategory.COMBAT);
    }
    
    public void onEnable() {
    	
    }
    
    public void onDisable() {
    	
    }
    
        
    @EventTarget
    private void onMove(MotionUpdateEvent event) {
    	if (getState()) {
    		if (shouldAttack.getObject() == 0) {
    		
    		for(Object o: mc.theWorld.loadedEntityList){
    			if(o instanceof EntityPlayer){
    				EntityPlayer ep = (EntityPlayer)o;
    				if(!(ep instanceof EntityPlayerSP) && !ep.isDead && ep.canEntityBeSeen(mc.thePlayer) && mc.thePlayer.getDistanceToEntity(ep) <+ 5){
    					mc.thePlayer.setSprinting(false);
    					mc.thePlayer.swingItem();
    					mc.playerController.attackEntity(mc.thePlayer, ep);
    				}
    			}
    		}
    	}
    		
    		if (shouldAttack.getObject() == 1) {
//        		for(Object o: mc.theWorld.loadedEntityList){
//        			if(o instanceof EntityMob){
//        				EntityMob ep = (EntityMob)o;
//        				if(!(ep instanceof EntityMob) && ep.canEntityBeSeen(mc.thePlayer) && mc.thePlayer.getDistanceToEntity(ep) <+ 5){
//        					mc.thePlayer.setSprinting(false);
//        					mc.thePlayer.swingItem();
//        					mc.playerController.attackEntity(mc.thePlayer, ep);
//        				}
//        			}
//        		}
    			

//					private void getAllTarget() {
//					
//    			mc.playerController.attackEntity(mc.thePlayer, target);
    		}
    		
    		
    	}
    }
}

    

