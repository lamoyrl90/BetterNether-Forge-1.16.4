package redd90.betternether.structures.plants;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IServerWorld;
import redd90.betternether.BlocksHelper;
import redd90.betternether.structures.IStructure;
import redd90.betternether.structures.StructureNBT;

public class StructureBoneReef implements IStructure {
	private static final StructureNBT[] BONES = new StructureNBT[] {
			new StructureNBT("bone_01"),
			new StructureNBT("bone_02"),
			new StructureNBT("bone_03")
	};

	@Override
	public void generate(IServerWorld world, BlockPos pos, Random random) {
		if (BlocksHelper.isNetherGround(world.getBlockState(pos.down())) && world.isAirBlock(pos.up(2)) && world.isAirBlock(pos.up(4))) {
			StructureNBT bone = BONES[random.nextInt(BONES.length)];
			bone.randomRM(random);
			bone.generateCentered(world, pos.down(random.nextInt(4)));
		}
	}
}
