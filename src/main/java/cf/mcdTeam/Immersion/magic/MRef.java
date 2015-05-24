package cf.mcdTeam.Immersion.magic;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import cf.mcdTeam.Immersion.magic.block.BlockVCombiner;
import cf.mcdTeam.Immersion.magic.block.CoreVField;
import cf.mcdTeam.Immersion.meta.ModMetadata;
import cf.mcdTeam.Immersion.utils.BlockDecorative;
import cf.mcdTeam.Immersion.utils.CreativeTab;

public class MRef 
{
	public static BlockDecorative stoneMagicBrick;
	public static CoreVField coreVField;
	public static BlockVCombiner vCombiner;
	public static CreativeTab magictab;
	
	public static void init()
	{
		stoneMagicBrick = new BlockDecorative("stoneMagicBrick");
		coreVField = new CoreVField();
		vCombiner = new BlockVCombiner();
		
		magictab = new CreativeTab("imagic", Item.getItemFromBlock(coreVField));
		coreVField.setCreativeTab(magictab);
		stoneMagicBrick.setCreativeTab(magictab);
		vCombiner.setCreativeTab(magictab);
	}
	
	public static void clientinit()
	{
		ItemModelMesher m = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
		
		m.register(Item.getItemFromBlock(stoneMagicBrick), 0, new ModelResourceLocation(ModMetadata.MOD_ID + ":" + "stoneMagicBrick", "inventory"));
		m.register(Item.getItemFromBlock(coreVField), 0, new ModelResourceLocation(ModMetadata.MOD_ID + ":" + "coreVField", "inventory"));
	}
}
