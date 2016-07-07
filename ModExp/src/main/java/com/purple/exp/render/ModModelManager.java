package com.purple.exp.render;

import java.util.HashSet;
import java.util.Set;

import com.purple.exp.blocks.BlockProperties;
import com.purple.exp.init.ModBlock;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public final class ModModelManager {
	public static final ModModelManager INSTANCE = new ModModelManager();

	private final static Set<Item> itemsRegistered = new HashSet<>();

	public ModModelManager() {
	}

	public void register() {
		registerBlockRenderer();
	}

	/**
	 * Register all block renders
	 */
	public void registerBlockRenderer() {
		// Register MetaBlock

		for (BlockProperties.EnumType enumType : BlockProperties.EnumType.values()) {
			registerItemModelForMeta(Item.getItemFromBlock(ModBlock.blockProperties), enumType.getMetadata(), "variant=" + enumType.getName());
		}
		
		// Register remainder block

		ModBlock.blocks.stream().filter(block -> !itemsRegistered.contains(Item.getItemFromBlock(block)))
				.forEach(this::registerBlockItemModel);

	}

	/**
	 * Register block without meta
	 * 
	 * @param block
	 */
	private void registerBlockItemModel(Block block) {
		Item item = Item.getItemFromBlock(block);

		if (item != null) {
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
			.register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		}

		itemsRegistered.add(item);
	}

	/**
	 * Register block with meta
	 */
	private static void registerItemModelForMeta(Item item, int meta, String variant) {
		if (item != null) {
			
			ModelBakery.registerItemVariants(item, new ModelResourceLocation(item.getRegistryName().toString()));
			ModelResourceLocation model = new ModelResourceLocation(item.getRegistryName(), variant);
			
			ModelLoader.setCustomModelResourceLocation(item, meta, model);
			
			
			
			itemsRegistered.add(item);
		}
	}
}
