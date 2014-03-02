package niel.modTweak.block;

import net.minecraft.block.BlockFenceGate;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import niel.modTweak.ModTweak;

public class BlockModFenceGate extends BlockFenceGate
{

	private int IIconIndex;
	private IIcon[] IIcons = new IIcon[4];

	public BlockModFenceGate(int index, String unlocName)
	{
		super();
		setHardness(4.0F);
		setCreativeTab(ModTweak.tabStoneLamp);
		this.IIconIndex = index;
	}

	@Override
	public IIcon getIcon(int par1, int par2)
	{
		if (IIcons[0] == null)
		{
			for (int i = 1; i < 4; i++)
				IIcons[i-1] = Blocks.planks.getIcon(i, i);
			IIcons[3] = Blocks.iron_block.getIcon(0, 0);
		}

		return IIcons[IIconIndex];
	}
}
