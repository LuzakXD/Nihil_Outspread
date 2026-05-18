/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.luzak.wtn.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.luzak.wtn.block.*;
import net.luzak.wtn.NihilOutspreadMod;

public class NihilOutspreadModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(NihilOutspreadMod.MODID);
	public static final DeferredBlock<Block> NIHIL_GRASS_BLOCK;
	public static final DeferredBlock<Block> VOID_DIRT;
	public static final DeferredBlock<Block> VOID_STONE;
	public static final DeferredBlock<Block> VOID_PEBBLES;
	public static final DeferredBlock<Block> NIHIL_HERB;
	public static final DeferredBlock<Block> NIHIL_FERN;
	public static final DeferredBlock<Block> NIHIL_BUSH;
	public static final DeferredBlock<Block> TWIG_FLOWER;
	static {
		NIHIL_GRASS_BLOCK = REGISTRY.register("nihil_grass_block", NihilGrassBlockBlock::new);
		VOID_DIRT = REGISTRY.register("void_dirt", VoidDirtBlock::new);
		VOID_STONE = REGISTRY.register("void_stone", VoidStoneBlock::new);
		VOID_PEBBLES = REGISTRY.register("void_pebbles", VoidPebblesBlock::new);
		NIHIL_HERB = REGISTRY.register("nihil_herb", NihilHerbBlock::new);
		NIHIL_FERN = REGISTRY.register("nihil_fern", NihilFernBlock::new);
		NIHIL_BUSH = REGISTRY.register("nihil_bush", NihilBushBlock::new);
		TWIG_FLOWER = REGISTRY.register("twig_flower", TwigFlowerBlock::new);
	}
	// Start of user code block custom blocks
	// End of user code block custom blocks
}