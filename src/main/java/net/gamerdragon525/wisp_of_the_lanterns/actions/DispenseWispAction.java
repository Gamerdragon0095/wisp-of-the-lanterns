package net.gamerdragon525.wisp_of_the_lanterns.actions;

import net.gamerdragon525.wisp_of_the_lanterns.entity.ModEntities;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class DispenseWispAction {
    public static void execute(LevelAccessor world, double x, double y, double z, Player entity, BlockState blockState) {
        String entityData = "";
        Object displayName_ = new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                BlockEntity blockEntity = world.getBlockEntity(pos);
                if (blockEntity != null)
                    return blockEntity.getPersistentData().getString(tag);
                return "";
            }
        }.getValue(world, BlockPos.containing(x, y, z), "entityName");

        Object currentHealth_ = new Object() {
            public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                BlockEntity blockEntity = world.getBlockEntity(pos);
                if (blockEntity != null)
                    return blockEntity.getPersistentData().getDouble(tag);
                return 0d;
            }
        }.getValue(world, BlockPos.containing(x, y, z), "entityHealth");

        Object currentEffects_ = new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                BlockEntity blockEntity = world.getBlockEntity(pos);
                if (blockEntity != null)
                    return blockEntity.getPersistentData().getString(tag);
                return "";
            }
        }.getValue(world, BlockPos.containing(x, y, z), "entityEffects");

        if ((new Object() {
            public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
                BlockEntity blockEntity = world.getBlockEntity(pos);
                if (blockEntity != null) {
                    return blockEntity.getPersistentData().getBoolean(tag);
                } else {
                    return false;
                }
            }
        }.getValue(world, BlockPos.containing(x, y, z), "hasEntityData")) != false) {
            if (world instanceof ServerLevel _level) {
                Entity entityToSpawn = ModEntities.WISP.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entityToSpawn != null) {
                    entityToSpawn.setCustomName(Component.literal((String) displayName_));
                    if (entityToSpawn instanceof LivingEntity _livEnt) {
                        _livEnt.setHealth((Float) currentHealth_);
                    } else {
                        return;
                    }
                    entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
                    /*if (entityToSpawn instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 60, 1, false, true));
                    }*/
                }
            }

        } else if ((new Object() {
            public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
                BlockEntity blockEntity = world.getBlockEntity(pos);
                if (blockEntity != null) {
                    return blockEntity.getPersistentData().getBoolean(tag);
                } else {
                    return false;
                }
            }
        }.getValue(world, BlockPos.containing(x, y, z), "hasEntityData")) == false) {
            if (world instanceof ServerLevel _level)
                _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
                        "summon wisp_of_the_lanterns:wisp ~ ~ ~");
            if ((entity != null) && (entity instanceof Player _player && !_player.level().isClientSide()))
                _player.displayClientMessage(Component.literal("test"), false);
        }

    }

}


