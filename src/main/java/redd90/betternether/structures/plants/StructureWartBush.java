package redd90.betternether.structures.plants;

import java.util.Random;

import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IServerWorld;
import redd90.betternether.BlocksHelper;
import redd90.betternether.blocks.BlockWartSeed;
import redd90.betternether.registry.BlocksRegistry;
import redd90.betternether.structures.IStructure;

public class StructureWartBush implements IStructure {
	private static final Direction[] DIRS = new Direction[] { Direction.UP, Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST };

	@Override
	public void generate(IServerWorld world, BlockPos pos, Random random) {
		if (world.isAirBlock(pos)) {
			BlocksHelper.setWithoutUpdate(world, pos, Blocks.NETHER_WART_BLOCK.getDefaultState());
			for (Direction dir : DIRS)
				setSeed(world, pos, dir);
		}
	}

	private void setSeed(IServerWorld world, BlockPos pos, Direction dir) {
		BlockPos p = pos.offset(dir);
		if (world.isAirBlock(p))
			BlocksHelper.setWithoutUpdate(world, p, BlocksRegistry.WART_SEED.getDefaultState().with(BlockWartSeed.FACING, dir));
	}
}