package redd90.betternether.structures.plants;

import redd90.betternether.blocks.BlockCommonPlant;
import redd90.betternether.registry.BlocksRegistry;

public class StructureEggPlant extends StructureScatter {
	public StructureEggPlant() {
		super(BlocksRegistry.EGG_PLANT, BlockCommonPlant.AGE, 4);
	}
}
