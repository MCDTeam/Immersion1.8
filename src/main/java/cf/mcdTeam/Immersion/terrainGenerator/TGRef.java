package cf.mcdTeam.Immersion.terrainGenerator;

import cf.mcdTeam.Immersion.terrainGenerator.blocks.BlockOverworldOre;

public class TGRef 
{
	//Ores
	public static BlockOverworldOre overOre;
	
	public static void init()
	{
		overOre = new BlockOverworldOre();
	}
	
	public static void clientinit()
	{
		
	}
}
