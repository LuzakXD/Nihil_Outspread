/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.luzak.wtn.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.luzak.wtn.NihilOutspreadMod;

@EventBusSubscriber
public class NihilOutspreadModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NihilOutspreadMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
			tabData.accept(NihilOutspreadModBlocks.NIHIL_GRASS_BLOCK.get().asItem());
			tabData.accept(NihilOutspreadModBlocks.VOID_DIRT.get().asItem());
			tabData.accept(NihilOutspreadModBlocks.NIHIL_HERB.get().asItem());
			tabData.accept(NihilOutspreadModBlocks.NIHIL_FERN.get().asItem());
			tabData.accept(NihilOutspreadModBlocks.NIHIL_BUSH.get().asItem());
			tabData.accept(NihilOutspreadModBlocks.TWIG_FLOWER.get().asItem());
		}
	}
}