package niel.mod.Block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModFence extends BlockFence {
	public BlockModFence(int id, String textureName, String unlocalizedName) {
		super(id, "modtweak" + ":" + textureName, Material.wood);
		setHardness(4.0F);
		setCreativeTab(CreativeTabs.tabDecorations);
		setUnlocalizedName(unlocalizedName);
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
            Block block = Block.blocksList[l];
            return block != null && block.blockMaterial.isOpaque() && block.renderAsNormalBlock() ? block.blockMaterial != Material.pumpkin : false;
        }
        else
        {
            return true;
        }
	}
}
