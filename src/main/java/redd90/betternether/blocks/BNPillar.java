package redd90.betternether.blocks;

import java.util.Collections;
import java.util.List;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import redd90.betternether.blocks.materials.MaterialBuilder;

public class BNPillar extends RotatedPillarBlock {
	public BNPillar(AbstractBlock.Properties settings) {
		super(settings);
	}

	public BNPillar(Block block) {
		super(AbstractBlock.Properties.from(block));
	}

	public BNPillar(MaterialColor color) {
		super(MaterialBuilder.makeWood(color));
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		return Collections.singletonList(new ItemStack(this));
	}
}
