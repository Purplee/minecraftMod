package com.purple.exp.init;

import java.util.HashSet;
import java.util.Set;

import com.purple.exp.items.ItemMoney;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModItem {
	
	public static final Set<Item> items = new HashSet();

	public static ItemMoney itemMoney;
	
	public static void registerItems() {
		itemMoney = registerItem(new ItemMoney());
	}
	
	private static <T extends Item> T registerItem(T item) {
		GameRegistry.register(item);
		items.add(item);
		return item;
	}
}
