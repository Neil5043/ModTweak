package niel.mod.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import niel.ModTweak;

public class BlockModFence extends BlockFence
{
	public static final String[] woodType = new String[] {"oak", "spruce", "birch", "jungle"};
	@SideOnly(Side.CLIENT)
	public BlockModFence(int id) {
		super(id, "planks", Material.wood);
		setHardness(4.0F);
		setCreativeTab(ModTweak.tabStoneLamp);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	{
		return true;
	}

	@Override
	public boolean canConnectFenceTo(IBlockAccess blockAccess, int par2,
			int par3, int par4) {
		int l = blockAccess.getBlockId(par2, par3, par4);

		if (l != this.blockID && l != Block.fenceGate.blockID && l != Block.fence.blockID)
		{
			for (Integer i : TweakBlock.fenceIDs)
			{
				if (((Integer)l).compareTo(i) == 0)
					return true;
			}

			if (Loader.isModLoaded("EnderIO"))
			{
				if (l == EnderIO.blockCustomFence.blockID || l == EnderIO.blockCustomFenceGate.blockID)
					return true;
			}

			Block block = Block.blocksList[l];
			return block != null && block.blockMaterial.isOpaque() && block.renderAsNormalBlock() ? block.blockMaterial != Material.pumpkin : false;
		}
		else
		{
			return true;
		}
	}
	
	Icon[] icons = new Icon[4];

	@Override
	public Icon getIcon(int par1, int par2)
	{
		if (icons[0] == null)
		{
			for (int i = 1; i < 4; i++)
				icons[i-1] = Block.planks.getIcon(i, i);
			icons[3] = Block.blockIron.getIcon(0, 0);
		}

		return icons[par2];
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List list)
	{
		for (int i = 0; i < 4; i++)
			list.add(new ItemStack(this.blockID, 1, i));
	}
}
