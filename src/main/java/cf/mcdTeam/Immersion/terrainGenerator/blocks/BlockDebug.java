package cf.mcdTeam.Immersion.terrainGenerator.blocks;

import cf.mcdTeam.Immersion.terrainGenerator.Generators.HollowMountain;
import cf.mcdTeam.Immersion.utils.WorldBlockPos;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockDebug extends Block {

	public BlockDebug() 
	{
		super(Material.rock);
        setCreativeTab(CreativeTabs.tabBlock);
        setUnlocalizedName("Debug");
		GameRegistry.registerBlock(this, "debug");
	}

	@Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state) 
    {
    	HollowMountain.MountainHollow(new WorldBlockPos(world, pos));
    }
}
