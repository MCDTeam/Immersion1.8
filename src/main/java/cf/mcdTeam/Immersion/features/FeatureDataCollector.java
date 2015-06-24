package cf.mcdTeam.Immersion.features;

import java.util.ArrayList;
import java.util.HashMap;
import cf.mcdTeam.Immersion.features.Feature.*;
import cf.mcdTeam.Immersion.features.object.FeatureObjectRegister;

@Feature(name = "DataCollector", version = "1.0", isBase = true)
public class FeatureDataCollector extends FeatureCommon
{
    public static FeatureDataCollector instance;

    public FeatureDataCollector()
    {
        instance = this;
    }
    @FeatureData(FeatureData.Data.ALTFEATURELIST)
    public ArrayList<IFeature> ALTFEATURELIST;

    @FeatureData(FeatureData.Data.FULLFEATURELIST)
    public ArrayList<IFeature> FULLFEATURELIST;

    @FeatureData(FeatureData.Data.COMPLETEFEATURELIST)
    public ArrayList<IFeature> COMPLETEFEATURELIST;

    @FeatureData(FeatureData.Data.FEATUREMAP)
    public HashMap<String, IFeature> FEATUREMAP;

    @FeatureData(FeatureData.Data.FEATUREOBJECTMAP)
    public HashMap<IFeature, FeatureObjectRegister> FEATUREOBJECTMAP;

    public IFeature getFeature (String name)
    {
        if (FEATUREMAP.containsKey(name))
        {
            return FEATUREMAP.get(name);
        }
        return null;
    }

    public String getFeatureName (IFeature feature)
    {
        return feature.getClass().getAnnotation(Feature.class).name();
    }
}
