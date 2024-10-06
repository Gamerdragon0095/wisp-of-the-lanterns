package net.gamerdragon525.wisp_of_the_lanterns.item;

import net.gamerdragon525.wisp_of_the_lanterns.WispOfTheLanterns;
import net.gamerdragon525.wisp_of_the_lanterns.entity.ModEntities;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(WispOfTheLanterns.MODID);

    public static final DeferredItem<Item> TEMP_SPAWN_EGG = ITEMS.register("wisp_spawn_egg", () -> new DeferredSpawnEggItem(ModEntities.WISP, -6241587, -13921357, new Item.Properties()));


    /*public static final DeferredItem<Item> JADE = ITEMS.register("jade",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_JADE = ITEMS.register("raw_jade",
            () -> new Item(new Item.Properties()));*/

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
