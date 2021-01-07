package redd90.betternether.structures.plants;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IServerWorld;
import redd90.betternether.BlocksHelper;
import redd90.betternether.blocks.BlockStalagnate;
import redd90.betternether.blocks.shapes.TripleShape;
import redd90.betternether.registry.BlocksRegistry;
import redd90.betternether.structures.IStructure;


public class StructureStalagnate implements IStructure {
	public static final int MAX_LENGTH = 25; // 27
	public static final int MIN_LENGTH = 3; // 5

	@Override
	public void generate(IServerWorld world, BlockPos pos, Random random) {
		int length = BlocksHelper.upRay(world, pos, MAX_LENGTH);
		if (length > MIN_LENGTH && BlocksHelper.isNetherrack(world.getBlockState(pos.up(length + 1)))) {
			BlockState bottom = BlocksRegistry.STALAGNATE.getDefaultState().with(BlockStalagnate.SHAPE, TripleShape.BOTTOM);
			BlockState middle = BlocksRegistry.STALAGNATE.getDefaultState();
			BlockState top = BlocksRegistry.STALAGNATE.getDefaultState().with(BlockStalagnate.SHAPE, TripleShape.TOP);

			BlocksHelper.setWithUpdate(world, pos, bottom);
			BlocksHelper.setWithUpdate(world, pos.up(length), top);
			for (int y = 1; y < length; y++)
				BlocksHelper.setWithUpdate(world, pos.up(y), middle);
		}
	}

	public void generateDown(IServerWorld world, BlockPos pos, Random random) {
		int length = BlocksHelper.downRay(world, pos, MAX_LENGTH);
		if (length > MIN_LENGTH && BlocksHelper.isNetherrack(world.getBlockState(pos.down(length + 1)))) {
			BlockState bottom = BlocksRegistry.STALAGNATE.getDefaultState().with(BlockStalagnate.SHAPE, TripleShape.BOTTOM);
			BlockState middle = BlocksRegistry.STALAGNATE.getDefaultState();
			BlockState top = BlocksRegistry.STALAGNATE.getDefaultState().with(BlockStalagnate.SHAPE, TripleShape.TOP);

			BlocksHelper.setWithUpdate(world, pos.down(length), bottom);
			BlocksHelper.setWithUpdate(world, pos, top);
			for (int y = 1; y < length; y++)
				BlocksHelper.setWithUpdate(world, pos.down(y), middle);
		}
	}
}
