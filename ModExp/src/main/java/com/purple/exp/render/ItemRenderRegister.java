package com.purple.exp.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

import com.purple.exp.init.ModItem;

public final class ItemRenderRegister {
	
	// Register a model file (Need to create a json file)
	public static void registerItemRenderer() {
		// Register all items declared in ModItem
		for (Item item : ModItem.items) {
		    reg(item);
		}
	}
	
	//Industrial process of registering
	public static void reg(Item item) {
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
	    .register(item, 0, new ModelResourceLocation(item.getUnlocalizedName().substring(5), "inventory"));
	}
}
