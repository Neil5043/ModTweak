package niel.modTweak.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import niel.modTweak.ModTweak;
import niel.modTweak.block.ModTweakBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBlockModFence extends ItemBlock
{
	public static final String[] woodType = new String[] {"spruce", "birch", "jungle", "iron"};
	public ItemBlockModFence(int par1)
	{
		super(par1);
		//setCreativeTab(ModTweak.tabStoneLamp);
		setMaxDamage(0);
		setHasSubtypes(true);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int par1)
	{	
		return ModTweakBlock.fence.getIcon(2, ModTweakBlock.fence.damageDropped(par1));
	}

	@Override
	public int getMetadata (int meta) {
		return meta;
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
		return super.getUnlocalizedName()+ "." + woodType[itemstack.getItemDamage()];
	}

}
