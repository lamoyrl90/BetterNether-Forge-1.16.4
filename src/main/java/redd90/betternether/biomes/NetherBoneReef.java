package redd90.betternether.biomes;

import java.util.Random;

import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.ParticleEffectAmbience;
import redd90.betternether.BlocksHelper;
import redd90.betternether.registry.BlocksRegistry;
import redd90.betternether.structures.StructureType;
import redd90.betternether.structures.decorations.StructureStalactite;
import redd90.betternether.structures.decorations.StructureStalagmite;
import redd90.betternether.structures.plants.StructureBoneGrass;
import redd90.betternether.structures.plants.StructureBoneReef;
import redd90.betternether.structures.plants.StructureFeatherFern;
import redd90.betternether.structures.plants.StructureJellyfishMushroom;
import redd90.betternether.structures.plants.StructureLumabusVine;
import redd90.betternether.structures.plants.StructureReeds;

public class NetherBoneReef extends NetherBiome {
	public NetherBoneReef(String name) {
		super(new BiomeDefinition(name)
				.setFogColor(47, 221, 202)
				.setLoop(SoundEvents.AMBIENT_CRIMSON_FOREST_LOOP)
				.setAdditions(SoundEvents.AMBIENT_CRIMSON_FOREST_ADDITIONS)
				.setMood(SoundEvents.AMBIENT_CRIMSON_FOREST_MOOD)
				.setStalactites(false)
				.setParticleConfig(new ParticleEffectAmbience(ParticleTypes.WARPED_SPORE, 0.01F)));

		addStructure("bone_stalactite", new StructureStalagmite(BlocksRegistry.BONE_STALACTITE, BlocksRegistry.BONE_BLOCK), StructureType.FLOOR, 0.05F, true);

		addStructure("nether_reed", new StructureReeds(), StructureType.FLOOR, 0.5F, false);
		addStructure("bone_reef", new StructureBoneReef(), StructureType.FLOOR, 0.2F, true);
		addStructure("jellyfish_mushroom", new StructureJellyfishMushroom(), StructureType.FLOOR, 0.02F, true);
		addStructure("feather_fern", new StructureFeatherFern(), StructureType.FLOOR, 0.05F, true);
		addStructure("bone_grass", new StructureBoneGrass(), StructureType.FLOOR, 0.1F, false);

		addStructure("bone_stalagmite", new StructureStalactite(BlocksRegistry.BONE_STALACTITE, BlocksRegistry.BONE_BLOCK), StructureType.CEIL, 0.05F, true);

		addStructure("lumabus_vine", new StructureLumabusVine(), StructureType.CEIL, 0.3F, true);
	}

	@Override
	public void genSurfColumn(IWorld world, BlockPos pos, Random random) {
		BlocksHelper.setWithoutUpdate(world, pos, BlocksRegistry.MUSHROOM_GRASS.getDefaultState());
	}
}
