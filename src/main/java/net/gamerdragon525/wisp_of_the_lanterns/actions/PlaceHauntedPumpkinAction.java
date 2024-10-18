package net.gamerdragon525.wisp_of_the_lanterns.actions;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class PlaceHauntedPumpkinAction {
    public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack, Entity entity) {
        if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("hasEntityData")) {
            if (!world.isClientSide()) {
                BlockPos _bp = BlockPos.containing(x, y, z);
                BlockEntity _blockEntity = world.getBlockEntity(_bp);
                BlockState _bs = world.getBlockState(_bp);
                if (_blockEntity != null) {
                    _blockEntity.getPersistentData().putBoolean("hasEntityData",
                            //(entity.getEntityData().getNonDefaultValues().toString())
                            itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("hasEntityData")
                    );

                    if (!itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("entityName").equals("")){
                        _blockEntity.getPersistentData().putString("entityName",
                                //(entity.getEntityData().getNonDefaultValues().toString())
                                itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("entityName")
                        );
                    }
                    if (!(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("entityHealth") <= 0)) {
                        _blockEntity.getPersistentData().putDouble("entityHealth",
                                itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("entityHealth")
                        );
                    }
                }
                if (world instanceof Level _level)
                    _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
        }
        /*ItemStack itemToSpawn = ItemStack.EMPTY;
        BlockState blockToPlace = Blocks.AIR.defaultBlockState();
        if (!world.isClientSide()) {
            BlockPos _bp = BlockPos.containing(x, y, z);
            BlockEntity _blockEntity = world.getBlockEntity(_bp);
            BlockState _bs = world.getBlockState(_bp);
            if (_blockEntity != null)
                _blockEntity.getPersistentData().putString("entityName", (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("entityName")));
            if (world instanceof Level _level)
                _level.sendBlockUpdated(_bp, _bs, _bs, 3);
        }
        if (!world.isClientSide()) {
            BlockPos _bp = BlockPos.containing(x, y, z);
            BlockEntity _blockEntity = world.getBlockEntity(_bp);
            BlockState _bs = world.getBlockState(_bp);
            if (_blockEntity != null)
                _blockEntity.getPersistentData().putDouble("entityHealth", (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("entityHealth")));
            if (world instanceof Level _level)
                _level.sendBlockUpdated(_bp, _bs, _bs, 3);
        }
        if (!world.isClientSide()) {
            BlockPos _bp = BlockPos.containing(x, y, z);
            BlockEntity _blockEntity = world.getBlockEntity(_bp);
            BlockState _bs = world.getBlockState(_bp);
            if (_blockEntity != null)
                _blockEntity.getPersistentData().putBoolean("hasEntityData", (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("hasEntityData")));
            if (world instanceof Level _level)
                _level.sendBlockUpdated(_bp, _bs, _bs, 3);
        }*/
    }

}
