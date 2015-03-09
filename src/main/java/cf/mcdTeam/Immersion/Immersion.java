package cf.mcdTeam.Immersion;

import cf.mcdTeam.Immersion.meta.ModMetadata;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = ModMetadata.MOD_ID, name = ModMetadata.NAME, version = ModMetadata.VERSION)
public class Immersion {

    public static Logger log = LogManager.getLogger(ModMetadata.MOD_ID);

    @Mod.Instance
    public static Immersion instance;

    public void preInit(FMLPreInitializationEvent event){

    }

    public void Init(FMLInitializationEvent event){

    }

    public void postInit(FMLPostInitializationEvent event){

    }
}
