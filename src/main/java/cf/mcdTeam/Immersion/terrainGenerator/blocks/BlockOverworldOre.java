package cf.mcdTeam.Immersion.terrainGenerator.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockOverworldOre extends Block {

    public static final PropertyEnum TYPE = PropertyEnum.create("type", BlockOverworldOre.OreType.class);
	
    public BlockOverworldOre() 
	{
		super(Material.rock);
        this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, OreType.Iron));
        this.setCreativeTab(CreativeTabs.tabBlock);
        GameRegistry.registerBlock(this, "overworldOre");
	}
	
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
    {
    	for(OreType type : OreType.values())
    	{
    		list.add(new ItemStack(this, 1, type.metadata));
    	}
    }
    
    public int getDamageValue(World worldIn, BlockPos pos)
    {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        return iblockstate.getBlock() != this ? 0 : ((OreType)iblockstate.getValue(TYPE)).getMetadata();
    }

    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(TYPE, OreType.byMetadata(meta));
    }
    
    public int getMetaFromState(IBlockState state)
    {
        return ((BlockDirt.DirtType)state.getValue(TYPE)).getMetadata();
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {TYPE});
    }

    public int damageDropped(IBlockState state)
    {
        OreType type = (OreType)state.getValue(TYPE);
        return type.getMetadata();
    }
    
	public static enum OreType implements IStringSerializable
	{
		Iron ("oreIron", 0, 3),
		Tungsten ("oreTungsten", 1, 5),
		Silver("oreSilver", 2, 2),
		Gold("oreGold", 3, 2),
		Mythril("oreMythril", 4, 4),
		Adamantium("oreAdamantium", 5, 5),
		Tin("oreTin", 6, 1),
		Copper("oreCopper", 7, 1);
		
		public final String name;
		public final int metadata;
		public final int breakvalue;
		private static final OreType[] METADATA_LOOKUP = new OreType[values().length];
		private OreType(String name, int metadata, int breakvalue)
		{
			this.name = name;
			this.metadata = metadata;
			this.breakvalue = breakvalue;
		}
		
        public int getMetadata()
        {
            return this.metadata;
        }

        public String getUnlocalizedName()
        {
            return this.name;
        }

        public String toString()
        {
            return this.name;
        }

        public static OreType byMetadata(int metadata)
        {
            if (metadata < 0 || metadata >= METADATA_LOOKUP.length)
            {
                metadata = 0;
            }

            return METADATA_LOOKUP[metadata];
        }

        public String getName()
        {
            return this.name;
        }

        static
        {
            OreType[] values = values();
            int l = values.length;

            for (int t = 0; t < l; ++t)
            {
                OreType var3 = values[t];
                METADATA_LOOKUP[var3.getMetadata()] = var3;
            }
        }
	}
}
