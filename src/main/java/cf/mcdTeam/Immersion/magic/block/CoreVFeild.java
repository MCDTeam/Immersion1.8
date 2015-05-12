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

public class CoreVFeild extends Block
{
	public CoreVFeild() 
	{
		super(Material.rock);
		setUnlocalizedName("coreVField");
		GameRegistry.registerBlock(this, "coreVField");
	}
	
	@Override
    public void onBlockClicked(World world, BlockPos pos, EntityPlayer player) 
	{
		TileVFeild tile = (TileVFeild) world.getTileEntity(pos);
		WorldBlockPos wpos = new WorldBlockPos(world, pos);
		
		int x = 0;
		int z = 0;
		
		Boolean done = false;
		int counter = 0;
		while (!done);
		{
			wpos = wpos.east();
			if (wpos.getBlock() == this)
			{
				done = true;
				x = wpos.getX();
			}
			counter ++;
			if (counter >= 15)
			{
				wpos = new WorldBlockPos(world, pos);
				while (!done);
				{
					counter = 0;
					wpos = wpos.west();
					if (wpos.getBlock() == this)
					{
						done = true;
						x = wpos.getX();
					}
					counter ++;
					if (counter >= 15)
					{
						return;
					}
				}
			}
		}
		
		done = false;
		counter = 0;
		while (!done);
		{
			wpos = wpos.north();
			if (wpos.getBlock() == this)
			{
				done = true;
				x = wpos.getZ();
			}
			counter ++;
			if (counter >= 15)
			{
				wpos = new WorldBlockPos(world, pos);
				while (!done);
				{
					wpos = wpos.south();
					if (wpos.getBlock() == this)
					{
						done = true;
						x = wpos.getZ();
					}
					counter ++;
					if (counter >= 15)
					{
						return;
					}
				}
			}
		}
		wpos = new WorldBlockPos(world, pos);
		WorldBlockPos pos1 = wpos;
		WorldBlockPos pos2 = wpos.getposatX(x);
		WorldBlockPos pos3 = new WorldBlockPos(world, x, pos.getY(), z);
		WorldBlockPos pos4 = wpos.getposatZ(z);
		
		if (pos1.getBlock() == this)
		{
			if (pos2.getBlock() == this)
			{
				if (pos3.getBlock() == this)
				{
					if (pos4.getBlock() == this)
					{
						System.out.println("Found Mactch, four blocks: ");
						System.out.println(pos1.toString());
						System.out.println(pos2.toString());
						System.out.println(pos3.toString());
						System.out.println(pos4.toString());
					}
					else
					{
						return;
					}
				}
				else
				{
					return;
				}
			}
			else
			{
				return;
			}
		} 
		else
		{
			return;
		}
	}
}
