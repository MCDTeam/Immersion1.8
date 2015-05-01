package cf.mcdTeam.Immersion.terrainGenerator;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameData;
import net.minecraftforge.fml.common.registry.GameRegistry;
import cf.mcdTeam.Immersion.terrainGenerator.blocks.BlockDebug;
import cf.mcdTeam.Immersion.terrainGenerator.blocks.BlockMetal;
import cf.mcdTeam.Immersion.terrainGenerator.items.ItemBlockMetal;

public class TGRef 
{
	//Ores
	public static BlockMetal overOre;
	public static BlockDebug debug;
	
	public static void init()
	{
		overOre = new BlockMetal("ore");
		GameRegistry.registerBlock(overOre, ItemBlockMetal.class, "oreMetal");
		debug = new BlockDebug();
		GameRegistry.registerBlock(debug, "debug");
	}
	
	public static void clientinit()
	{
		
	}
}
