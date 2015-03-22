package cf.mcdTeam.Immersion.terrainGenerator.items;

import cf.mcdTeam.Immersion.terrainGenerator.TGRef;
import net.minecraft.block.Block;
import cf.mcdTeam.Immersion.terrainGenerator.blocks.properties.EMetalType;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMetal extends ItemBlock
{

	public ItemBlockMetal(Block block) 
	{
		super(block);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}

    public int getMetadata(int damage)
    {
        return damage;
    }

    public String getUnlocalizedName(ItemStack stack)
    {
        return super.getUnlocalizedName() + "." + EMetalType.byMetadata(stack.getMetadata()).getUnlocalizedName();
    }
}
