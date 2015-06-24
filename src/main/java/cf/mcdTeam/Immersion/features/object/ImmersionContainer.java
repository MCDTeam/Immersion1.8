package cf.mcdTeam.Immersion.features.object;

import cf.mcdTeam.Immersion.base.ResourceProvider;
import cf.mcdTeam.Immersion.features.object.IImersionObject;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ImmersionContainer extends BlockContainer implements IImersionObject {

    private static final Material DEFAULT_MATERIAL = Material.rock;

    public ImmersionContainer() {
        this(null, DEFAULT_MATERIAL);
    }

    public ImmersionContainer(String name, Material material) {
        super(material);

        if (name == null)
            name = this.inferName();

        this.setUnlocalizedName(ResourceProvider.getBlockName(name));

        //Sets a basic creative tab so that it is accessible. Calling this in the constuructor overrides this
        //this.setCreativeTab(FeatureCreativeTab.tabImmersionCore);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return null;
    }

    private String inferName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void craftingRegistration() {

    }

    @Override
    public void forgeOreDict() {

    }
}
