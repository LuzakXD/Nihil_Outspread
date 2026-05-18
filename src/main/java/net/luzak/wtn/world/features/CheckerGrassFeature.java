package net.luzak.wtn.world.features;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;

import net.minecraft.tags.BlockTags;

import net.minecraft.util.RandomSource;

import net.minecraft.world.level.WorldGenLevel;

import net.minecraft.world.level.block.state.BlockState;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import net.luzak.wtn.init.NihilOutspreadModBlocks;

public class CheckerGrassFeature extends Feature<NoneFeatureConfiguration> {

	public CheckerGrassFeature(Codec<NoneFeatureConfiguration> codec) {
		super(codec);
	}

	@Override
	public boolean place(
		FeaturePlaceContext<NoneFeatureConfiguration> context
	) {

		WorldGenLevel level = context.level();

		BlockPos center = context.origin();

		RandomSource random = context.random();

		int radius = 2 + random.nextInt(5);

		for (int x = -radius; x <= radius; x++) {

			for (int z = -radius; z <= radius; z++) {

				double distance = Math.sqrt(
					(x * x) + (z * z)
				);

				if (distance > radius)
					continue;

				double chance =
					1.0 - (distance / radius);

				if (random.nextFloat() > chance)
					continue;

				BlockPos pos = center.offset(x, 0, z);

				BlockState below =
					level.getBlockState(pos.below());

				BlockState current =
					level.getBlockState(pos);

				if (
					current.isAir()
					&& below.is(BlockTags.create(
						net.minecraft.resources.ResourceLocation.fromNamespaceAndPath(
							"nihil_outspread",
							"nihil_plant_on"
						)
					))
				) {

					level.setBlock(
						pos,
						NihilOutspreadModBlocks.CHECKER_GRASS_BLOCK
							.get()
							.defaultBlockState(),
						2
					);
				}
			}
		}

		return true;
	}
}