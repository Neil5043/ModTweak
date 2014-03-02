package niel.modTweak.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import niel.modTweak.ModTweak;

public class BlockModStairs extends BlockStairs
{
	public BlockModStairs(Block block, int metadata)
	{
		super(block, metadata);
		setCreativeTab(ModTweak.tabStoneLamp);
	}
}
