package niel.modTweak.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.util.IIcon;
import niel.modTweak.ModTweak;

public class BlockModFenceGate extends BlockFenceGate
{

	private int IIconIndex;
	private IIcon[] IIcons = new IIcon[4];

	public BlockModFenceGate(int id, int index, String unlocName)
	{
		super(id);
		setHardness(4.0F);
		setUnlocalizedName(unlocName);
		setCreativeTab(ModTweak.tabStoneLamp);
		this.IIconIndex = index;
	}

	@Override
	public IIcon getIIcon(int par1, int par2)
	{
		if (IIcons[0] == null)
		{
			for (int i = 1; i < 4; i++)
				IIcons[i-1] = Block.planks.getIIcon(i, i);
			IIcons[3] = Block.blockIron.getIIcon(0, 0);
		}

		return IIcons[IIconIndex];
	}
}
