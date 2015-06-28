package cf.mcdTeam.Immersion.magic.item;

import cf.mcdTeam.Immersion.magic.vpenergy.IVoidPulseAcceptor;
import cf.mcdTeam.Immersion.utils.WorldBlockPos;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemPortableVoidPulsar extends Item
{
	public ItemPortableVoidPulsar()
	{
		maxStackSize = 1;
		setUnlocalizedName("portableVoidPulsar");
		GameRegistry.registerItem(this, "portableVoidPulsar");
	}
	
	@Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
		if (world.isRemote)
		{
			return stack;
		}
		
		MovingObjectPosition position = getMovingObjectPositionFromPlayer(world, player, true);
		if (position.typeOfHit == MovingObjectType.BLOCK)
		{
			WorldBlockPos pos = new WorldBlockPos(world, position.getBlockPos());
			TileEntity tile = pos.getTile();
			if (tile != null)
			{
				if (tile instanceof IVoidPulseAcceptor)
				{
					if (player.inventory.hasItem(Items.ender_pearl))
					{
						player.inventory.consumeInventoryItem(Items.ender_pearl);
						((IVoidPulseAcceptor) tile).acceptPulse(16);
					}
				}
			}
		}
		return stack;
    }
}
