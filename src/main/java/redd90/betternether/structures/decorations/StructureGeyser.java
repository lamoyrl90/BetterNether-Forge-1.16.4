package redd90.betternether.structures.decorations;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IServerWorld;
import redd90.betternether.BlocksHelper;
import redd90.betternether.registry.BlocksRegistry;
import redd90.betternether.structures.IStructure;

public class StructureGeyser implements IStructure {
	@Override
	public void generate(IServerWorld world, BlockPos pos, Random random) {
		if (BlocksHelper.isNetherrack(world.getBlockState(pos.down())))
			BlocksHelper.setWithoutUpdate(world, pos, BlocksRegistry.GEYSER.getDefaultState());
	}
}