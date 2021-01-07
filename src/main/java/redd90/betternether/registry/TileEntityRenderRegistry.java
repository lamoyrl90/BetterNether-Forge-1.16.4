package redd90.betternether.registry;

import net.minecraftforge.fml.client.registry.ClientRegistry;
import redd90.betternether.tileentities.render.BNChestTileEntityRenderer;
import redd90.betternether.tileentities.render.BNSignTileEntityRenderer;

public class TileEntityRenderRegistry {
	public static void register() {
		ClientRegistry.bindTileEntityRenderer(TileEntitiesRegistry.CHEST, BNChestTileEntityRenderer::new);
		ClientRegistry.bindTileEntityRenderer(TileEntitiesRegistry.SIGN, BNSignTileEntityRenderer::new);
	}
}
