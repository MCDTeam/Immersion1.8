package cf.mcdTeam.Immersion.terrainGenerator;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameData;
import net.minecraftforge.fml.common.registry.GameRegistry;
import cf.mcdTeam.Immersion.meta.ModMetadata;
import cf.mcdTeam.Immersion.terrainGenerator.blocks.BlockDebug;
import cf.mcdTeam.Immersion.terrainGenerator.blocks.BlockDecorative;
import cf.mcdTeam.Immersion.terrainGenerator.blocks.BlockMetal;
import cf.mcdTeam.Immersion.terrainGenerator.items.ItemBlockMetal;

public class TGRef 
{
	//Ores
	public static BlockMetal overOre;
	public static BlockDebug debug;
	
	public static BlockDecorative  stoneDwarven;
	
	public static void init()
	{
		overOre = new BlockMetal("ore");
		debug = new BlockDebug();
		stoneDwarven = new BlockDecorative("stoneDwarven");
	}
	
	public static void clientinit()
	{
		ItemModelMesher m = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
		
		m.register(Item.getItemFromBlock(stoneDwarven), 0, new ModelResourceLocation(ModMetadata.MOD_ID + ":" + "stoneDwarven", "inventory"));
	}
}
