package cf.mcdTeam.Immersion.utils;

import java.util.HashMap;

import cf.mcdTeam.Immersion.Immersion;
import cf.mcdTeam.Immersion.magic.block.tile.TileVCombiner;
import cf.mcdTeam.Immersion.magic.block.tile.container.ContainerVCombiner;
import cf.mcdTeam.Immersion.magic.block.tile.container.gui.GuiVCombiner;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity tile = world.getTileEntity(new BlockPos(x,y,z));
		if (tile instanceof ITileGuiProvider)
		{
			ITileGuiProvider gui = (ITileGuiProvider) tile;
			return gui.serverGui(ID, player);
		}
		else
		{
			return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity tile = world.getTileEntity(new BlockPos(x,y,z));
		if (tile instanceof ITileGuiProvider)
		{
			ITileGuiProvider gui = (ITileGuiProvider) tile;
			return gui.clientGui(ID, player);
		}
		else
		{
			return null;
		}
	}
}
