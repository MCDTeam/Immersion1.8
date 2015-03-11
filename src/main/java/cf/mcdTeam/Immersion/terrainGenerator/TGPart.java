package cf.mcdTeam.Immersion.terrainGenerator;

import cf.mcdTeam.Immersion.utils.ModPart;

public class TGPart implements ModPart {

	@Override
	public void preInit() {
		TGRef.init();

	}

	@Override
	public void Init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void postInit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void proxyInit() {
		TGRef.clientinit();

	}

}
