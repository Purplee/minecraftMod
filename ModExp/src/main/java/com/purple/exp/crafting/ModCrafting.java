package com.purple.exp.crafting;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.purple.exp.init.ModBlock;
import com.purple.exp.init.ModItem;

public final class ModCrafting {
	
	public static void initCrafting() {
		//Inventory
		
		GameRegistry.addRecipe(new ItemStack(ModBlock.crateBlock), new Object[] {"iii", "iii", "iii", 'i', Blocks.PLANKS});
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.PLANKS, 9, 1), new Object[] {ModBlock.crateBlock});
		
		//Furnace
		
		GameRegistry.addSmelting(ModItem.itemMoney, new ItemStack(Items.GOLD_INGOT, 5), 0.5F);
	}

}
