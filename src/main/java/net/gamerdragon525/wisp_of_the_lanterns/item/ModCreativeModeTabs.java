package net.gamerdragon525.wisp_of_the_lanterns.item;

import net.gamerdragon525.wisp_of_the_lanterns.WispOfTheLanterns;
import net.gamerdragon525.wisp_of_the_lanterns.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, WispOfTheLanterns.MODID);

    /*public static final Supplier<CreativeModeTab> JADE_ITEMS_TAB = CREATIVE_MODE_TAB.register("jade_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.JADE.get()))
                    .title(Component.translatable("creativetab.experimentmod.jade_items"))
                    .displayItems((ItemDisplayParameters, output) -> {
                        output.accept(ModItems.JADE);
                        output.accept(ModItems.RAW_JADE);

                    }).build());*/

    public static final Supplier<CreativeModeTab> JADE_BLOCKS_TAB = CREATIVE_MODE_TAB.register("wisp_of_the_lanterns_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.JACK_O_SOUL_LANTERN))
                    //.withTabsBefore(ResourceLocation.fromNamespaceAndPath(ExperimentMod.MODID, "jade_items_tab"))
                    .title(Component.translatable("creativetab.wisp_of_the_lanterns.wisp_of_the_lanterns"))
                    .displayItems((ItemDisplayParameters, output) -> {
                        output.accept(ModBlocks.JACK_O_SOUL_LANTERN);
                        output.accept(ModBlocks.HAUNTED_PUMPKIN);
                        output.accept(ModItems.WISP_SPAWN_EGG);
                        output.accept(ModItems.PUMPKIN_MASK);
                        output.accept(ModItems.PUMPKIN_CHUNK);

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
