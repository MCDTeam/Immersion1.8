package cf.mcdTeam.Immersion.utils;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockDecorative extends Block
{

	public BlockDecorative(String name) 
	{
		super(Material.rock);
		setUnlocalizedName(name);
		GameRegistry.registerBlock(this, name);
	}

}
