package cf.mcdTeam.Immersion.magic.block.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;

public class TileVCombiner extends TileEntityLockable implements ISidedInventory
{
	ItemStack[] inventory = new ItemStack[3];
	
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
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasCustomName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IChatComponent getDisplayName() {
		// TODO Auto-generated method stub
		return null;
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
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGuiID() 
	{
		return "immersion:tilevcombiner";
	}

}
