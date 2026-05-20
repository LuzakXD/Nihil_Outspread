package net.luzak.wtn;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.core.registries.Registries;

import net.luzak.wtn.world.features.checkerGrassFeature;

public class NihilOutspreadFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(Registries.FEATURE, NihilOutspreadMod.MODID);
	public static final DeferredHolder<Feature<?>, checkerGrassFeature> CHECKER_GRASS_FEATURE = REGISTRY.register("checker_blob", () -> new checkerGrassFeature(NoneFeatureConfiguration.CODEC));
}