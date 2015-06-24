package cf.mcdTeam.Immersion.magic;

import cf.mcdTeam.Immersion.utils.IModPart;

public class MPart implements IModPart {

	@Override
	public void preInit() 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void Init() 
	{
		MRef.init();

	}

	@Override
	public void postInit() 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void proxyInit() 
	{
		MRef.clientinit();

	}
}
