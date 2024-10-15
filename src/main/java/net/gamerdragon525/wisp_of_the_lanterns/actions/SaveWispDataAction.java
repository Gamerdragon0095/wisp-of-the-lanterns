package net.gamerdragon525.wisp_of_the_lanterns.actions;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.gamerdragon525.wisp_of_the_lanterns.WispOfTheLanterns;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SaveWispDataAction {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        String entityData = "";
        entity.getPersistentData().putString("entityData", (new Object() {
            public String getResult(Entity _ent, String _command) {
                StringBuilder _result = new StringBuilder();
                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                    CommandSource _dataConsumer = new CommandSource() {
                        @Override
                        public void sendSystemMessage(Component message) {
                            _result.append(message.getString());
                        }

                        @Override
                        public boolean acceptsSuccess() {
                            return true;
                        }

                        @Override
                        public boolean acceptsFailure() {
                            return true;
                        }

                        @Override
                        public boolean shouldInformAdmins() {
                            return false;
                        }
                    };
                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(_dataConsumer, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                            _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), _command);
                }
                return _result.toString();
            }
        }.getResult(entity, "data get entity @s")));
        WispOfTheLanterns.queueServerWork(1, () -> {
            if ((entity.getDisplayName().getString()).isEmpty() == false) {
                if (!world.isClientSide()) {
                    BlockPos _bp = BlockPos.containing(x, y, z);
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    BlockState _bs = world.getBlockState(_bp);
                    if (_blockEntity != null) {
                        _blockEntity.getPersistentData().putBoolean("hasEntityData",
                                //(entity.getEntityData().getNonDefaultValues().toString())
                                true
                        );

                        if (entity.getCustomName() != null){
                            _blockEntity.getPersistentData().putString("entityName",
                                    //(entity.getEntityData().getNonDefaultValues().toString())
                                    entity.getCustomName().getString()
                            );
                        }
                        _blockEntity.getPersistentData().putDouble("entityHealth",
                                entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1
                        );
                        _blockEntity.getPersistentData().putString("entityEffects",
                                entity instanceof LivingEntity _livEnt ? _livEnt.getActiveEffects().toString() : ""
                        );
                    }
                    if (world instanceof Level _level)
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                }
                if (!entity.level().isClientSide())
                    entity.discard();
            }
        });
    }
}