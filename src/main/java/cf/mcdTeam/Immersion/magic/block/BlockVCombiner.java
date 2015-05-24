package cf.mcdTeam.Immersion.magic.block;

import cf.mcdTeam.Immersion.Immersion;
import cf.mcdTeam.Immersion.magic.block.tile.TileVCombiner;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockVCombiner extends BlockContainer
{
	public BlockVCombiner() 
	{
		super(Material.rock);
		setUnlocalizedName("blockVCombiner");
		GameRegistry.registerBlock(this, "blockVCombiner");
		GameRegistry.registerTileEntity(TileVCombiner.class, "Void Combiner");
		setHarvestLevel("pickaxe", 1);
		setHardness(1.0F);
	}
	
    public int getRenderType()
    {
        return 3;
    }

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) 
	{
		return new TileVCombiner();
	}
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state)
	{
		TileEntity tileEntity = world.getTileEntity(pos);
		if (tileEntity instanceof IInventory) 
		{
			InventoryHelper.dropInventoryItems(world, pos, (IInventory)tileEntity);
		}
		super.breakBlock(world, pos, state);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) 
	{
		if (worldIn.isRemote) return true;

		player.openGui(Immersion.instance, 0, worldIn, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}
}
