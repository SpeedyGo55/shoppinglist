package com.speedygo55;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;

public class ShoppinglistGUI extends SyncedGuiDescription {
    public ShoppinglistGUI(int syncId, PlayerInventory playerInventory, ScreenHandlerContext empty) {
        super(Shoppinglist.SCREEN_HANDLER_TYPE, syncId, playerInventory);

        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(300, 200);

        root.validate(this);
    }
}
