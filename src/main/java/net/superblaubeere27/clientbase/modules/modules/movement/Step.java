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

import org.lwjgl.opengl.GL11;

import com.darkmagician6.eventapi.EventTarget;
import com.darkmagician6.eventapi.events.Event;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemEgg;
import net.minecraft.item.ItemEnderPearl;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemSnowball;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.superblaubeere27.clientbase.events.EventRender2D;
import net.superblaubeere27.clientbase.events.EventRender3D;
import net.superblaubeere27.clientbase.events.MotionUpdateEvent;
import net.superblaubeere27.clientbase.injection.interfaces.IMixinMinecraft;
import net.superblaubeere27.clientbase.modules.Module;
import net.superblaubeere27.clientbase.modules.ModuleCategory;
import net.superblaubeere27.clientbase.utils.RenderUtils;
import net.superblaubeere27.clientbase.valuesystem.ModeValue;

public class Step extends Module {
//	private ModeValue modeValue = new ModeValue("Mode:", "Vanilla", "Vanilla", "Hypixel");
    public Step() {
        super("Step", "idk", ModuleCategory.MOVEMENT);
    }
    
//    public void onDisable() {
//        mc.thePlayer.stepHeight = 0.5f;
//  }
    
    @EventTarget
    private void onUpdate(MotionUpdateEvent event) {
    	if (this.getState()) {
            mc.thePlayer.stepHeight = 1.5F;

    	}
    	else if (this.getState() == false) {
          mc.thePlayer.stepHeight = 0.5f;

    	}
    }
}

