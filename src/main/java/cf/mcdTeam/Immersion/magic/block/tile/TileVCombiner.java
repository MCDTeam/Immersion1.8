package cf.mcdTeam.Immersion.magic.block.tile;

import cf.mcdTeam.Immersion.magic.block.tile.container.ContainerVCombiner;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;

public class TileVCombiner extends TileEntityLockable implements ISidedInventory, IUpdatePlayerListBox
{
	ItemStack[] inventory = new ItemStack[3];
	String name = null;
	
	@Override
	public int getSizeInventory() 
	{
		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int index) 
	{
		return inventory[index];
	}

	@Override
	public ItemStack decrStackSize(int index, int count) 
	{
        if (this.inventory[index] != null)
        {
            ItemStack itemstack;

            if (this.inventory[index].stackSize <= count)
            {
                itemstack = this.inventory[index];
                this.inventory[index] = null;
                return itemstack;
            }
            else
            {
                itemstack = this.inventory[index].splitStack(count);

                if (this.inventory[index].stackSize == 0)
                {
                    this.inventory[index] = null;
                }

                return itemstack;
            }
        }
        else
        {
            return null;
        }
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int index) 
	{
		return inventory[index];
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) 
	{
		inventory[index] = stack;
	}

	@Override
	public int getInventoryStackLimit() 
	{
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return this.worldObj.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
	}

	@Override
	public void openInventory(EntityPlayer player) {}

	@Override
	public void closeInventory(EntityPlayer player) {}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) 
	{
		return index != 3;
	}

	@Override
	public int getField(int id) 
	{
		return 0;
	}

	@Override
	public void setField(int id, int value) {}

	@Override
	public int getFieldCount() {return 0;}

	@Override
	public void clear() 
	{
		inventory[0] = null;
		inventory[1] = null;
		inventory[2] = null;
	}

	@Override
	public String getName() 
	{
		return this.hasCustomName() ? name : "container.vcombiner";
	}

	@Override
	public boolean hasCustomName() 
	{
		return name != null;
	}
	
    public void setCustomInventoryName(String name)
    {
        this.name = name;
    }

	@Override
	public int[] getSlotsForFace(EnumFacing side) 
	{
		return side == EnumFacing.DOWN ? new int[] {2} : (side == EnumFacing.UP ? new int[] {0} : new int[] {1});
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStack, EnumFacing direction) 
	{
		return index != 2;
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) 
	{
		return index == 2;
	}

	@Override
	public Container createContainer(InventoryPlayer playerI, EntityPlayer player) 
	{
		return new ContainerVCombiner(playerI, this);
	}

	@Override
	public String getGuiID() 
	{
		return "immersion:vcombiner";
	}
	
	@Override
	public void readFromNBT(NBTTagCompound c) 
	{
		super.readFromNBT(c);
		NBTTagList l = c.getTagList("inventory", 10);
		for (int i = 0; i < l.tagCount(); i ++)
		{
			inventory[l.getCompoundTagAt(i).getInteger("slot")] = ItemStack.loadItemStackFromNBT(l.getCompoundTagAt(i));
		}
		
        if (c.hasKey("CustomName", 8))
        {
            this.name = c.getString("CustomName");
        }
	}
	
	@Override
	public void writeToNBT(NBTTagCompound c) 
	{
		super.writeToNBT(c);
		NBTTagList l = new NBTTagList();
		
		NBTTagCompound i;
		
		if (inventory[0] != null)
		{
			i = new NBTTagCompound();
			i.setInteger("slot", 0);
			inventory[0].writeToNBT(i);
			l.appendTag(i);
		}
		
		if (inventory[1] != null)
		{
			i = new NBTTagCompound();
			i.setInteger("slot", 1);
			inventory[1].writeToNBT(i);
			l.appendTag(i);
		}
		
		if (inventory[2] != null)
		{
			i = new NBTTagCompound();
			i.setInteger("slot", 2);
			inventory[2].writeToNBT(i);
			l.appendTag(i);
		}
		
		c.setTag("inventory", l);
		
        if (this.hasCustomName())
        {
            c.setString("CustomName", this.name);
        }
	}

	@Override
	public void update() 
	{
		if (this.worldObj.isRemote)
		{
			return;
		}
		
		if (inventory[0] == null || inventory[1] == null)
		{
			return;
		}
		
		if (inventory[0].getItem() == Items.ender_pearl && inventory[1].getItem() == Items.blaze_powder)
		{	
			if (inventory[2] == null)
			{
				inventory[0].splitStack(1);
				if (inventory[0].stackSize <= 0)
				{
					inventory[0] = null;
				}
				
				inventory[1].splitStack(1);
				if (inventory[1].stackSize <= 0)
				{
					inventory[1] = null;
				}
				
				inventory[2] = new ItemStack(Items.ender_eye);
				this.markDirty();
				return;
			}
			
			if (inventory[2].getItem() == Items.ender_eye && inventory[2].stackSize < 64)
			{
				inventory[0].splitStack(1);
				if (inventory[0].stackSize <= 0)
				{
					inventory[0] = null;
				}
				
				inventory[1].splitStack(1);
				if (inventory[1].stackSize <= 0)
				{
					inventory[1] = null;
				}
				inventory[2].stackSize ++;
				this.markDirty();
				return;
			}
		}
	}
}
