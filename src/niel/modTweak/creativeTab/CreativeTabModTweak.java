package niel.modTweak.creativeTab;

import net.minecraft.creativetab.CreativeTabs;
import niel.modTweak.block.ModTweakBlock;

public class CreativeTabModTweak extends CreativeTabs {
	
	public CreativeTabModTweak(int id)
	{
		super(id, "modTweak");
	}
	
	@Override
	public int getTabIconItemIndex() {
		return ModTweakBlock.fence.blockID;
	}
	
	@Override
	public String getTabLabel() {
		return "modTweak";
	}
}
