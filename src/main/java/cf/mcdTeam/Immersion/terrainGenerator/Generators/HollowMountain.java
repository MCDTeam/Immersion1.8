package cf.mcdTeam.Immersion.terrainGenerator.Generators;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import cf.mcdTeam.Immersion.utils.WorldBlockPos;

public class HollowMountain 
{
	public static void MountainHollow(WorldBlockPos hollow)
	{
		WorldBlockPos center = hollow.getposatY(1);
		
		ArrayList<WorldBlockPos> toAir = new ArrayList<WorldBlockPos>();
		
		for (WorldBlockPos pos : FindFakeMountain(center))
		{
			pos = pos.getposatY(2);
			do
			{
				pos.setBlock(Blocks.stone.getDefaultState());
				pos = pos.up();
			} while (pos.getY() <= 7);

			Block block = pos.topBlock().getBlock();
			int top;
			if (block == Blocks.stone || block == Blocks.grass || block == Blocks.dirt) top = pos.topBlock().getY() - 5;
			else
			{
				System.out.println("Processing");
				WorldBlockPos poss = pos.topBlock();
				do
				{
					poss = poss.down();
					block = poss.getBlock();
					System.out.println(poss.getY());
				} while (!(block == Blocks.stone || block == Blocks.grass || block == Blocks.dirt));
				top = poss.getY() - 5;
			}
			
			do
			{
				toAir.add(pos);
				pos = pos.up();
			} while (pos.getY() < top);
			System.out.println("Processed" + toAir.size());
		}
		
		System.out.println("Clearing" + toAir.size());
		GeneratorUtils.ClearAll(toAir);
	}
	
	public static ArrayList<WorldBlockPos> FindFakeMountain(WorldBlockPos start)
	{
		ArrayList<WorldBlockPos> possiblepos = new ArrayList<WorldBlockPos>();
		ArrayList<WorldBlockPos> confirmedpos = new ArrayList<WorldBlockPos>();
		
		possiblepos.add(start);
		
		do
		{
			ArrayList<WorldBlockPos> newpossiblepos = new ArrayList<WorldBlockPos>();
			
			for (WorldBlockPos pos : possiblepos)
			{
				if (pos.topBlock().getY() >= 90)
				{
					confirmedpos.add(pos);
				
					System.out.println("Nother");
					if (!confirmedpos.contains(pos.north()) && !newpossiblepos.contains(pos.north()) && !possiblepos.contains(pos.north()))
					{
						newpossiblepos.add(pos.north());
					}
					if (!confirmedpos.contains(pos.east()) && !newpossiblepos.contains(pos.east()) && !possiblepos.contains(pos.east()))
					{
						newpossiblepos.add(pos.east());
					}
					if (!confirmedpos.contains(pos.south()) && !newpossiblepos.contains(pos.south()) && !possiblepos.contains(pos.south()))
					{
						newpossiblepos.add(pos.south());
					}
					if (!confirmedpos.contains(pos.west()) && !newpossiblepos.contains(pos.west()) && !possiblepos.contains(pos.west()))
					{
						newpossiblepos.add(pos.west());
					}
					
				}
			}
			
			possiblepos = newpossiblepos;
			
		} while (!possiblepos.isEmpty());
		
		System.out.println("Finished" + confirmedpos.size());
		return confirmedpos;
	}
}
