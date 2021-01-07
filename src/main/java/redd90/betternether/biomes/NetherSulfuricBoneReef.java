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
import redd90.betternether.structures.plants.StructureBoneReef;
import redd90.betternether.structures.plants.StructureGoldenLumabusVine;
import redd90.betternether.structures.plants.StructureJellyfishMushroom;
import redd90.betternether.structures.plants.StructureReeds;
import redd90.betternether.structures.plants.StructureSepiaBoneGrass;

public class NetherSulfuricBoneReef extends NetherBiome {
	public NetherSulfuricBoneReef(String name) {
		super(new BiomeDefinition(name)
				.setFogColor(154, 144, 49)
				.setLoop(SoundEvents.AMBIENT_CRIMSON_FOREST_LOOP)
				.setAdditions(SoundEvents.AMBIENT_CRIMSON_FOREST_ADDITIONS)
				.setMood(SoundEvents.AMBIENT_CRIMSON_FOREST_MOOD)
				.setStalactites(false)
				.setParticleConfig(new ParticleEffectAmbience(ParticleTypes.ASH, 0.01F)));

		addStructure("bone_stalactite", new StructureStalagmite(BlocksRegistry.BONE_STALACTITE, BlocksRegistry.BONE_BLOCK), StructureType.FLOOR, 0.05F, true);

		addStructure("nether_reed", new StructureReeds(), StructureType.FLOOR, 0.5F, false);
		addStructure("bone_reef", new StructureBoneReef(), StructureType.FLOOR, 0.2F, true);
		addStructure("jellyfish_mushroom", new StructureJellyfishMushroom(), StructureType.FLOOR, 0.02F, true);
		addStructure("sulfuric_bone_grass", new StructureSepiaBoneGrass(), StructureType.FLOOR, 0.1F, false);

		addStructure("bone_stalagmite", new StructureStalactite(BlocksRegistry.BONE_STALACTITE, BlocksRegistry.BONE_BLOCK), StructureType.CEIL, 0.05F, true);

		addStructure("golden_lumabus_vine", new StructureGoldenLumabusVine(), StructureType.CEIL, 0.3F, true);
	}

	@Override
	public void genSurfColumn(IWorld world, BlockPos pos, Random random) {
		BlocksHelper.setWithoutUpdate(world, pos, BlocksRegistry.SEPIA_MUSHROOM_GRASS.getDefaultState());
	}
}
