package cf.mcdTeam.Immersion.terrainGenerator.blocks;

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
		setCreativeTab(CreativeTabs.tabBlock);
		GameRegistry.registerBlock(this, name);
	}

}
