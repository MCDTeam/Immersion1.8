package cf.mcdTeam.Immersion.terrainGenerator.Generators;

import java.util.ArrayList;

import net.minecraft.init.Blocks;
import cf.mcdTeam.Immersion.utils.WorldBlockPos;

public class HollowMountain 
{
	public static void MountainHollow(WorldBlockPos hollow)
	{
		WorldBlockPos center = hollow.getposatY(1);
		
		ArrayList<WorldBlockPos> toAir = new ArrayList<WorldBlockPos>();
		
		for (WorldBlockPos pos : DefineMountain(center))
		{
			pos = pos.getposatY(5);
			
			do
			{
				if (isValidToRemove(pos)) toAir.add(pos);
				pos = pos.up();
			} while (pos.getY() <= 256);
		}
		
		for (WorldBlockPos pos : toAir)
		{
			pos.setAir();
		}
	}
	
	public static ArrayList<WorldBlockPos> DefineMountain(WorldBlockPos start)
	{
		ArrayList<WorldBlockPos> possiblepos = new ArrayList<WorldBlockPos>();
		ArrayList<WorldBlockPos> confirmedpos = new ArrayList<WorldBlockPos>();
		
		possiblepos.add(start);
		
		do
		{
			ArrayList<WorldBlockPos> newpossiblepos = new ArrayList<WorldBlockPos>();
			
			for (WorldBlockPos pos : possiblepos)
			{
				if (pos.getWorld().getBiomeGenForCoords(start).biomeID == 3 && pos.topBlock().getY() >= 80)
				{
					confirmedpos.add(pos);
				
					if (!confirmedpos.contains(pos.north()) && !newpossiblepos.contains(pos.north()))
					{
						newpossiblepos.add(pos.north());
					}
					if (!confirmedpos.contains(pos.east()) && !newpossiblepos.contains(pos.east()))
					{
						newpossiblepos.add(pos.east());
					}
					if (!confirmedpos.contains(pos.south()) && !newpossiblepos.contains(pos.south()))
					{
						newpossiblepos.add(pos.south());
					}
					if (!confirmedpos.contains(pos.west()) && !newpossiblepos.contains(pos.west()))
					{
						newpossiblepos.add(pos.west());
					}
					
				}
			}
			
			possiblepos = newpossiblepos;
			
		} while (!possiblepos.isEmpty());
		
		return confirmedpos;
	}
	
	public static Boolean isValidToRemove (WorldBlockPos pos)
	{
		if (pos.getX() <= 63) return true;
		if (pos.up().isAir() || pos.up().is(Blocks.dirt)) return false;
		if (pos.down().isAir() || pos.down().is(Blocks.dirt)) return false;
		if (pos.north().isAir() || pos.north().is(Blocks.dirt)) return false;
		if (pos.south().isAir() || pos.south().is(Blocks.dirt)) return false;
		if (pos.east().isAir() || pos.east().is(Blocks.dirt)) return false;
		if (pos.west().isAir() || pos.west().is(Blocks.dirt)) return false;
		return true;
	}
}
