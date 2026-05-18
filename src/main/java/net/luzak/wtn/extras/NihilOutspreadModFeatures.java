package net.luzak.wtn.init;

import net.neoforged.neoforge.registries.DeferredRegister;

import net.minecraft.core.registries.Registries;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import net.luzak.wtn.NihilOutspreadMod;
import net.luzak.wtn.world.features.CheckerGrassFeature;

import java.util.function.Supplier;

public class NihilOutspreadModFeatures {

	public static final DeferredRegister<Feature<?>> REGISTRY =
		DeferredRegister.create(
			Registries.FEATURE,
			NihilOutspreadMod.MODID
		);

	public static final Supplier<Feature<NoneFeatureConfiguration>>
		CHECKER_GRASS =
			REGISTRY.register(
				"checker_grass",
				() -> new CheckerGrassFeature(
					NoneFeatureConfiguration.CODEC
				)
			);
}