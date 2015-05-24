package cf.mcdTeam.Immersion.magic.block.tile.container;

import cf.mcdTeam.Immersion.magic.block.tile.TileVCombiner;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerVCombiner extends Container
{
	final TileVCombiner tile;
	
	public ContainerVCombiner(InventoryPlayer player, TileVCombiner tile)
	{
		this.tile = tile;
		this.addSlotToContainer(new Slot(tile, 0, 56, 17));
		this.addSlotToContainer(new Slot(tile, 1, 56, 53));
		this.addSlotToContainer(new SlotOutput(tile, 2, 116, 35));
		
        int i;
        for (i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(player, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(player, i, 8 + i * 18, 142));
        }
        
	}
	
	// TODO Shift Click Dumbness

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return tile.isUseableByPlayer(player);
	}
	
	public class SlotOutput extends Slot {
		public SlotOutput(IInventory inventory, int index, int x, int y) 
		{
			super(inventory, index, x, y);
		}
		
		@Override
		public boolean isItemValid(ItemStack stack) 
		{
			return false;
		}
		// TODO EXP
	}
}
