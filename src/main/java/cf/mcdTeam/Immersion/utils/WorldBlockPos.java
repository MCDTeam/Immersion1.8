package cf.mcdTeam.Immersion.utils;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

/**
 * This adds world functions to the BlockPos function of Minecraft
 * Finished BCWADSWORTH on 12/28/14
 */
public class WorldBlockPos extends BlockPos
{
	
	private World world;
	
	public World getWorld()
	{
		return this.world;
	}
	
	public WorldBlockPos(World world, int x, int y, int z)
	{
		super(x, y, z);
		this.world = world;
	}
	
	public WorldBlockPos(World world, BlockPos position)
	{
		super(position.getX(), position.getY(), position.getZ());
		this.world = world;
	}
	
	public Block getBlock()
	{
		return world.getBlockState(this).getBlock();
	}
	
	public IBlockState getState()
	{
		return world.getBlockState(this);
	}
	
	public void setBlock(IBlockState state)
	{
		world.setBlockState(this, state);
	}
	
	public void setAir()
	{
		world.setBlockToAir(this);
	}
	
	public boolean isAir()
	{
		return world.isAirBlock(this);
	}
	
	public boolean is(Block block)
	{
		return world.getBlockState(this).getBlock() == block;
	}
	
	public WorldBlockPos topBlock()
	{
		return new WorldBlockPos(world, world.getTopSolidOrLiquidBlock(this));
	}
	
	@Override
	public WorldBlockPos north()
	{
		return new WorldBlockPos(world, super.north());
	}
	
	@Override
	public WorldBlockPos east()
	{
		return new WorldBlockPos(world, super.east());
	}
	
	@Override
	public WorldBlockPos south()
	{
		return new WorldBlockPos(world, super.south());
	}
	
	@Override
	public WorldBlockPos west()
	{
		return new WorldBlockPos(world, super.west());
	}
	
	@Override
	public WorldBlockPos up()
	{
		return new WorldBlockPos(world, super.up());
	}
	
	@Override
	public WorldBlockPos down()
	{
		return new WorldBlockPos(world, super.down());
	}
	
	@Override
	public WorldBlockPos north(int n)
	{
		return new WorldBlockPos(world, super.north(n));
	}
	
	@Override
	public WorldBlockPos east(int n)
	{
		return new WorldBlockPos(world, super.east(n));
	}
	
	@Override
	public WorldBlockPos south(int n)
	{
		return new WorldBlockPos(world, super.south(n));
	}
	
	@Override
	public WorldBlockPos west(int n)
	{
		return new WorldBlockPos(world, super.west(n));
	}
	
	@Override
	public WorldBlockPos up(int n)
	{
		return new WorldBlockPos(world, super.up(n));
	}
	
	@Override
	public WorldBlockPos down(int n)
	{
		return new WorldBlockPos(world, super.down(n));
	}
	
	public WorldBlockPos getposatX(int x)
	{
		return new WorldBlockPos(world, x, this.getY(), this.getZ());
	}
	
	public WorldBlockPos getposatY(int y)
	{
		return new WorldBlockPos(world, this.getX(), y, this.getZ());
	}
	
	public WorldBlockPos getposatZ(int z)
	{
		return new WorldBlockPos(world, this.getX(), this.getY(), z);
	}
	
	@Override
	public String toString()
	{
		return "[" + this.getX() + ", " + this.getX() + ", " + this.getX() + "] ";
	}
}
