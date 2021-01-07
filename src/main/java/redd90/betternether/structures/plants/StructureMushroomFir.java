package redd90.betternether.structures.plants;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockPos.Mutable;
import net.minecraft.world.IServerWorld;
import redd90.betternether.BlocksHelper;
import redd90.betternether.blocks.BlockMushroomFir;
import redd90.betternether.blocks.BlockMushroomFir.MushroomFirShape;
import redd90.betternether.blocks.BlockNetherMycelium;
import redd90.betternether.registry.BlocksRegistry;
import redd90.betternether.structures.IStructure;

public class StructureMushroomFir implements IStructure {
	Mutable npos = new Mutable();

	@Override
	public void generate(IServerWorld world, BlockPos pos, Random random) {
		if (world.getBlockState(pos.down()).getBlock() == BlocksRegistry.NETHER_MYCELIUM) {
			int h = 3 + random.nextInt(5);
			for (int y = 1; y < h; y++)
				if (!world.isAirBlock(pos.up(y))) {
					h = y;
					break;
				}
			if (h < 3)
				return;

			BlocksHelper.setWithUpdate(world, pos, BlocksRegistry.MUSHROOM_FIR
					.getDefaultState()
					.with(BlockMushroomFir.SHAPE, MushroomFirShape.BOTTOM));
			int h2 = (h + 1) >> 1;
			h += pos.getY();
			h2 += pos.getY();
			npos.setPos(pos);
			for (int y = pos.getY() + 1; y < h2; y++) {
				npos.setY(y);
				BlocksHelper.setWithUpdate(world, npos, BlocksRegistry.MUSHROOM_FIR
						.getDefaultState()
						.with(BlockMushroomFir.SHAPE, MushroomFirShape.MIDDLE));
			}
			for (int y = h2; y < h; y++) {
				npos.setY(y);
				BlocksHelper.setWithUpdate(world, npos, BlocksRegistry.MUSHROOM_FIR
						.getDefaultState()
						.with(BlockMushroomFir.SHAPE, MushroomFirShape.TOP));
			}
			int h3 = (h2 + h) >> 1;
			for (int y = h2 - 1; y < h3; y++) {
				npos.setY(y);
				BlockPos branch;
				if (random.nextBoolean()) {
					branch = npos.north();
					if (world.isAirBlock(branch))
						BlocksHelper.setWithUpdate(world, branch, BlocksRegistry.MUSHROOM_FIR
								.getDefaultState()
								.with(BlockMushroomFir.SHAPE, MushroomFirShape.SIDE_BIG_S));
				}
				if (random.nextBoolean()) {
					branch = npos.south();
					if (world.isAirBlock(branch))
						BlocksHelper.setWithUpdate(world, branch, BlocksRegistry.MUSHROOM_FIR
								.getDefaultState()
								.with(BlockMushroomFir.SHAPE, MushroomFirShape.SIDE_BIG_N));
				}
				if (random.nextBoolean()) {
					branch = npos.east();
					if (world.isAirBlock(branch))
						BlocksHelper.setWithUpdate(world, branch, BlocksRegistry.MUSHROOM_FIR
								.getDefaultState()
								.with(BlockMushroomFir.SHAPE, MushroomFirShape.SIDE_BIG_W));
				}
				if (random.nextBoolean()) {
					branch = npos.west();
					if (world.isAirBlock(branch))
						BlocksHelper.setWithUpdate(world, branch, BlocksRegistry.MUSHROOM_FIR
								.getDefaultState()
								.with(BlockMushroomFir.SHAPE, MushroomFirShape.SIDE_BIG_E));
				}
			}
			for (int y = h3; y < h; y++) {
				npos.setY(y);
				BlockPos branch;
				if (random.nextBoolean()) {
					branch = npos.north();
					if (world.isAirBlock(branch))
						BlocksHelper.setWithUpdate(world, branch, BlocksRegistry.MUSHROOM_FIR
								.getDefaultState()
								.with(BlockMushroomFir.SHAPE, MushroomFirShape.SIDE_SMALL_S));
				}
				if (random.nextBoolean()) {
					branch = npos.south();
					if (world.isAirBlock(branch))
						BlocksHelper.setWithUpdate(world, branch, BlocksRegistry.MUSHROOM_FIR
								.getDefaultState()
								.with(BlockMushroomFir.SHAPE, MushroomFirShape.SIDE_SMALL_N));
				}
				if (random.nextBoolean()) {
					branch = npos.east();
					if (world.isAirBlock(branch))
						BlocksHelper.setWithUpdate(world, branch, BlocksRegistry.MUSHROOM_FIR
								.getDefaultState()
								.with(BlockMushroomFir.SHAPE, MushroomFirShape.SIDE_SMALL_W));
				}
				if (random.nextBoolean()) {
					branch = npos.west();
					if (world.isAirBlock(branch))
						BlocksHelper.setWithUpdate(world, branch, BlocksRegistry.MUSHROOM_FIR
								.getDefaultState()
								.with(BlockMushroomFir.SHAPE, MushroomFirShape.SIDE_SMALL_E));
				}
			}
			npos.setY(h);
			if (world.isAirBlock(npos))
				BlocksHelper.setWithUpdate(world, npos, BlocksRegistry.MUSHROOM_FIR
						.getDefaultState()
						.with(BlockMushroomFir.SHAPE, MushroomFirShape.END));

			BlocksHelper.cover(world,
					pos.down(),
					BlocksRegistry.NETHER_MYCELIUM,
					BlocksRegistry.NETHER_MYCELIUM.getDefaultState().with(BlockNetherMycelium.IS_BLUE, true),
					5,
					random);
		}
	}
}