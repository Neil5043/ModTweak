package niel.mod.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import niel.ModTweak;
import niel.mod.block.BlockModFence;

public class ItemBlockModFence extends ItemBlock
{
	public static final String[] woodType = new String[] {"oak", "spruce", "birch", "jungle"};
	public ItemBlockModFence(int par1)
	{
		super(par1);
		setCreativeTab(ModTweak.tabStoneLamp);
		setHasSubtypes(true);
		setUnlocalizedName("fence");
		setMaxDamage(0);
	}

	@Override
	public int getMetadata (int damageValue) {
		return damageValue;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List list)
	{
		for (int i = 0; i < woodType.length; i++)
			list.add(new ItemStack(this.itemID, 1, i));
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		return "tile.fence." + woodType[itemstack.getItemDamage()];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int meta) {
		return BlockModFence.icons[meta];
	}

}
