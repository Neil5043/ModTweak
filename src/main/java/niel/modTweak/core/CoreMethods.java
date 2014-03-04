package niel.modTweak.core;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import niel.modTweak.block.TweakBlockInfo;
import cpw.mods.fml.common.Loader;
import crazypants.enderio.EnderIO;

public class CoreMethods
{

	public static boolean canConnectFenceTo(net.minecraft.world.IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
	{
		Block block = par1IBlockAccess.getBlock(par2, par3, par4);

		if (block != Blocks.fence && block != Blocks.fence_gate)
		{
			for (Block b : TweakBlockInfo.fences)
			{
				if (b == block)
					return true;
			}

			if (Loader.isModLoaded("EnderIO"))
			{
				if (block == EnderIO.blockCustomFence || block == EnderIO.blockCustomFenceGate)
					return true;
			}

			return block != null && block.getMaterial().isOpaque() && block.renderAsNormalBlock() ? block.getMaterial() != Material.gourd : false;
		}
		else
		{
			return true;
		}
	}

	public static boolean canConnectWallTo(net.minecraft.world.IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
	{
		Block block = par1IBlockAccess.getBlock(par2, par3, par4);

		if (block != Blocks.cobblestone_wall && block != Blocks.fence_gate)
		{
			for (Block b : TweakBlockInfo.fences)
			{
				if (b == block)
					return true;
			}

			if (Loader.isModLoaded("EnderIO"))
			{
				if (block == EnderIO.blockCustomFence || block == EnderIO.blockCustomFenceGate)
					return true;
			}

			return block != null && block.getMaterial().isOpaque() && block.renderAsNormalBlock() ? block.getMaterial() != Material.gourd : false;
		}
		else
		{
			return true;
		}
	}
}
