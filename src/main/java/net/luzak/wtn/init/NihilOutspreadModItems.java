/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.luzak.wtn.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.BlockItem;

import net.luzak.wtn.NihilOutspreadMod;

public class NihilOutspreadModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(NihilOutspreadMod.MODID);
	public static final DeferredItem<Item> NIHIL_GRASS_BLOCK;
	public static final DeferredItem<Item> VOID_DIRT;
	public static final DeferredItem<Item> VOID_STONE;
	public static final DeferredItem<Item> VOID_PEBBLES;
	public static final DeferredItem<Item> NIHIL_HERB;
	public static final DeferredItem<Item> NIHIL_FERN;
	public static final DeferredItem<Item> NIHIL_BUSH;
	public static final DeferredItem<Item> TWIG_FLOWER;
	static {
		NIHIL_GRASS_BLOCK = block(NihilOutspreadModBlocks.NIHIL_GRASS_BLOCK);
		VOID_DIRT = block(NihilOutspreadModBlocks.VOID_DIRT);
		VOID_STONE = block(NihilOutspreadModBlocks.VOID_STONE);
		VOID_PEBBLES = block(NihilOutspreadModBlocks.VOID_PEBBLES);
		NIHIL_HERB = block(NihilOutspreadModBlocks.NIHIL_HERB);
		NIHIL_FERN = block(NihilOutspreadModBlocks.NIHIL_FERN);
		NIHIL_BUSH = block(NihilOutspreadModBlocks.NIHIL_BUSH);
		TWIG_FLOWER = doubleBlock(NihilOutspreadModBlocks.TWIG_FLOWER);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), properties));
	}

	private static DeferredItem<Item> doubleBlock(DeferredHolder<Block, Block> block) {
		return doubleBlock(block, new Item.Properties());
	}

	private static DeferredItem<Item> doubleBlock(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new DoubleHighBlockItem(block.get(), properties));
	}
}