package redd90.betternether.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import redd90.betternether.BlocksHelper;
import redd90.betternether.registry.BlocksRegistry;

public class BlockSoulLilySapling extends BlockCommonSapling {
	public BlockSoulLilySapling() {
		super(BlocksRegistry.SOUL_LILY, MaterialColor.ADOBE);
	}

	@Override
	public boolean isValidPosition(BlockState state, IWorldReader world, BlockPos pos) {
		BlockState ground = world.getBlockState(pos.down());
		return BlocksHelper.isSoulSand(ground) || ground.getBlock() == BlocksRegistry.FARMLAND;
	}
}
