package niel.mod.item;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemModFenceGate extends ItemBlock
{
	
	public ItemModFenceGate(int par1)
    {
          super(par1);
          setHasSubtypes(true);
          setUnlocalizedName(getUnlocalizedName(new ItemStack(this.itemID, 1, 0)));
    }
	
	public String getUnlocalizedName(ItemStack itemstack)
	{
	       String name = "";
	       switch(itemstack.getItemDamage())
	       {
	             case 0:
	             {
	                    name = "gateBirch";
	                    break;
	             }
	             case 1:
	             {
	                    name = "gateJungle";
	                    break;
	             }
	             case 2:
	             {
	            	 name = "gateSpruce";
	            	 break;
	             }
	             case 3:
	             {
	            	 name = "gateIron";
	            	 break;
	             }
	             default: name = "broken";
	       }
	       return getUnlocalizedName() + "." + name;
	}
	
	public int getMetadata(int damage)
	{
		return damage;
	}
}
