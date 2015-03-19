package cf.mcdTeam.Immersion.terrainGenerator.blocks.properties;

import net.minecraft.util.IStringSerializable;

public enum EMetalType implements IStringSerializable
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
	private static final EMetalType[] METADATA_LOOKUP = new EMetalType[values().length];
	private EMetalType(String name, int metadata, int breakvalue)
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

    public static EMetalType byMetadata(int metadata)
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
        EMetalType[] values = values();
        int l = values.length;

        for (int t = 0; t < l; ++t)
        {
            EMetalType var3 = values[t];
            METADATA_LOOKUP[var3.getMetadata()] = var3;
        }
    }
}