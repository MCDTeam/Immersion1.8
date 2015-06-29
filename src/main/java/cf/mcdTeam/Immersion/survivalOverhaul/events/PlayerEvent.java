package cf.mcdTeam.Immersion.survivalOverhaul.events;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerEvent {

    @SubscribeEvent
    public void onPlayerPlace(BlockEvent.PlaceEvent event){
        if(event.placedBlock.getBlock().equals(Blocks.torch)){
            //TODO
        }
    }

    @SubscribeEvent
    public void onPlayerMine(BlockEvent.BreakEvent event){

        miningOverhaul(event);
    }

    public void miningOverhaul(BlockEvent.BreakEvent event){

        EntityPlayer player = event.getPlayer();
        Block block = event.state.getBlock();

        if(!player.capabilities.isCreativeMode) {
            if(player.getHeldItem() != null) {
                if (isItemPickaxe(player.getHeldItem())) {
                    if (isPickAbleToMine(getTier(event.pos.getY()), player.getHeldItem())) {
                    } else {
                        // Send the player a brief message - TODO
                        event.setCanceled(true);
                    }
                }
            }
        }
    }

    private int getTier(double y){
        if(y > 50) return 1;
        else if((y <= 50) && (y > 25)) return 2;
        else if((y <= 25) && (y >= 0)) return 3;
        else return 0;
    }

    private int getTierForPick(ItemStack itemStack){
        if(isItemPickaxe(itemStack)){
            if(itemStack.getItem().equals(Items.wooden_pickaxe)) return 1;
            else if(itemStack.getItem().equals(Items.stone_pickaxe)) return 1;
            else if(itemStack.getItem().equals(Items.golden_pickaxe)) return 1;
            else if(itemStack.getItem().equals(Items.iron_pickaxe)) return 2;
            else if(itemStack.getItem().equals(Items.diamond_pickaxe)) return 3;
        }else {
            return 0;
        }
        return 0;
    }

    private boolean isItemPickaxe(ItemStack itemStack){
        if(itemStack.getItem() instanceof ItemPickaxe){
            return true;
        }else if(itemStack.getItem().getUnlocalizedName().contains("pickaxe")){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Checks is the pickaxe is able to mine at the depth
     * @param blockHardness
     * @param itemPick
     * @return true if pickaxe can mine
     */
    public boolean isPickAbleToMine(int blockHardness, ItemStack itemPick){
        if(isItemPickaxe(itemPick)) {
            int pickHardness = getTierForPick(itemPick);

            if(pickHardness >= blockHardness) return true;
            else return false;
        }
        else{
            return false;
        }
    }
}
