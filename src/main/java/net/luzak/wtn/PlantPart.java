package net.luzak.wtn.block;

import net.minecraft.util.StringRepresentable;


public enum PlantPart implements StringRepresentable {
	BOTTOM("bottom"), MIDDLE("middle"), TOP("top");

	private final String name;

	PlantPart(String name) {
		this.name = name;
	}

	@Override
	public String getSerializedName() {
		return this.name;
	}
}