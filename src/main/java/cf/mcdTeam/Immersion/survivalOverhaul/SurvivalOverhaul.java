package cf.mcdTeam.Immersion.survivalOverhaul;

import cf.mcdTeam.Immersion.features.Feature;
import cf.mcdTeam.Immersion.features.FeatureCommon;
import cf.mcdTeam.Immersion.survivalOverhaul.block.ModBlocks;
import cf.mcdTeam.Immersion.survivalOverhaul.events.PlayerEvent;
import cf.mcdTeam.Immersion.utils.ModPart;
import net.minecraftforge.common.MinecraftForge;

@Feature(name = "Survival Overhaul", version = "0.1")
public class SurvivalOverhaul extends FeatureCommon {

	@Feature.FeatureElement(Feature.FeatureElement.Element.PREINITIALIZATION)
	public void preInit() {


	}

	@Feature.FeatureElement(Feature.FeatureElement.Element.INTITIALIZATION)
	public void Init() {

	}

	@Feature.FeatureElement(Feature.FeatureElement.Element.POSTINITIALIZATION)
	public void postInit() {

	}

	@Feature.FeatureElement(Feature.FeatureElement.Element.EVENTBUS_EVENT)
	public void registerEvents() {

		MinecraftForge.EVENT_BUS.register(new PlayerEvent());
	}
}
