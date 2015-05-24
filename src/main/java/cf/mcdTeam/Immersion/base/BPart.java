package cf.mcdTeam.Immersion.base;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import cf.mcdTeam.Immersion.Immersion;
import cf.mcdTeam.Immersion.utils.ModPart;

public class BPart implements ModPart {

	@Override
	public void preInit() 
	{

	}

	@Override
	public void Init() 
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(Immersion.instance, new GuiHandler());
	}

	@Override
	public void postInit() 
	{

	}

	@Override
	public void proxyInit() 
	{

	}

}
