package cf.mcdTeam.Immersion.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import scala.actors.threadpool.Arrays;
import net.minecraft.item.Item;

public class ShapelessRecipieManager 
{
	private final HashMap<Recipie, Item> recipies;
	private final int order;
	
	public ShapelessRecipieManager (int order)
	{
		this.order = order;
		recipies = new HashMap<Recipie, Item>();
	}
	
	public void addRecipie (Recipie recipie, Item output)
	{
		if (recipie.getOrder() == order)
		{
			recipies.put(recipie, output);
		}
	}
	
	public void removeRecipie(Recipie recipie)
	{
		recipies.remove(recipie);
	}
	
	public Item getOutputForRecipie(Recipie recipie)
	{
		return recipies.get(recipie);
	}
	
	public Boolean doesRecipieHaveOutput(Recipie recipie)
	{
		return recipies.containsKey(recipie);
	}
	
	public Boolean isPossibleToObtain (Item item)
	{
		return recipies.containsValue(item);
	}
	
	public ArrayList<Recipie> getWaysToObtain (Item item)
	{
		recipies.
		return null;
	}
	
	public class Recipie
	{
		private Item[] recipie;
		private int order;
		
		public Recipie (Item ... recipie)
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
			if (obj instanceof Recipie)
			{
				Recipie compare = (Recipie) obj;
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
}
