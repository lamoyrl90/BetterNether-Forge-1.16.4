package redd90.betternether.structures.plants;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import redd90.betternether.BlocksHelper;
import redd90.betternether.registry.BlocksRegistry;
import redd90.betternether.structures.StructureObjScatter;
import redd90.betternether.structures.StructureType;
import redd90.betternether.structures.StructureWorld;

public class StructureOldBrownMushrooms extends StructureObjScatter {
	private static final StructureWorld[] TREES = new StructureWorld[] {
			new StructureWorld("trees/brown_mushroom_01", -4, StructureType.FLOOR),
			new StructureWorld("trees/brown_mushroom_02", -3, StructureType.FLOOR),
			new StructureWorld("trees/brown_mushroom_03", -3, StructureType.FLOOR),
			new StructureWorld("trees/brown_mushroom_04", -2, StructureType.FLOOR)
	};

	public StructureOldBrownMushrooms() {
		super(9, TREES);
	}

	protected boolean isGround(BlockState state) {
		return state.getBlock() == BlocksRegistry.NETHER_MYCELIUM || BlocksHelper.isNetherGround(state);
	}

	protected boolean isStructure(BlockState state) {
		return state.getBlock() == Blocks.MUSHROOM_STEM ||
				state.getBlock() == Blocks.BROWN_MUSHROOM_BLOCK ||
				state.getBlock() == Blocks.RED_MUSHROOM_BLOCK;
	}
}
