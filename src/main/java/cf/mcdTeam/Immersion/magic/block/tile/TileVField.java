package cf.mcdTeam.Immersion.magic.block.tile;

import java.util.ArrayList;
import java.util.Iterator;

import cf.mcdTeam.Immersion.utils.WorldBlockPos;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;

public class TileVField extends TileEntity implements IUpdatePlayerListBox
{
	Boolean active = false;
	Boolean lock = false;
	
	WorldBlockPos feildpos = null;
	

	public void startactiveFeild(WorldBlockPos posxy)
	{
		feildpos = posxy;
		WorldBlockPos pos = new WorldBlockPos(this.getWorld(), this.getPos());
		TileVField work = (TileVField) pos.getposatX(feildpos.getX()).getTile();
		work.lock(pos);
		work = (TileVField) pos.getposatZ(feildpos.getZ()).getTile();
		work.lock(pos);
		work = (TileVField) feildpos.getTile();
		work.lock(pos);
		lock = true;
		active = true;
	}
	
	public void stopactiveFeild()
	{

		lock = false;
		active = false;
		WorldBlockPos pos = new WorldBlockPos(this.getWorld(), this.getPos());
		TileVField work = (TileVField) pos.getposatX(feildpos.getX()).getTile();
		work.unlock();
		work = (TileVField) pos.getposatZ(feildpos.getZ()).getTile();
		work.unlock();
		work = (TileVField) feildpos.getTile();
		work.unlock();
		feildpos = null;
	}
	
	public Boolean active()
	{
		return active;
	}
	
	public void lock(WorldBlockPos activefeild)
	{
		lock = true;
		this.feildpos = activefeild;
	}
	
	public void unlock()
	{
		lock = false;
		feildpos = null;
	}
	
	public Boolean locked()
	{
		return lock;
	}
	
	public void onBreak()
	{
		if (active)
		{
			this.stopactiveFeild();
		}
		else
		{
			TileVField work = (TileVField) feildpos.getTile();
			work.stopactiveFeild();
		}
	}
	
	@Override
    public void readFromNBT(NBTTagCompound c)
    {
		super.readFromNBT(c);
		if (c != null)
		{
			active = c.getBoolean("active");
			lock = c.getBoolean("lock");
			if (lock)
			{
				feildpos = new WorldBlockPos(this.getWorld(), c.getInteger("fx"), c.getInteger("fy"), c.getInteger("fz"));
			}
		}
    }
	
	@Override
    public void writeToNBT(NBTTagCompound c)
    {
    	super.writeToNBT(c);
    	
    	if (c != null)
    	{
    		c.setBoolean("active", active);
    		c.setBoolean("lock", lock);
    		
    		c.setInteger("fx", feildpos.getX());
    		c.setInteger("fy", feildpos.getY());
    		c.setInteger("fz", feildpos.getZ());
    	}
    	else
    	{
    		c = new NBTTagCompound();
    		
    		c.setBoolean("active", active);
    		c.setBoolean("lock", lock);
    		
    		if (lock)
    		{
    			c.setInteger("fx", feildpos.getX());
    			c.setInteger("fy", feildpos.getY());
    			c.setInteger("fz", feildpos.getZ());
    		}
    	}
    }


	@Override
	public void update() 
	{
		if (this.worldObj.isRemote)
		{
			return;
		}
		if (!this.active)
		{
			return;
		}
		if (!this.lock)
		{
			return;
		}
		
		Iterator poss = BlockPos.getAllInBox(this.pos, feildpos).iterator();
		ArrayList<TileEntity> tiles = new ArrayList<TileEntity>();
		
		do
		{
			BlockPos pos = (BlockPos) poss.next();
			TileEntity ent = this.worldObj.getTileEntity(pos);
			if (ent != null && !(ent instanceof TileVField))
			{
				tiles.add(this.worldObj.getTileEntity(pos));
			}
			poss.remove();
		} while (poss.hasNext());
		
		//THIS IS UNFINISHED. YAY FOR UNFINISHED STUFF!
		
	}
}
