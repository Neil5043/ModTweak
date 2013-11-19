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

	public ItemBlockModFence(int par1)
	{
		super(par1);
		setCreativeTab(ModTweak.tabStoneLamp);
		setHasSubtypes(true);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List list)
	{
		for (int i = 0; i < 4; i++)
			list.add(new ItemStack(this.itemID, 1, i));
	}
	
	@Override
    public String getUnlocalizedName(ItemStack par1ItemStack)
    {
    	switch(par1ItemStack.getItemDamage())
    	{
    	case 0: return "tterrag.tile.birchFence";
    	case 1: return "tterrag.tile.jungleFence";
    	case 2: return "tterrag.tile.spruceFence";
    	case 3: return "tterrag.tile.ironFence";
    	default: return "tterrag.tile.invalidDoor";
    	}
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int meta) {
		return BlockModFence.icons[meta];
	}

}
