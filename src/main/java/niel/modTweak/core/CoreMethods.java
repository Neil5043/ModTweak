package niel.modTweak.core;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import niel.modTweak.block.TweakBlockInfo;
import cpw.mods.fml.common.Loader;
import crazypants.enderio.EnderIO;

public class CoreMethods {
	
	public static boolean canConnectFenceTo(net.minecraft.world.IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
		return false;
		// TODO 1.7
		/*
        int l = par1IBlockAccess.getBlock(par2, par3, par4);
        

        if (l != Block.fence.blockID && l != Block.fenceGate.blockID)
        {
            Block block = Block.blocksList[l];
            
            for (Integer i : TweakBlockInfo.fences)
            {
            	if (i.equals(l))
            		return true;
            }
            
            if (Loader.isModLoaded("EnderIO"))
            {
            	if (l == EnderIO.blockCustomFence.blockID || l == EnderIO.blockCustomFenceGate.blockID)
            		return true;
            }
            
            return block != null && block.blockMaterial.isOpaque() && block.renderAsNormalBlock() ? block.blockMaterial != Material.pumpkin : false;
        }
        else
        {
            return true;
        }
        */
    }
	
    public static boolean canConnectWallTo(net.minecraft.world.IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
		return false;
    	/*
        int l = par1IBlockAccess.getBlock(par2, par3, par4);

        if (l != Block.cobblestoneWall.blockID && l != Block.fenceGate.blockID)
        {
            Block block = Block.blocksList[l];
            
            for (Integer i : TweakBlockInfo.fences)
            {
            	if (i.equals(l))
            		return true;
            }
            
            if (Loader.isModLoaded("EnderIO"))
            {
            	if (l == EnderIO.blockCustomFence.blockID || l == EnderIO.blockCustomFenceGate.blockID)
            		return true;
            }
            
            return block != null && block.blockMaterial.isOpaque() && block.renderAsNormalBlock() ? block.blockMaterial != Material.pumpkin : false;
        }
        else
        {
            return true;
        }
        */
    }

}
