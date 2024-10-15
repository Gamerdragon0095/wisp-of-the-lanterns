package net.gamerdragon525.wisp_of_the_lanterns.global_triggers;

import net.gamerdragon525.wisp_of_the_lanterns.entity.ModEntities;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.LootParams;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.GameType;

import net.gamerdragon525.wisp_of_the_lanterns.block.ModBlocks;
import net.gamerdragon525.wisp_of_the_lanterns.WispOfTheLanterns;

import javax.annotation.Nullable;


@EventBusSubscriber
public class GlobalDispenseWispAction {
    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getState(), event.getPlayer());
    }

    public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
        execute(null, world, x, y, z, blockstate, entity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
        if (entity == null)
            return;
        if (blockstate.getBlock() == ModBlocks.JACK_O_SOUL_LANTERN.get()) {
            if (event instanceof ICancellableEvent _cancellable) {
                _cancellable.setCanceled(true);
            }
            if ((entity != null) && (((new Object() {
                public boolean checkGamemode(Entity _ent) {
                    if (_ent instanceof ServerPlayer _serverPlayer) {
                        return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
                    } else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
                        return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
                    }
                    return false;
                }
            }.checkGamemode(entity)) == true) || ((new Object() {
                public boolean checkGamemode(Entity _ent) {
                    if (_ent instanceof ServerPlayer _serverPlayer) {
                        return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
                    } else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
                        return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.ADVENTURE;
                    }
                    return false;
                }
            }.checkGamemode(entity)) == true))) {
                Object displayName_ = new Object() {
                    public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                        BlockEntity blockEntity = world.getBlockEntity(pos);
                        if (blockEntity != null)
                            return blockEntity.getPersistentData().getString(tag);
                        return "";
                    }
                }.getValue(world, BlockPos.containing(x, y, z), "entityName");

                Object currentHealth_ = new Object() {
                    public float getValue(LevelAccessor world, BlockPos pos, String tag) {
                        BlockEntity blockEntity = world.getBlockEntity(pos);
                        if (blockEntity != null)
                            return (float) blockEntity.getPersistentData().getDouble(tag);
                        return 0f;
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
                if (entity instanceof Player _player && !_player.level().isClientSide())
                   if (new Object() {
                       public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
                           BlockEntity blockEntity = world.getBlockEntity(pos);
                           if (blockEntity != null)
                               return blockEntity.getPersistentData().getBoolean(tag);
                           return false;
                       }
                   }.getValue(world, BlockPos.containing(x, y, z), "hasEntityData")) {
                       if (world instanceof ServerLevel _level) {
                           net.minecraft.world.entity.Entity entityToSpawn = ModEntities.WISP.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawn != null) {
                               entityToSpawn.setCustomName(Component.literal((String) displayName_));
                               //world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
                               WispOfTheLanterns.queueServerWork(1, () -> {
                                   if (entityToSpawn instanceof LivingEntity _livEnt) {
                                       _livEnt.setHealth((Float) currentHealth_);
                                   } else {
                                       return;
                                   }
                               });
                               entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
                           }
                       }
                       world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
                       world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(ModBlocks.JACK_O_SOUL_LANTERN.get().defaultBlockState()));
                       WispOfTheLanterns.queueServerWork(1, () -> {
                           world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
                       });
                   } else {
                       if (world instanceof ServerLevel _level) {
                           net.minecraft.world.entity.Entity entityToSpawn = ModEntities.WISP.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawn != null) {
                               entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
                           }
                       }
                       //world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
                       world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(ModBlocks.JACK_O_SOUL_LANTERN.get().defaultBlockState()));
                       WispOfTheLanterns.queueServerWork(1, () -> {
                           world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
                       });
                   }
                Block.dropResources(blockstate, (Level) world, BlockPos.containing(x, y, z), world.getBlockEntity(BlockPos.containing(x, y, z)), entity, entity.getWeaponItem());
                /*if (!world.isClientSide() && world.getServer() != null) {
                    for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.parse("wisp_of_the_lanterns:blocks/jack_o_soul_lantern")))
                            .getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.SELECTOR))) {
                        if (world instanceof ServerLevel _level) {
                            ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity(entityToSpawn);
                        }
                    }
                }*/

            } else {

                world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
                world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(ModBlocks.JACK_O_SOUL_LANTERN.get().defaultBlockState()));
            }
        }
    }
}
