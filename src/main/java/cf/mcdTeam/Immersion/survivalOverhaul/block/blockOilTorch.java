package cf.mcdTeam.Immersion.survivalOverhaul.block;

import net.minecraft.block.BlockTorch;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class blockOilTorch extends BlockTorch {

    @Override
    public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        super.randomDisplayTick(worldIn, pos, state, rand);

        Random random = new Random(10);

        if(random.nextInt() ==  1){
            this.setLightLevel(0F);
            //TODO change texture
        }
    }
}
