package cf.mcdTeam.Immersion;

import cf.mcdTeam.Immersion.base.BPart;
import cf.mcdTeam.Immersion.base.GuiHandler;
import cf.mcdTeam.Immersion.features.FeatureDataCollector;
import cf.mcdTeam.Immersion.features.FeatureRepository;
import cf.mcdTeam.Immersion.magic.MPart;
import cf.mcdTeam.Immersion.meta.ModMetadata;
import cf.mcdTeam.Immersion.survivalOverhaul.SOPart;
import cf.mcdTeam.Immersion.survivalOverhaul.SurvivalOverhaul;
import cf.mcdTeam.Immersion.technology.TPart;
import cf.mcdTeam.Immersion.terrainGenerator.TGPart;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = ModMetadata.MOD_ID, name = ModMetadata.NAME, version = ModMetadata.VERSION)
public class Immersion {

    public static Logger log = LogManager.getLogger(ModMetadata.MOD_ID);

    public static BPart B = new BPart();
    public static MPart M = new MPart();
    public static TPart T = new TPart();
    public static TGPart TG = new TGPart();
    
    @Mod.Instance
    public static Immersion instance;
	private final FeatureRepository _featureRepository;

	public Immersion(FeatureRepository featureRepository) {
		this._featureRepository = new FeatureRepository();
	}

	@Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
		_featureRepository.RegisterFeature(new FeatureDataCollector()); // this need to be first entry, as other features will not work without it

		_featureRepository.RegisterFeature(new SurvivalOverhaul());

    	B.preInit();
    	M.preInit();
    	T.preInit();
    	TG.preInit();

		//get config to send to features
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

		this._featureRepository.runPreInitialization(config);
		config.save();
    }

	@Mod.EventHandler
    public void Init(FMLInitializationEvent event)
    {
    	B.Init();
    	M.Init();
    	T.Init();
    	TG.Init();
    	NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());

		this._featureRepository.runInitialization();
    }

	@Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	B.postInit();
    	M.postInit();
    	T.postInit();
    	TG.postInit();
    	
    	if (event.getSide() == Side.CLIENT)
    	{
        	B.proxyInit();
        	M.proxyInit();
        	T.proxyInit();
        	TG.proxyInit();
    	}

		this._featureRepository.runPostInitialization();
    }
}
