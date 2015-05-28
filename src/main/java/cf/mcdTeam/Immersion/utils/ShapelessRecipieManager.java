package cf.mcdTeam.Immersion.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import net.minecraft.item.Item;

public class ShapelessRecipieManager 
{
	private final HashMap<ShapelessRecipie, Item> recipies;
	private final int order;
	
	public ShapelessRecipieManager (int order)
	{
		this.order = order;
		recipies = new HashMap<ShapelessRecipie, Item>();
	}
	
	public void addRecipie (ShapelessRecipie recipie, Item output)
	{
		if (recipie.getOrder() == order)
		{
			recipies.put(recipie, output);
		}
	}
	
	public void removeRecipie(ShapelessRecipie recipie)
	{
		recipies.remove(recipie);
	}
	
	public Item getOutputForRecipie(ShapelessRecipie recipie)
	{
		return recipies.get(recipie);
	}
	
	public Boolean doesRecipieHaveOutput(ShapelessRecipie recipie)
	{
		return recipies.containsKey(recipie);
	}
	
	public Boolean isPossibleToObtain (Item item)
	{
		return recipies.containsValue(item);
	}
	
	public ArrayList<ShapelessRecipie> getWaysToObtain (Item item)
	{
		ArrayList<ShapelessRecipie> rto = new ArrayList<ShapelessRecipie>();
		for (Entry<ShapelessRecipie, Item> r:recipies.entrySet())
		{
			if (r.getValue() == item)
			{
				rto.add(r.getKey());
			}
		}
		return null;
	}
}
