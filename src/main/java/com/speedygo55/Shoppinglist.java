package com.speedygo55;

import net.fabricmc.api.ModInitializer;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Shoppinglist implements ModInitializer {
	public static final String MOD_ID = "shoppinglist";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static ScreenHandlerType<ShoppinglistGUI> SCREEN_HANDLER_TYPE;
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ShoppinglistItem.initialize();
		SCREEN_HANDLER_TYPE = Registry.register(Registries.SCREEN_HANDLER, Identifier.of(Shoppinglist.MOD_ID, "shopping_list"),
				new ScreenHandlerType<ShoppinglistGUI>((syncId, playerInventory) -> new ShoppinglistGUI(syncId, playerInventory, ScreenHandlerContext.EMPTY),
						FeatureFlags.VANILLA_FEATURES));
		LOGGER.info("Shoppinglist initialized!");
	}
}