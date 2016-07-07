package com.purple.exp.blocks;

import java.util.List;

import com.purple.exp.items.IMetaBlockName;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
public class BlockProperties extends BasicBlock implements IMetaBlockName {

	public BlockProperties(String name) {
		super(name, Material.ROCK,  5.0F, 20.0F); 
	}
	
	public static final IProperty<EnumType> TYPE = PropertyEnum.create("variant", EnumType.class);
	
	@Override
	protected BlockStateContainer createBlockState() {
	    return new BlockStateContainer(this, TYPE);
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
	    return getDefaultState().withProperty(TYPE, EnumType.values()[meta]);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
	    return ((EnumType) state.getValue(TYPE)).getMetadata();
	}
	
	@Override
	public int damageDropped(IBlockState state) {
	    return getMetaFromState(state);
	}
	
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list) {
	    for (EnumType t : EnumType.values())
	    	list.add(new ItemStack(itemIn,1, t.getMetadata()));
	}

	@Override
	public String getSpecialName(ItemStack stack) {
		return EnumType.values()[stack.getItemDamage()].name().toLowerCase();
	}
	
    public ItemStack getPickBlock(World world, BlockPos pos) {
    	return new ItemStack(Item.getItemFromBlock(this), 1, this.getMetaFromState(world.getBlockState(pos)));
    }
    
    public enum EnumType implements IStringSerializable {
    	WHITE(0, "white"), 
    	ORANGE(1, "orange"),
    	MAGENTA(2, "magenta"),
    	LIGHTBLUE(3, "light_blue"),
    	YELLOW(4, "yellow"),
    	LIME(5, "lime"),
    	PINK(6, "pink"),
    	GRAY(7, "gray"), 
    	SILVER(8, "silver"),
    	CYAN(9, "cyan"),
    	PURPLE(10, "purple"),
    	BLUE(11, "blue"),
    	BROWN(12, "brown"),
    	GREEN(13, "green"),
    	RED(14, "red"),
    	BLACK(15, "black");

        private int meta;
        private String name;
        
        private EnumType(int meta, String name) {
            this.meta = meta;
            this.name = name;
        }
        
    	private static final BlockProperties.EnumType[] META_LOOKUP = new BlockProperties.EnumType[values().length];
    	
        @Override
        public String getName() {
            return name;
        }
        
        public int getMetadata() {
        	return meta;
        }
        
        public static BlockProperties.EnumType byMetadata(int meta) {
			if (meta < 0 || meta >= META_LOOKUP.length) {
				meta = 0;
			}
			return META_LOOKUP[meta];
        }
        
    }
}
