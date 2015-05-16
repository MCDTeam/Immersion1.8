package cf.mcdTeam.Immersion.magic.block;

import cf.mcdTeam.Immersion.magic.MRef;
import cf.mcdTeam.Immersion.magic.block.tile.TileVField;
import cf.mcdTeam.Immersion.utils.WorldBlockPos;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CoreVField extends BlockContainer
{

	public CoreVField() 
	{
		super(Material.rock);
		setUnlocalizedName("coreVField");
		GameRegistry.registerBlock(this, "coreVField");
		GameRegistry.registerTileEntity(TileVField.class, "Void Feild");
		setHarvestLevel("pickaxe", 1);
		setHardness(1.0F);
	}
	
    public int getRenderType()
    {
        return 3;
    }
    
	@Override
    public void onBlockClicked(World world, BlockPos pos, EntityPlayer player) 
	{
		if(world.isRemote)
		{
			return;
		}
		
		WorldBlockPos wpos = new WorldBlockPos(world, pos);
		System.out.println(wpos.getTile().getPos());
		
		int x = 0;
		int z = 0;
		
		Boolean flag = false;
		
		for (int i = 1; i <= 16; i ++)
		{
			if (wpos.north(i).getBlock() == MRef.coreVField)
			{
				z = wpos.north(i).getZ();
				flag = true;
				break;
			}
		}
		if (!flag)
		{
			for (int i = 1; i <= 16; i ++)
			{
				if (wpos.south(i).getBlock() == MRef.coreVField)
				{
					z = wpos.south(i).getZ();
					flag = true;
					break;
				}
			}
		}
		
		if (flag == false)
		{
			System.out.print("z" + z);
			return;
		}
		
		flag = false;
		
		for (int i = 1; i <= 16; i ++)
		{
			if (wpos.east(i).getBlock() == MRef.coreVField)
			{
				x = wpos.east(i).getX();
				flag = true;
				break;
			}
		}
		if (!flag)
		{
			for (int i = 1; i <= 16; i ++)
			{
				if (wpos.west(i).getBlock() == MRef.coreVField)
				{
					x = wpos.west(i).getX();
					flag = true;
					break;
				}
			}
		}
		
		if (flag == false)
		{
			System.out.print("x");
			return;
		}
		
		System.out.println("x" + x + "z" + z);
		
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
		
		TileVField tile1 = (TileVField) pos1.getTile();
		TileVField tile2 = (TileVField) pos2.getTile();
		TileVField tile3 = (TileVField) pos3.getTile();
		TileVField tile4 = (TileVField) pos4.getTile();
		if (!tile1.locked())
		{
			if (!tile2.locked())
			{
				if (!tile3.locked())
				{
					if (!tile4.locked())
					{
						tile1.startactiveFeild(pos3);
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

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) 
	{
		return new TileVField();
	}
}
