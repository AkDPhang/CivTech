package net.blackforge.civtech.geology.rock;

import net.blackforge.civtech.geology.rock.definition.RockDefinitions;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;


public class PebbleBlock extends Block {

    private final RockDefinitions rockDefinition;
    private static final VoxelShape SHAPE = Block.box(6, 0, 3, 10, 2, 13);

    public PebbleBlock(RockDefinitions rockDefinitions, Properties properties) {
        super(properties);
        this.rockDefinition = rockDefinitions;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
            if(!level.isClientSide) {
                ItemStack stack = new ItemStack(this.asItem());
                Block.popResource(level, pos, stack);
                level.playSound(null,pos, SoundEvents.ITEM_FRAME_REMOVE_ITEM, SoundSource.BLOCKS, 1f , 1f);
                level.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);

            }
            return InteractionResult.SUCCESS;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

}
