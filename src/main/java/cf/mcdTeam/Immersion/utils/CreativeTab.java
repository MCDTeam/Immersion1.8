package cf.mcdTeam.Immersion.utils;

import cf.mcdTeam.Immersion.magic.MRef;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTab extends CreativeTabs 
{
	Item tabItem;
	
	public CreativeTab(String name, Item tabItem) 
	{
		super(name);
		this.tabItem = tabItem;
	}

	@Override
	public Item getTabIconItem() 
	{
		return tabItem;
	}


}
