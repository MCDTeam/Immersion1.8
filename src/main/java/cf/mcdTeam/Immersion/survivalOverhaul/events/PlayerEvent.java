package cf.mcdTeam.Immersion.survivalOverhaul.events;

import cf.mcdTeam.Immersion.Immersion;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerEvent {

    @SubscribeEvent
    public void onPlayerMine(BlockEvent.BreakEvent event){

        EntityPlayer player = event.getPlayer();
        Block block = event.state.getBlock();

        if(getTier(event.pos.getY()) == 1){
            block.setHardness(2F);
        }
        if(getTier(event.pos.getY()) == 2){
            block.setHardness(5F);
        }
        if(getTier(event.pos.getY()) == 3){
            block.setHardness(10F);
        }
        if(getTier(event.pos.getY()) == 0){
            Immersion.log.error(block.getUnlocalizedName() + " doesnt have a block tier. Coords: [" + event.pos.getX() + ", " + event.pos.getY() + ", ", event.pos.getZ() + "]");
            block.setBlockUnbreakable();
        }
    }

    private int getTier(int y){
        if(y > 50) return 1;
        else if((y <= 50) && (y > 25)) return 2;
        else if((y <= 25) && (y >= 0)) return 3;
        else return 0;
    }
}
