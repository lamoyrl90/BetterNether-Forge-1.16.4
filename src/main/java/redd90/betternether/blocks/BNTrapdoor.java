package redd90.betternether.blocks;

import java.util.Collections;
import java.util.List;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.TrapDoorBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import redd90.betternether.client.IRenderTypeable;

public class BNTrapdoor extends TrapDoorBlock implements IRenderTypeable {
	public BNTrapdoor(Block block) {
		super(AbstractBlock.Properties.from(block).notSolid());
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		return Collections.singletonList(new ItemStack(this.asItem()));
	}

	@Override
	public BNRenderLayer getRenderLayer() {
		return BNRenderLayer.CUTOUT;
	}
}
