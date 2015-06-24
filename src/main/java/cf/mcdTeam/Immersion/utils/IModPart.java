package cf.mcdTeam.Immersion.utils;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;

public interface IModPart
{
	public void preInit();
	public void Init();
	public void postInit();
	public void proxyInit();
}
