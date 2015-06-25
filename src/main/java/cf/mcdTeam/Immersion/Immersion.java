package cf.mcdTeam.Immersion;

import java.util.ArrayList;

import cf.mcdTeam.Immersion.base.BPart;
import cf.mcdTeam.Immersion.magic.MPart;
import cf.mcdTeam.Immersion.meta.ModMetadata;
import cf.mcdTeam.Immersion.survivalOverhaul.SOPart;
import cf.mcdTeam.Immersion.technology.TPart;
import cf.mcdTeam.Immersion.terrainGenerator.TGPart;
import cf.mcdTeam.Immersion.utils.GuiHandler;
import cf.mcdTeam.Immersion.utils.IModPart;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = ModMetadata.MOD_ID, name = ModMetadata.NAME, version = ModMetadata.VERSION)
public class Immersion 
{
	public final ArrayList<IModPart> partlist;

    public Logger log = LogManager.getLogger(ModMetadata.MOD_ID);
    
    @Mod.Instance(ModMetadata.MOD_ID)
    public static Immersion instance;

    public Immersion()
    {
    	partlist = new ArrayList<IModPart>();
    	
    	//PARTLIST CONFIGURATION
    	partlist.add(new BPart());
    	partlist.add(new MPart());
    	partlist.add(new SOPart());
    	partlist.add(new TPart());
    	partlist.add(new TGPart());
    	//END PARTLIST
    }
    
	@Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
		for (IModPart part : partlist)
		{
			part.preInit();
		}
    }

	@Mod.EventHandler
    public void Init(FMLInitializationEvent event)
    {
		for (IModPart part : partlist)
		{
			part.Init();
		}
    	NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
    }

	@Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
		for (IModPart part : partlist)
		{
			part.postInit();
		}
    	
    	if (event.getSide() == Side.CLIENT)
    	{
    		for (IModPart part : partlist)
    		{
    			part.proxyInit();
    		}
    	}
    }
}
