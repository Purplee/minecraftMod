package com.purple.exp.proxy;

import com.purple.exp.render.ItemRenderRegister;
import com.purple.exp.render.ModModelManager;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);

	}

	@Override
	public void init(FMLInitializationEvent event) {
		// Register Model files
		ItemRenderRegister.registerItemRenderer();
		ModModelManager.INSTANCE.register();
		
		super.init(event);

	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		
		super.postInit(event);

	}

}
