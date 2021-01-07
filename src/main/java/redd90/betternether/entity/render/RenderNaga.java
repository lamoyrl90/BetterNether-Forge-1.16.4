package redd90.betternether.entity.render;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.util.ResourceLocation;
import redd90.betternether.BetterNether;
import redd90.betternether.entity.EntityNaga;
import redd90.betternether.entity.model.ModelNaga;

public class RenderNaga extends MobRenderer<EntityNaga, AgeableModel<EntityNaga>> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(BetterNether.MOD_ID, "textures/entity/naga.png");

	public RenderNaga(EntityRendererManager renderManager) {
		super(renderManager, new ModelNaga(), 0.7F);
	}

	@Override
	public ResourceLocation getEntityTexture(EntityNaga entity) {
		return TEXTURE;
	}
}
