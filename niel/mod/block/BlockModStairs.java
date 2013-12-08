package niel.mod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import niel.ModTweak;

public class BlockModStairs extends BlockStairs
{
	public BlockModStairs(int id, Block block, int metadata)
	{
		super(id, block, metadata);
		setCreativeTab(ModTweak.tabStoneLamp);
	}
}
