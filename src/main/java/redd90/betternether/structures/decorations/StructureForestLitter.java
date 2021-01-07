package redd90.betternether.structures.decorations;

import net.minecraft.block.BlockState;
import redd90.betternether.BlocksHelper;
import redd90.betternether.registry.BlocksRegistry;
import redd90.betternether.structures.StructureObjScatter;
import redd90.betternether.structures.StructureType;
import redd90.betternether.structures.StructureWorld;

public class StructureForestLitter extends StructureObjScatter {
	private static final StructureWorld[] STRUCTURES = new StructureWorld[] {
			new StructureWorld("upside_down_forest/tree_fallen", 0, StructureType.FLOOR),
			new StructureWorld("upside_down_forest/tree_needle", 0, StructureType.FLOOR),
			new StructureWorld("upside_down_forest/tree_root", -2, StructureType.FLOOR),
			new StructureWorld("upside_down_forest/tree_stump", -2, StructureType.FLOOR),
			new StructureWorld("upside_down_forest/tree_small_branch", 0, StructureType.FLOOR)
	};

	public StructureForestLitter() {
		super(8, STRUCTURES);
	}

	@Override
	protected boolean isStructure(BlockState state) {
		return BlocksRegistry.ANCHOR_TREE.isTreeLog(state.getBlock());
	}

	@Override
	protected boolean isGround(BlockState state) {
		return BlocksHelper.isNetherGround(state);
	}
}