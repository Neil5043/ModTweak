package niel.modTweak.creativeTab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import niel.modTweak.block.ModTweakBlock;

public class CreativeTabModTweak extends CreativeTabs {
	
	public CreativeTabModTweak(int id)
	{
		super(id, "modTweak");
	}
	
	@Override
	public Item getTabIconItem() {
		return ModTweakBlock.fence.getItem(null, 0, 0, 0);
	}
	
	@Override
	public String getTabLabel() {
		return "modTweak";
	}
}
