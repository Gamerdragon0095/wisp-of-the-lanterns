
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.gamerdragon525.wisp_of_the_lanterns.block.entity;

import net.gamerdragon525.wisp_of_the_lanterns.block.ModBlocks;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import net.gamerdragon525.wisp_of_the_lanterns.WispOfTheLanterns;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class ModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, WispOfTheLanterns.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> JACK_O_SOUL_LANTERN = register("jack_o_soul_lantern", ModBlocks.JACK_O_SOUL_LANTERN, JackOSoulLanternBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> HAUNTED_PUMPKIN = register("haunted_pumpkin", ModBlocks.HAUNTED_PUMPKIN, JackOSoulLanternBlockEntity::new);

	private static DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JACK_O_SOUL_LANTERN.get(), (blockEntity, side) -> ((JackOSoulLanternBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, HAUNTED_PUMPKIN.get(), (blockEntity, side) -> ((HauntedPumpkinBlockEntity) blockEntity).getItemHandler());
	}
}
