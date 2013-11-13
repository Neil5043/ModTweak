package niel.mod.Block;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockRecipes
{

	public static void addRecipes()
	{
		ItemStack[] planks = new ItemStack[3];
		for (int i = 1; i <= 3; i++)
		{
			planks[i - 1] = new ItemStack(Block.planks, 1, i);
		}
		
		GameRegistry.addRecipe(new ItemStack(ModTweakBlock.birchFence, 3), new Object[]{
			"BSB",
			"BSB",
			
			'B', planks[1],
			'S', Item.stick
		});
		
		GameRegistry.addRecipe(new ItemStack(ModTweakBlock.jungleFence, 3), new Object[]{
			"JSJ",
			"JSJ",
			
			'J', planks[2],
			'S', Item.stick
		});
		
		GameRegistry.addRecipe(new ItemStack(ModTweakBlock.spruceFence, 3), new Object[]{
			"sSs",
			"sSs",
			
			's', planks[0],
			'S', Item.stick
		});
		
		GameRegistry.addRecipe(new ItemStack(ModTweakBlock.ironFence, 3), new Object[]{
			"ISI",
			"ISI",
			
			'I', Item.ingotIron,
			'S', Item.stick
		});
		
		GameRegistry.addRecipe(new ItemStack(ModTweakBlock.birchGate), new Object[]{
			"BSB",
			"S S",
			
			'B', planks[1],
			'S', Item.stick
		});
		
		GameRegistry.addRecipe(new ItemStack(ModTweakBlock.jungleGate), new Object[]{
			"JSJ",
			"S S",
			
			'J', planks[2],
			'S', Item.stick
		});
		
		GameRegistry.addRecipe(new ItemStack(ModTweakBlock.spruceGate), new Object[]{
			"sSs",
			"S S",
			
			's', planks[0],
			'S', Item.stick
		});
		
		GameRegistry.addRecipe(new ItemStack(ModTweakBlock.ironGate), new Object[]{
			"ISI",
			"S S",
			
			'I', Item.ingotIron,
			'S', Item.stick
		});
		
		GameRegistry.addRecipe(new ItemStack(ModTweakBlock.blockLight), new Object[]{
			"CPC",
			"PTP",
			"CPC",
			
			'C', Block.cobblestone,
			'P', Block.thinGlass,
			'T', Block.torchWood
		});
	}
}
