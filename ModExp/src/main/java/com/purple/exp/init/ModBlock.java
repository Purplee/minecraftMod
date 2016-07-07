package com.purple.exp.init;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

import javax.annotation.Nullable;

import com.purple.exp.blocks.BlockBlueGlow;
import com.purple.exp.blocks.BlockProperties;
import com.purple.exp.blocks.CrateBlock;
import com.purple.exp.items.ItemBlockMeta;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemMultiTexture;
import net.minecraftforge.fml.common.registry.GameRegistry;


public final class ModBlock {
	
	public static final Set<Block> blocks = new HashSet<>();
	
	public static Block blueGlow;
	public static CrateBlock crateBlock;
	public static BlockProperties blockProperties;
	
	public static void registerBlocks() {
		blueGlow = registerBlock(new BlockBlueGlow().setLightLevel(1.0f));
		crateBlock = registerBlock(new CrateBlock());
		blockProperties = registerBlock(new BlockProperties("block_properties"));
	}

	/**
	 * Register a Block with the default ItemBlock class.
	 *
	 * @param block The Block instance
	 * @param <T>   The Block type
	 * @return The Block instance
	 */
	private static <T extends Block> T registerBlock(T block) {
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block), block.getRegistryName());
		blocks.add(block);
		return block;
	}
}
