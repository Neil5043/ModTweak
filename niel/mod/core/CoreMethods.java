package niel.mod.core;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import niel.mod.Block.TweakBlock;

public class CoreMethods {
	
	public static boolean canConnectFenceTo(net.minecraft.world.IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        int l = par1IBlockAccess.getBlockId(par2, par3, par4);
        

        if (l != Block.fence.blockID && l != Block.fenceGate.blockID)
        {
            Block block = Block.blocksList[l];
            
            if (l >= 3002 && l <= 3007)
            	return true;
            
            return block != null && block.blockMaterial.isOpaque() && block.renderAsNormalBlock() ? block.blockMaterial != Material.pumpkin : false;
        }
        else
        {
            return true;
        }
    }

}
