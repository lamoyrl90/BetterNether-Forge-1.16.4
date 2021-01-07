package redd90.betternether.structures.plants;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IServerWorld;
import redd90.betternether.BlocksHelper;
import redd90.betternether.blocks.BlockNetherReed;
import redd90.betternether.registry.BlocksRegistry;
import redd90.betternether.structures.IStructure;

public class StructureReeds implements IStructure {
	public void generate(IServerWorld world, BlockPos pos, Random random) {
		if (world.isAirBlock(pos) && BlocksRegistry.NETHER_REED.isValidPosition(world.getBlockState(pos), world, pos)) {
			BlockState med = BlocksRegistry.NETHER_REED.getDefaultState().with(BlockNetherReed.TOP, false);
			int h = random.nextInt(3);
			for (int i = 0; i < h; i++) {
				BlockPos posN = pos.up(i);
				BlockPos up = posN.up();
				if (world.isAirBlock(posN)) {
					if (world.isAirBlock(up))
						BlocksHelper.setWithUpdate(world, posN, med);
					else {
						BlocksHelper.setWithUpdate(world, posN, BlocksRegistry.NETHER_REED.getDefaultState());
						return;
					}
				}
			}
			BlocksHelper.setWithUpdate(world, pos.up(h), BlocksRegistry.NETHER_REED.getDefaultState());
		}
	}
}