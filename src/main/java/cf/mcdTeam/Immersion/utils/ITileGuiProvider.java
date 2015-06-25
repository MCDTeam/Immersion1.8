package cf.mcdTeam.Immersion.utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public interface ITileGuiProvider 
{
	public Object serverGui(int ID, EntityPlayer player);
	public Object clientGui(int ID, EntityPlayer player);
}
