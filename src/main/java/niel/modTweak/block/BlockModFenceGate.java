package niel.modTweak.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.util.Icon;
import niel.modTweak.ModTweak;

public class BlockModFenceGate extends BlockFenceGate
{

	private int iconIndex;
	private Icon[] icons = new Icon[4];

	public BlockModFenceGate(int id, int index, String unlocName)
	{
		super(id);
		setHardness(4.0F);
		setUnlocalizedName(unlocName);
		setCreativeTab(ModTweak.tabStoneLamp);
		this.iconIndex = index;
	}

	@Override
	public Icon getIcon(int par1, int par2)
	{
		if (icons[0] == null)
		{
			for (int i = 1; i < 4; i++)
				icons[i-1] = Block.planks.getIcon(i, i);
			icons[3] = Block.blockIron.getIcon(0, 0);
		}

		return icons[iconIndex];
	}
}
