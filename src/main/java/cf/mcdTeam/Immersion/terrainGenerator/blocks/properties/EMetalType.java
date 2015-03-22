package cf.mcdTeam.Immersion.terrainGenerator.blocks.properties;

import net.minecraft.util.IStringSerializable;

public enum EMetalType implements IStringSerializable
{
	IRON ("iron", 0),
	ADAMANTIUM ("adamantium", 1),
	HORRIUM ("horrium", 2),
	UTOPIUM ("utopium", 3),
	
	SILVER ("silver", 4),
	GOLD ("gold", 5),
	WITHIUM ("withium", 6),
	PLATINUM ("platinum", 7),
	
	COPPER ("copper", 8),
	ENEGIUM ("enegium", 9),
	SUFFERDITE ("sufferdite", 10),
	POWERNIUM ("powernium", 11),
	
	MYTHRIL ("mythril", 12),
	MYSTERIUM ("mysterium", 13),
	EVILIUM ("evilium", 14),
	FANTASMIUM ("fantasmium", 15);
	
	public final String name;
	public final int metadata;
	private static final EMetalType[] METADATA_LOOKUP = new EMetalType[values().length];
	private EMetalType(String name, int metadata)
	{
		this.name = name;
		this.metadata = metadata;
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