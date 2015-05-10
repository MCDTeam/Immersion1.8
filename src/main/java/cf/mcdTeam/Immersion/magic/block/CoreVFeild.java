package cf.mcdTeam.Immersion.magic.block;

import cf.mcdTeam.Immersion.magic.block.tile.TileVFeild;
import cf.mcdTeam.Immersion.utils.WorldBlockPos;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CoreVFeild extends BlockContainer
{
	public CoreVFeild() 
	{
		super(Material.rock);
		setUnlocalizedName("coreVField");
		GameRegistry.registerBlock(this, "coreVField");
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) 
	{
		return (TileEntity) new TileVFeild();
	}
	
	@Override
    public void onBlockClicked(World world, BlockPos pos, EntityPlayer player) 
	{
		TileVFeild tile = (TileVFeild) world.getTileEntity(pos);
		WorldBlockPos wpos = new WorldBlockPos(world, pos);
		
		int x;
		int y;
		int z;
		
		Boolean done = false;
		int counter = 0;
		while (!done);
		{
			wpos = wpos.north();
			if (wpos.getBlock() == this)
			{
				
			}
		}
	}
}
