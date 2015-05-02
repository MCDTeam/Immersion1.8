package cf.mcdTeam.Immersion.terrainGenerator.blocks;

import java.util.List;

import cf.mcdTeam.Immersion.terrainGenerator.blocks.properties.EMetalType;
import cf.mcdTeam.Immersion.terrainGenerator.items.ItemBlockMetal;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockMetal extends Block {

    public static final PropertyEnum TYPE = PropertyEnum.create("type", EMetalType.class);
	
    public BlockMetal(String type) 
	{
		super(Material.rock);
        this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EMetalType.IRON));
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setUnlocalizedName(type.concat("Metal"));
        GameRegistry.registerBlock(this, ItemBlockMetal.class, type.concat("Metal"));
	}
	
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
    {
    	for(EMetalType type : EMetalType.values())
    	{
    		list.add(new ItemStack(this, 1, type.metadata));
    	}
    }
    
    public int getDamageValue(World worldIn, BlockPos pos)
    {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        return iblockstate.getBlock() != this ? 0 : ((EMetalType)iblockstate.getValue(TYPE)).getMetadata();
    }

    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(TYPE, EMetalType.byMetadata(meta));
    }
    
    public int getMetaFromState(IBlockState state)
    {
        EMetalType type = (EMetalType)state.getValue(TYPE);
        return type.getMetadata();
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {TYPE});
    }

    public int damageDropped(IBlockState state)
    {
    	return getMetaFromState(state);
    }
}
