package cf.mcdTeam.Immersion.survivalOverhaul.events;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerEvent {

    @SubscribeEvent
    public void onPlayerPlace(BlockEvent.PlaceEvent event){
        if(event.placedBlock.getBlock().equals(Blocks.torch)){
            //event.world.setBlockState(event.pos, nerw());
        }
    }

    @SubscribeEvent
    public void onPlayerMine(BlockEvent.BreakEvent event){
        System.out.println("MINED BLOCK");
        EntityPlayer player = event.getPlayer();
        Block block = event.state.getBlock();

        if(isBlockTooHard(getTier(player.posY), player.getHeldItem())){
            System.out.println("TOOO HARD");
            event.setCanceled(true);
        }

        /*if(getTier(event.pos.getY()) == 1){
            block.setHardness(2F);
        }
        if(getTier(event.pos.getY()) == 2){
            block.setHardness(5F);
        }
        if(getTier(event.pos.getY()) == 3){
            block.setHardness(10F);
        }
        if(getTier(event.pos.getY()) == 0){
            //Immersion.log.error(block.getUnlocalizedName() + " doesnt have a block tier. Coords: [" + event.pos.getX() + ", " + event.pos.getY() + ", ", event.pos.getZ() + "]");
            block.setBlockUnbreakable();
        }*/
    }

    private int getTier(double y){
        if(y > 50) return 1;
        else if((y <= 50) && (y > 25)) return 2;
        else if((y <= 25) && (y >= 0)) return 3;
        else return 0;
    }

    /**
     * Checks is the pickaxe is able to mine at the depth
     * @param hardness
     * @param pickaxe
     * @return true if pickaxe can mine
     */
    public boolean isBlockTooHard(int hardness, ItemStack pickaxe){
        if(pickaxe.getItem() instanceof ItemPickaxe){
            System.out.println("PICK");
            String unlocName = pickaxe.getDisplayName();

            if(unlocName.contains("wood") || (unlocName.contains("stone"))){
                if(hardness != 1) return false;
                else return false;

            }else if(unlocName.contains("iron")){
                if(hardness >= 2) return true;
                else return false;

            }else if(unlocName.contains("diamond")){
                // Will always be true;
                return true;
            }
        }
        return false;
    }
}
