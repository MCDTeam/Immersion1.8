package cf.mcdTeam.Immersion.magic;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import cf.mcdTeam.Immersion.meta.ModMetadata;
import cf.mcdTeam.Immersion.utils.BlockDecorative;

public class MRef 
{
	public static BlockDecorative stoneMagicBrick;
	public static BlockDecorative coreVField;
	
	public static void init()
	{
		stoneMagicBrick = new BlockDecorative("stoneMagicBrick");
		coreVField = new BlockDecorative("coreVField");
	}
	
	public static void clientinit()
	{
		ItemModelMesher m = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
		
		m.register(Item.getItemFromBlock(stoneMagicBrick), 0, new ModelResourceLocation(ModMetadata.MOD_ID + ":" + "stoneMagicBrick", "inventory"));
	}
}
