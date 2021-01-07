package redd90.betternether.entity.render;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.util.ResourceLocation;
import redd90.betternether.entity.EntityChair;
import redd90.betternether.entity.model.ModelEmpty;

public class RenderChair extends MobRenderer<EntityChair, AgeableModel<EntityChair>> {
	private static final ResourceLocation TEXTURE = new ResourceLocation("minecraft:textures/block/stone.png");

	public RenderChair(EntityRendererManager renderManager) {
		super(renderManager, new ModelEmpty(), 0);
	}

	@Override
	public ResourceLocation getEntityTexture(EntityChair entity) {
		return TEXTURE;
	}
}
