package com.speedygo55;

import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class ShoppinglistScreen extends CottonInventoryScreen<ShoppinglistGUI> {
    public ShoppinglistScreen(ShoppinglistGUI gui, PlayerEntity player, Text title) {
        super(gui, player, title);

    }
}
