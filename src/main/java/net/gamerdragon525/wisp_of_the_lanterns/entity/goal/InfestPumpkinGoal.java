package net.gamerdragon525.wisp_of_the_lanterns.entity.goal;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.gamerdragon525.wisp_of_the_lanterns.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.event.entity.living.MobDespawnEvent;

public class InfestPumpkinGoal {
    public static void execute(LevelAccessor world, double x, double y, double z, BlockPos pos, Entity mob) {

        if ((world.getBlockState(pos)).getBlock() == Blocks.PUMPKIN) {
            world.setBlock(BlockPos.containing(x, y, z), ModBlocks.HAUNTED_PUMPKIN.value().defaultBlockState(), 3);
            if (mob == null)
                return;
            if (!mob.level().isClientSide())
                mob.discard();

        }
        else if ((world.getBlockState(pos)).getBlock() == Blocks.CARVED_PUMPKIN) {
            world.setBlock(BlockPos.containing(x, y, z), ModBlocks.JACK_O_SOUL_LANTERN.value().defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, world.getBlockState(BlockPos.containing(x, y, z)).getValue(HorizontalDirectionalBlock.FACING)), 11);
            if (mob == null)
                return;
            if (!mob.level().isClientSide())
                mob.discard();
        }
    }
}
