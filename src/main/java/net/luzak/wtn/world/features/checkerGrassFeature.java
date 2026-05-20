package net.luzak.wtn.world.features;

import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.core.BlockPos;

import net.luzak.wtn.init.NihilOutspreadModBlocks;

import com.mojang.serialization.Codec;

public class checkerGrassFeature extends Feature<NoneFeatureConfiguration> {
	public checkerGrassFeature(Codec<NoneFeatureConfiguration> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		WorldGenLevel level = context.level();
		BlockPos center = context.origin();
		RandomSource random = context.random();
		int radius = 8 + random.nextInt(12);
		for (int x = -radius; x <= radius; x++) {
			for (int z = -radius; z <= radius; z++) {
				double distance = Math.sqrt((x * x) + (z * z));
				if (distance > radius)
					continue;
				double chance = 1.0 - (distance / radius);
				if (random.nextFloat() > chance)
					continue;
				int worldX = center.getX() + x;
				int worldZ = center.getZ() + z;
				int worldY = level.getHeight(Heightmap.Types.WORLD_SURFACE_WG, worldX, worldZ);
				BlockPos pos = new BlockPos(worldX, worldY - 1, worldZ);
				BlockState state = level.getBlockState(pos);
				if (state.is(NihilOutspreadModBlocks.NIHIL_GRASS_BLOCK.get())) {
					level.setBlock(pos, NihilOutspreadModBlocks.CHECKER_GRASS_BLOCK.get().defaultBlockState(), 2);
				}
			}
		}
		return true;
	}
}