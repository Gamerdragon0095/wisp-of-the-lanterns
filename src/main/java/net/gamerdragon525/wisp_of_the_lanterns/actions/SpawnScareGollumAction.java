package net.gamerdragon525.wisp_of_the_lanterns.actions;

import net.gamerdragon525.wisp_of_the_lanterns.WispOfTheLanterns;
import net.gamerdragon525.wisp_of_the_lanterns.entity.ModEntities;
import net.gamerdragon525.wisp_of_the_lanterns.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.GameType;

public class SpawnScareGollumAction {
    public static void execute(LevelAccessor world, double x, double y, double z, Direction direction, Entity entity) {
        ItemStack heldItem = ItemStack.EMPTY;
        if ((world.getBlockState(BlockPos.containing(x, y - 0, z))).getBlock() == Blocks.HAY_BLOCK && (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.RED_WOOL
                && (world.getBlockState(BlockPos.containing(x, y - 2, z))).getBlock() == Blocks.OAK_FENCE && (world.getBlockState(BlockPos.containing(x - direction.getStepZ(), y - 1, z - direction.getStepX()))).getBlock() == Blocks.OAK_FENCE
                && (world.getBlockState(BlockPos.containing(x + direction.getStepZ(), y - 1, z + direction.getStepX()))).getBlock() == Blocks.OAK_FENCE) {
            world.levelEvent(2001, BlockPos.containing(x, y - 0, z), Block.getId((world.getBlockState(BlockPos.containing(x, y - 0, z)))));
            world.setBlock(BlockPos.containing(x, y - 0, z), Blocks.AIR.defaultBlockState(), 3);
            world.levelEvent(2001, BlockPos.containing(x, y - 1, z), Block.getId((world.getBlockState(BlockPos.containing(x, y - 1, z)))));
            world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
            world.levelEvent(2001, BlockPos.containing(x, y - 2, z), Block.getId((world.getBlockState(BlockPos.containing(x, y - 2, z)))));
            world.setBlock(BlockPos.containing(x, y - 2, z), Blocks.AIR.defaultBlockState(), 3);
            world.levelEvent(2001, BlockPos.containing(x + direction.getStepZ(), y - 1, z + direction.getStepX()), Block.getId((world.getBlockState(BlockPos.containing(x - direction.getStepZ(), y - 1, z - direction.getStepX())))));
            world.setBlock(BlockPos.containing(x - direction.getStepZ(), y - 1, z - direction.getStepX()), Blocks.AIR.defaultBlockState(), 3);
            world.levelEvent(2001, BlockPos.containing(x + direction.getStepZ(), y - 1, z + direction.getStepX()), Block.getId((world.getBlockState(BlockPos.containing(x + direction.getStepZ(), y - 1, z + direction.getStepX())))));
            world.setBlock(BlockPos.containing(x + direction.getStepZ(), y - 1, z + direction.getStepX()), Blocks.AIR.defaultBlockState(), 3);
            if (world instanceof ServerLevel _level) {
                Entity entityToSpawn = ModEntities.SCARE_GOLLUM.get().spawn(_level, BlockPos.containing(x, y - 2, z), MobSpawnType.MOB_SUMMONED);
                if (entityToSpawn != null) {
                    heldItem = GetItemOfTypeInHandOfEntityAction.execute(entity, ModItems.PUMPKIN_MASK.get());
                    entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);

                    {
                        Entity _entity = entityToSpawn;
                        if (_entity instanceof Player _player) {
                            _player.getInventory().armor.set(3, new ItemStack(heldItem.getItem()));
                            _player.getInventory().setChanged();
                        } else if (_entity instanceof LivingEntity _living) {
                            _living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(heldItem.getItem()));
                        }
                    }

                    {
                        final String _tagName = "design";
                        final Double _tagValue = (heldItem.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("design"));
                        CustomData.update(DataComponents.CUSTOM_DATA, (entityToSpawn instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
                    }

                }
            }

            if ((new Object() {
                public boolean checkGamemode(Entity _ent) {
                    if (_ent instanceof ServerPlayer _serverPlayer) {
                        return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
                    } else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
                        return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
                    }
                    return false;
                }
            }.checkGamemode(entity)) == false) {
                heldItem.shrink(1);
            }
        }
    }
}
