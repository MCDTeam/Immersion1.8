package cf.mcdTeam.Immersion.survivalOverhaul;

import cf.mcdTeam.Immersion.survivalOverhaul.block.ModBlocks;
import cf.mcdTeam.Immersion.survivalOverhaul.events.PlayerEvent;
import cf.mcdTeam.Immersion.utils.IModPart;
import net.minecraftforge.common.MinecraftForge;

public class SOPart implements IModPart {

	@Override
	public void preInit() 
	{
		ModBlocks.init();
	}

	@Override
	public void Init() {

		MinecraftForge.EVENT_BUS.register(new PlayerEvent());
	}

	@Override
	public void postInit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void proxyInit() {
		// TODO Auto-generated method stub

	}

}
