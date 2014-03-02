package niel.modTweak.block;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockRecipes
{

	public static void addRecipes()
	{
		ItemStack[] planks = new ItemStack[3];
		for (int i = 1; i <= 3; i++)
		{
			planks[i - 1] = new ItemStack(Blocks.planks, 1, i);
		}
		
		GameRegistry.addRecipe(new ItemStack(ModTweakBlock.fence, 3, 0), new Object[]{
			"BSB",
			"BSB",
			
			'B', planks[1],
			'S', Items.stick
		});
		
		GameRegistry.addRecipe(new ItemStack(ModTweakBlock.fence, 3, 1), new Object[]{
			"JSJ",
			"JSJ",
			
			'J', planks[2],
			'S', Items.stick
		});
		
		GameRegistry.addRecipe(new ItemStack(ModTweakBlock.fence, 3, 2), new Object[]{
			"sSs",
			"sSs",
			
			's', planks[0],
			'S', Items.stick
		});
		
		GameRegistry.addRecipe(new ItemStack(ModTweakBlock.fence, 3, 3), new Object[]{
			"ISI",
			"ISI",
			
			'I', Items.iron_ingot,
			'S', Items.stick
		});
		
		GameRegistry.addRecipe(new ItemStack(ModTweakBlock.birchGate), new Object[]{
			"BSB",
			"S S",
			
			'B', planks[1],
			'S', Items.stick
		});
		
		GameRegistry.addRecipe(new ItemStack(ModTweakBlock.jungleGate), new Object[]{
			"JSJ",
			"S S",
			
			'J', planks[2],
			'S', Items.stick
		});
		
		GameRegistry.addRecipe(new ItemStack(ModTweakBlock.spruceGate), new Object[]{
			"sSs",
			"S S",
			
			's', planks[0],
			'S', Items.stick
		});
		
		GameRegistry.addRecipe(new ItemStack(ModTweakBlock.ironGate), new Object[]{
			"ISI",
			"S S",
			
			'I', Items.iron_ingot,
			'S', Items.stick
		});
		
		GameRegistry.addRecipe(new ItemStack(ModTweakBlock.blockLight), new Object[]{
			"CPC",
			"PTP",
			"CPC",
			
			'C', Blocks.cobblestone,
			'P', Blocks.glass_pane,
			'T', Blocks.torch
		});
	}
}
