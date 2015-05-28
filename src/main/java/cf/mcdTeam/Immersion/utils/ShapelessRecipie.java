package cf.mcdTeam.Immersion.utils;

import java.util.List;

import net.minecraft.item.Item;
import scala.actors.threadpool.Arrays;

public class ShapelessRecipie
{
	private Item[] recipie;
	private int order;
	
	public ShapelessRecipie (Item ... recipie)
	{
		this.recipie = recipie;
		this.order = this.recipie.length;
	}
	
	public Item[] getRecipie() 
	{
		return recipie;
	}

	public int getOrder() 
	{
		return order;
	}
	
	public Boolean isOrder(int order)
	{
		if (this.order == order)
		{
			return true;
		}
		return false;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof ShapelessRecipie)
		{
			ShapelessRecipie compare = (ShapelessRecipie) obj;
			List thisrec = Arrays.asList(this.recipie);
			if (thisrec.containsAll(Arrays.asList(compare.getRecipie())))
			{
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode()
	{
		return order;
	}
}