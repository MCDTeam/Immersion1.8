package cf.mcdTeam.Immersion;

import cf.mcdTeam.Immersion.base.BPart;
import cf.mcdTeam.Immersion.magic.MPart;
import cf.mcdTeam.Immersion.meta.ModMetadata;
import cf.mcdTeam.Immersion.survivalOverhaul.SOPart;
import cf.mcdTeam.Immersion.technology.TPart;
import cf.mcdTeam.Immersion.terrainGenerator.TGPart;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = ModMetadata.MOD_ID, name = ModMetadata.NAME, version = ModMetadata.VERSION)
public class Immersion {

    public static Logger log = LogManager.getLogger(ModMetadata.MOD_ID);

    public static BPart B = new BPart();
    public static MPart M = new MPart();
    public static SOPart SO = new SOPart();
    public static TPart T = new TPart();
    public static TGPart TG = new TGPart();
    
    @Mod.Instance
    public static Immersion instance;

	@Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	B.preInit();
    	M.preInit();
    	SO.preInit();
    	T.preInit();
    	TG.preInit();
    }

	@Mod.EventHandler
    public void Init(FMLInitializationEvent event)
    {
    	B.Init();
    	M.Init();
    	SO.Init();
    	T.Init();
    	TG.Init();
    	
    	if (event.getSide() == Side.CLIENT)
    	{
        	B.proxyInit();
        	M.proxyInit();
        	SO.proxyInit();
        	T.proxyInit();
        	TG.proxyInit();
    	}
    }

	@Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	B.postInit();
    	M.postInit();
    	SO.postInit();
    	T.postInit();
    	TG.postInit();
    }
}
