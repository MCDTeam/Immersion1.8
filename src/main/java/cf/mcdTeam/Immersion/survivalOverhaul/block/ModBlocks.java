package cf.mcdTeam.Immersion.survivalOverhaul.block;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {

    // Instances
    public static Block blockOilTorch = new blockOilTorch();

    public static void init(){
        GameRegistry.registerBlock(blockOilTorch, "blockOilTorch").setUnlocalizedName("blockOilTorch").setCreativeTab(CreativeTabs.tabBlock);
        for(int x = 0; x < 100; x++){
            System.out.println("BLOCKS");
        }
    }
}
