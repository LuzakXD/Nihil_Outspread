/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.luzak.wtn.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.luzak.wtn.NihilOutspreadMod;

public class NihilOutspreadModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, NihilOutspreadMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_NIHILGRASS_FOOTSTEP = REGISTRY.register("block.nihilgrass.footstep",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("nihil_outspread", "block.nihilgrass.footstep")));
}