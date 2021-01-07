package redd90.betternether.biomes;

import java.util.Random;

import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.ParticleEffectAmbience;
import redd90.betternether.BlocksHelper;
import redd90.betternether.registry.BlocksRegistry;
import redd90.betternether.registry.SoundsRegistry;
import redd90.betternether.structures.StructureType;
import redd90.betternether.structures.plants.StructureGiantMold;
import redd90.betternether.structures.plants.StructureGrayMold;
import redd90.betternether.structures.plants.StructureLucis;
import redd90.betternether.structures.plants.StructureMedBrownMushroom;
import redd90.betternether.structures.plants.StructureMedRedMushroom;
import redd90.betternether.structures.plants.StructureMushroomFir;
import redd90.betternether.structures.plants.StructureOrangeMushroom;
import redd90.betternether.structures.plants.StructureRedMold;
import redd90.betternether.structures.plants.StructureVanillaMushroom;
import redd90.betternether.structures.plants.StructureWallBrownMushroom;
import redd90.betternether.structures.plants.StructureWallRedMushroom;

public class NetherMushroomForest extends NetherBiome {
	public NetherMushroomForest(String name) {
		super(new BiomeDefinition(name)
				.setFogColor(166, 38, 95)
				.setLoop(SoundsRegistry.AMBIENT_MUSHROOM_FOREST)
				.setAdditions(SoundEvents.AMBIENT_CRIMSON_FOREST_ADDITIONS)
				.setMood(SoundEvents.AMBIENT_CRIMSON_FOREST_MOOD)
				.setMusic(SoundEvents.MUSIC_NETHER_CRIMSON_FOREST)
				.setParticleConfig(new ParticleEffectAmbience(ParticleTypes.MYCELIUM, 0.1F)));
		this.setNoiseDensity(0.5F);
		addStructure("large_red_mushroom", new StructureMedRedMushroom(), StructureType.FLOOR, 0.12F, true);
		addStructure("large_brown_mushroom", new StructureMedBrownMushroom(), StructureType.FLOOR, 0.12F, true);
		addStructure("giant_mold", new StructureGiantMold(), StructureType.FLOOR, 0.12F, true);
		addStructure("mushroom_fir", new StructureMushroomFir(), StructureType.FLOOR, 0.2F, true);
		addStructure("vanilla_mushrooms", new StructureVanillaMushroom(), StructureType.FLOOR, 0.1F, false);
		addStructure("orange_mushroom", new StructureOrangeMushroom(), StructureType.FLOOR, 0.05F, true);
		addStructure("red_mold", new StructureRedMold(), StructureType.FLOOR, 0.5F, true);
		addStructure("gray_mold", new StructureGrayMold(), StructureType.FLOOR, 0.5F, true);
		addStructure("lucis", new StructureLucis(), StructureType.WALL, 0.05F, false);
		addStructure("wall_red_mushroom", new StructureWallRedMushroom(), StructureType.WALL, 0.8F, true);
		addStructure("wall_brown_mushroom", new StructureWallBrownMushroom(), StructureType.WALL, 0.8F, true);
	}

	@Override
	public void genSurfColumn(IWorld world, BlockPos pos, Random random) {
		BlocksHelper.setWithoutUpdate(world, pos, BlocksRegistry.NETHER_MYCELIUM.getDefaultState());
	}
}
