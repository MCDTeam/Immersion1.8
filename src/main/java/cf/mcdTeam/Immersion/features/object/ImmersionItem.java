package cf.mcdTeam.Immersion.features.object;

import cf.mcdTeam.Immersion.base.ResourceProvider;
import net.minecraft.item.Item;

public class ImmersionItem extends Item implements IImersionObject
{
    protected ImmersionItem(String name) {

        if (name == null)
            name = this.inferName();

        this.setUnlocalizedName(ResourceProvider.getBlockName(name));

        // Override if needed
        //this.setCreativeTab(FeatureCreativeTab.tabImmersionCore);
    }

    private String inferName() {
        return this.getClass().getSimpleName();
    }

    @Override
	public void craftingRegistration() 
	{

	}

	@Override
	public void forgeOreDict() 
	{

	}
}
