package com.speedygo55;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class ShoppinglistClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		HandledScreens.<ShoppinglistGUI, ShoppinglistScreen>register(Shoppinglist.SCREEN_HANDLER_TYPE, (gui, inventory, title) -> new ShoppinglistScreen(gui, inventory.player, title));
	}
}