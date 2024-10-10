
package net.gamerdragon525.wisp_of_the_lanterns.block;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.Containers;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;

import net.gamerdragon525.wisp_of_the_lanterns.block.entity.HauntedPumpkinBlockEntity;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;

public class HauntedPumpkinBlock extends Block implements EntityBlock {
	public HauntedPumpkinBlock() {
		super(Properties.of()
				.sound(SoundType.WOOD)
				.strength(1f, 10f)
				.lightLevel(p_187437_ -> 7)
				.pushReaction(PushReaction.DESTROY)
		);
	}

	@Override
	public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
		for (int i = 0; i < 3; i++) {
			int j = random.nextInt(2) * 2 - 1;
			int k = random.nextInt(2) * 2 - 1;
			int l = random.nextInt(2) * 2 - 1;
			double d0 = (double)pos.getX() + 0.5 + (0.25 * (double)j) * 1.5f;
			double d1 = (double)pos.getY() + 0.5 + (0.25 * (double)l) * 1.5f;
			double d2 = (double)pos.getZ() + 0.5 + (0.25 * (double)k) * 1.5f;
			double d3 = (double)(random.nextFloat() * ((float)j / 30));
			double d4 = (double)((random.nextFloat() * ((float)l / 30)) + 0.05f);
			double d5 = (double)(random.nextFloat() * ((float)k / 30));
			level.addParticle(ParticleTypes.SOUL_FIRE_FLAME, d0, d1, d2, d3, d4, d5);
		}
	}

	@Override
	protected ItemInteractionResult useItemOn(
			ItemStack p_316383_, BlockState p_316676_, Level p_316272_, BlockPos p_316484_, Player p_316367_, InteractionHand p_316216_, BlockHitResult p_316827_
	) {
		if (!p_316383_.canPerformAction(net.neoforged.neoforge.common.ItemAbilities.SHEARS_CARVE)) {
			return super.useItemOn(p_316383_, p_316676_, p_316272_, p_316484_, p_316367_, p_316216_, p_316827_);
		} else if (p_316272_.isClientSide) {
			return ItemInteractionResult.sidedSuccess(p_316272_.isClientSide);
		} else {
			Direction direction = p_316827_.getDirection();
			Direction direction1 = direction.getAxis() == Direction.Axis.Y ? p_316367_.getDirection().getOpposite() : direction;
			p_316272_.playSound(null, p_316484_, SoundEvents.PUMPKIN_CARVE, SoundSource.BLOCKS, 1.0F, 1.0F);

			p_316272_.setBlock(p_316484_, ModBlocks.JACK_O_SOUL_LANTERN.get().defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, direction1), 11);

			ItemEntity itementity = new ItemEntity(
					p_316272_,
					(double)p_316484_.getX() + 0.5 + (double)direction1.getStepX() * 0.65,
					(double)p_316484_.getY() + 0.1,
					(double)p_316484_.getZ() + 0.5 + (double)direction1.getStepZ() * 0.65,
					new ItemStack(Items.PUMPKIN_SEEDS, 4)
			);
			itementity.setDeltaMovement(
					0.05 * (double)direction1.getStepX() + p_316272_.random.nextDouble() * 0.02,
					0.05,
					0.05 * (double)direction1.getStepZ() + p_316272_.random.nextDouble() * 0.02
			);
			p_316272_.addFreshEntity(itementity);
			p_316383_.hurtAndBreak(1, p_316367_, LivingEntity.getSlotForHand(p_316216_));
			p_316272_.gameEvent(p_316367_, GameEvent.SHEAR, p_316484_);
			p_316367_.awardStat(Stats.ITEM_USED.get(Items.SHEARS));
			return ItemInteractionResult.sidedSuccess(p_316272_.isClientSide);
		}
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new HauntedPumpkinBlockEntity(pos, state);
	}

	@Override
	public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
		super.triggerEvent(state, world, pos, eventID, eventParam);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
	}

	@Override
	public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			BlockEntity blockEntity = world.getBlockEntity(pos);
			if (blockEntity instanceof HauntedPumpkinBlockEntity be) {
				Containers.dropContents(world, pos, be);
				world.updateNeighbourForOutputSignal(pos, this);
			}
			super.onRemove(state, world, pos, newState, isMoving);
		}
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState blockState, Level world, BlockPos pos) {
		BlockEntity tileentity = world.getBlockEntity(pos);
		if (tileentity instanceof HauntedPumpkinBlockEntity be)
			return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
		else
			return 0;
	}
}
