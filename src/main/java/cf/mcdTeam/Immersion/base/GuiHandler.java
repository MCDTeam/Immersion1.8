package cf.mcdTeam.Immersion.base;

import cf.mcdTeam.Immersion.magic.block.tile.TileVCombiner;
import cf.mcdTeam.Immersion.magic.block.tile.container.ContainerVCombiner;
import cf.mcdTeam.Immersion.magic.block.tile.container.gui.GuiVCombiner;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		switch (ID)
		{
		//Void Combiner
		case 0:
			return new ContainerVCombiner(player.inventory, (TileVCombiner) world.getTileEntity(new BlockPos(x,y,z)));
		//Not Valid
		default:
			return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		switch (ID)
		{
		//Void Combiner
		case 0:
			return new GuiVCombiner(player.inventory, (TileVCombiner) world.getTileEntity(new BlockPos(x,y,z)));
		//Not Valid
		default:
			return null;
		}
	}
}
