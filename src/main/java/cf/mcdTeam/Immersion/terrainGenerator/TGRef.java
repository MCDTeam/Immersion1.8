package cf.mcdTeam.Immersion.terrainGenerator;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
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
		RenderItem render = Minecraft.getMinecraft().getRenderItem();
		
		render.getItemModelMesher().register(Item.getItemFromBlock(TGRef.overOre), 0, new ModelResourceLocation("immersion:ironOre", "inventory"));
		render.getItemModelMesher().register(Item.getItemFromBlock(TGRef.overOre), 1, new ModelResourceLocation("immersion:tungstenOre", "inventory"));
		render.getItemModelMesher().register(Item.getItemFromBlock(TGRef.overOre), 2, new ModelResourceLocation("immersion:silverOre", "inventory"));
		render.getItemModelMesher().register(Item.getItemFromBlock(TGRef.overOre), 3, new ModelResourceLocation("immersion:goldOre", "inventory"));
		render.getItemModelMesher().register(Item.getItemFromBlock(TGRef.overOre), 4, new ModelResourceLocation("immersion:mythrilOre", "inventory"));
		render.getItemModelMesher().register(Item.getItemFromBlock(TGRef.overOre), 5, new ModelResourceLocation("immersion:adamantiumOre", "inventory"));
		render.getItemModelMesher().register(Item.getItemFromBlock(TGRef.overOre), 6, new ModelResourceLocation("immersion:tinOre", "inventory"));
		render.getItemModelMesher().register(Item.getItemFromBlock(TGRef.overOre), 7, new ModelResourceLocation("immersion:copperOre", "inventory"));
	}
}
