package redd90.betternether.structures.plants;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IServerWorld;
import redd90.betternether.BlocksHelper;
import redd90.betternether.structures.IStructure;
import redd90.betternether.structures.StructureType;
import redd90.betternether.structures.StructureWorld;

public class StructureWartDeadwood implements IStructure {
	private static final StructureWorld[] TREES = new StructureWorld[] {
			new StructureWorld("trees/wart_root_01", 0, StructureType.FLOOR),
			new StructureWorld("trees/wart_root_02", 0, StructureType.FLOOR),
			new StructureWorld("trees/wart_root_03", -2, StructureType.FLOOR),
			new StructureWorld("trees/wart_fallen_log", 0, StructureType.FLOOR)
	};

	@Override
	public void generate(IServerWorld world, BlockPos pos, Random random) {
		if (isGround(world.getBlockState(pos.down())) && isGround(world.getBlockState(pos.down(2)))) {
			StructureWorld tree = TREES[random.nextInt(TREES.length)];
			tree.generate(world, pos, random);
		}
	}

	private boolean isGround(BlockState state) {
		return BlocksHelper.isNetherGround(state);
	}
}
