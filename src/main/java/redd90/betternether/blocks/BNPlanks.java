package redd90.betternether.blocks;

import net.minecraft.block.material.MaterialColor;
import redd90.betternether.blocks.materials.MaterialBuilder;

public class BNPlanks extends BlockBase {
	public BNPlanks(MaterialColor color) {
		super(MaterialBuilder.makeWood(color));
	}
}
