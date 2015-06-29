package cf.mcdTeam.Immersion.survivalOverhaul;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * As a player gains more items in their whole inventory their weight level increases.  At certain treshholds, they start to become slower while moving.
 */
public class PlayerWeight {

    public ArrayList<ItemStack> wholeInventory = new ArrayList<ItemStack>();
    public static HashMap<ItemStack, Integer> itemBlockWeight = new HashMap();
    public int playerWeight = 0;

    public void init(EntityPlayer player){
        addBaseItemWeights();
        addPlayerInventory(player);

        addTotalWeight();
    }

    /**
     * Helper Methods
     */
    private void addPlayerInventory(EntityPlayer player){
        for(int x = 0; x < player.inventory.getSizeInventory(); x++){
            ItemStack itemStack = player.getHeldItem();

            if(itemStack != null) {
                wholeInventory.add(itemStack);
            }
        }
    }

    public static HashMap<ItemStack, Integer> getHashMap(){
        return itemBlockWeight;
    }

    public static void addItemWeight(ItemStack itemStack, int weight){
        itemBlockWeight.put(itemStack, weight);
    }

    public static void addItemWeight(Block block, int weight){
        itemBlockWeight.put( new ItemStack(block), weight);
    }

    public static void addBaseItemWeights(){
        //Blocks
        addItemWeight(Blocks.cobblestone, 10);
        //todo
    }

    public int getWeightForItem(Object object){
        if(object instanceof ItemStack){
            return itemBlockWeight.get(object);
        }else if(object instanceof Block){
            return itemBlockWeight.get(new ItemStack((Block)object));
        }else{
            System.out.println("Object isnt Itemstack or Block!");
            return 0;
        }
    }

    public void addTotalWeight(){
        for(int x = 0; x < wholeInventory.size(); x++){
            ItemStack itemStack = wholeInventory.get(x);
            int itemstackWeight = getWeightForItem(itemStack) * itemStack.stackSize;

            playerWeight = playerWeight + itemstackWeight;
        }
    }
}