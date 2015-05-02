package cf.mcdTeam.Immersion.terrainGenerator.Generators;

import java.util.ArrayList;

import cf.mcdTeam.Immersion.utils.WorldBlockPos;

public class GeneratorUtils 
{
	public static void ClearAll(ArrayList<WorldBlockPos> clear)
	{
		for (WorldBlockPos pos : clear)
		{
			pos.setAir();
		}
	}
	
}
