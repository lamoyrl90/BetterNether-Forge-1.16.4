package redd90.betternether.structures.plants;

import redd90.betternether.blocks.BlockCommonPlant;
import redd90.betternether.registry.BlocksRegistry;
import redd90.betternether.structures.IStructure;

public class StructureFeatherFern extends StructureScatter implements IStructure {
	public StructureFeatherFern() {
		super(BlocksRegistry.FEATHER_FERN, BlockCommonPlant.AGE, 4);
	}
}