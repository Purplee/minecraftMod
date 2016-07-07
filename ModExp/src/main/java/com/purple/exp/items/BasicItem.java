package com.purple.exp.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BasicItem extends Item {
	
	// Create basic block
	
	public BasicItem(String name, CreativeTabs tab) {
		setItemName(this, name);
		setCreativeTab(tab);
	}
	
	public static void setItemName(Item item, String name) {
		item.setRegistryName(name);
		item.setUnlocalizedName(item.getRegistryName().toString());
	}
}
