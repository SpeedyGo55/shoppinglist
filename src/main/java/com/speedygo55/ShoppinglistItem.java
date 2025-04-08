package com.speedygo55;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.function.Function;

public class ShoppinglistItem extends Item {
    @SuppressWarnings("unused")
    public static final Item SHOPPING_LIST = register("shopping_list", ShoppinglistItem::new, new Item.Settings().maxCount(1));

    public ShoppinglistItem(Settings settings) {
        super(settings);
    }

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Shoppinglist.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        // Register the item in the item group.
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((itemGroup) -> itemGroup.add(item));

        // Register the item as a fuel.
        FuelRegistryEvents.BUILD.register((builder, context) -> builder.add(item, 5 * 20));

        return item;
    }

    public static void initialize() {
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        user.sendMessage(Text.of("You used the shopping list!"), true);

        return ActionResult.SUCCESS;
    }

}
