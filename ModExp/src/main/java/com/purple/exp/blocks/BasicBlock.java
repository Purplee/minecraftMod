package com.purple.exp.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BasicBlock extends Block {
	// Hardness : Sets how long it takes to break a block : stone:1.5F obsidian:50.0F
	// Resistance : Sets the block resistance against explosions : stone:10.0F obsidian:2000.0F
    public BasicBlock(String name, Material material, float hardness, float resistance) {
    	super(material);
    	setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    	setBlockName(this, name);
    	this.setResistance(resistance);
    	this.setHardness(hardness);
    }
    
    public static void setBlockName(Block block, String name) {
		block.setRegistryName(name);
		block.setUnlocalizedName(block.getRegistryName().toString());
    }
}
