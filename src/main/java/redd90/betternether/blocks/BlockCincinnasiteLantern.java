package redd90.betternether.blocks;

import net.minecraft.block.AbstractBlock;
import redd90.betternether.registry.BlocksRegistry;

public class BlockCincinnasiteLantern extends BlockBase {
	public BlockCincinnasiteLantern() {
		super(AbstractBlock.Properties.from(BlocksRegistry.CINCINNASITE_BLOCK).setLightLevel((state) -> {return 15;}));
	}
}
