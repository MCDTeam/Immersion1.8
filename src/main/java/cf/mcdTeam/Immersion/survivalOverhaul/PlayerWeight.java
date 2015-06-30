package cf.mcdTeam.Immersion.survivalOverhaul;

import cf.mcdTeam.Immersion.Immersion;
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

    //public ArrayList<ItemStack> wholeInventory = new ArrayList<ItemStack>();
    public ArrayList<ItemStack> wholeInventory = new ArrayList<ItemStack>();
    public static HashMap<ItemStack, Integer> itemBlockWeight = new HashMap();
    public int playerWeight = 0;
    public int INVENTORY_SLOTS = 35;

    public void init(EntityPlayer player){
        addPlayerInventory(player);
        addBaseItemWeights();

        addTotalWeight();
    }

    private void addPlayerInventory(EntityPlayer player){
        for(int x = 0; x < INVENTORY_SLOTS; x++){

            ItemStack itemStack = player.inventory.getStackInSlot(x);
            if(itemStack != null) {
                wholeInventory.add(itemStack);
            }
        }
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
        for(ItemStack itemStack : wholeInventory){
            if(doesItemstackHaveWeight(itemStack)) {
                int itemstackWeight = getWeightForItem(itemStack) * itemStack.stackSize;

                playerWeight = playerWeight + itemstackWeight;
            }else{
                Immersion.instance.log.error("Itemstack doesnt have assigned weight - " + itemStack.getUnlocalizedName());
            }
        }
    }

    /**
     * Helper Methods
     */
    public static HashMap<ItemStack, Integer> getHashMap(){
        return itemBlockWeight;
    }

    public static void addItemWeight(ItemStack itemStack, int weight){
        itemBlockWeight.put(itemStack, weight);
    }

    public static void addItemWeight(Block block, int weight){
        itemBlockWeight.put( new ItemStack(block), weight);
    }

    public static boolean doesItemstackHaveWeight(ItemStack itemStack){
        return getHashMap().containsValue(itemStack);
    }
}
