package net.superblaubeere27.clientbase.utils;

import net.minecraft.client.Minecraft;
import net.superblaubeere27.clientbase.utils.ChatUtils;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class Helper {
	public static Minecraft mc = Minecraft.getMinecraft();

	public static void sendMessage(String message) {
	}

	public static boolean onServer(String server) {
		if (!mc.isSingleplayer() && Helper.mc.getCurrentServerData().serverIP.toLowerCase().contains(server)) {
			return true;
		}
		return false;
	}

	public static void sendMessageWithoutPrefix(String string) {
		Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText(string));
	}
}
