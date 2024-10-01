package net.gamerdragon525.wisp_of_the_lanterns.block;

import com.ibm.icu.text.RelativeDateTimeFormatter;
import com.mojang.serialization.MapCodec;
import net.gamerdragon525.wisp_of_the_lanterns.WispOfTheLanterns;
import net.gamerdragon525.wisp_of_the_lanterns.item.ModItems;
//import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.datafix.fixes.ChunkPalettedStorageFix;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(WispOfTheLanterns.MODID);
    public static final DeferredBlock<Block>  JACK_O_SOUL_LANTERN = registerBlock("jack_o_soul_lantern",
            () -> new HorizontalDirectionalBlock(BlockBehaviour.Properties.of()
                    .strength(1f)
                    .sound(SoundType.WOOD)
                    .lightLevel(p_187437_ -> 15)
                    .pushReaction(PushReaction.DESTROY)

            ) {
                @Override
                protected MapCodec<? extends HorizontalDirectionalBlock> codec() {

                    return null;
                }

                @Override
                public BlockState getStateForPlacement(BlockPlaceContext context) {
                    return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
                }

                @Override
                protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
                    builder.add(FACING);
                }

            });

    /*public static final DeferredBlock<Block> JADE_ORE = registerBlock("jade_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));*/



    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
