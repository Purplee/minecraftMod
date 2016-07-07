package com.purple.exp.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.purple.exp.crafting.ModCrafting;
import com.purple.exp.init.ModBlock;
import com.purple.exp.init.ModItem;


public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
    	ModItem.registerItems();
    	ModBlock.registerBlocks();
    	ModCrafting.initCrafting();
    }

    public void init(FMLInitializationEvent e) {

    }

    public void postInit(FMLPostInitializationEvent e) {

    }

}
