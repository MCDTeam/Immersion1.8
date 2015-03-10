package cf.mcdTeam.Immersion.terrainGenerator.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockOre extends Block {

	protected BlockOre() 
	{
		super(Material.rock);
	}
	public static enum OreType
	{
		Iron ("oreIron", 3),
		Tungsten ("oreTungsten", 5),
		Silver("oreSilver", 2),
		Gold("oreGold", 2),
		Mythril("oreMythril", 4),
		Adamantium("oreAdamantium", 5),
		Tin("oreTin", 1),
		Copper("oreCopper", 1);
		
		public final String name;
		public final int breakvalue;
		private OreType(String name, int breakvalue)
		{
			this.name = name;
			this.breakvalue = breakvalue;
		}
	}
}
