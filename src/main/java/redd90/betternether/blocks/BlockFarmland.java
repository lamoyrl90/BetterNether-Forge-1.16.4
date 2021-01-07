package redd90.betternether.blocks;

import net.minecraft.block.material.MaterialColor;
import redd90.betternether.blocks.materials.MaterialBuilder;

public class BlockFarmland extends BlockBase {
	public BlockFarmland() {
		super(MaterialBuilder.makeWood(MaterialColor.LIME_TERRACOTTA));
	}
}