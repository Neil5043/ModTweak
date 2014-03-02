package niel.modTweak.block;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import niel.modTweak.item.ItemBlockModFence;
import niel.modTweak.item.ItemModDoor;
import cpw.mods.fml.common.registry.GameRegistry;


public class ModTweakBlock  {

	public static Block fence;
	public static Block birchGate, jungleGate, spruceGate, ironGate;
	public static Block modDoor, birchDoor, jungleDoor, spruceDoor;
	public static Block blockLight;
	public static Block blockStair;
	public static Item doorItem;

	public static void init()  {
		//Fence
		fence = new BlockModFence().setBlockName("fence");
		//Fence Gate
		birchGate = new BlockModFenceGate(0, TweakBlockInfo.BIRCHGATE_UNLOC_NAME);
		jungleGate = new BlockModFenceGate(1, TweakBlockInfo.JUNGLEGATE_UNLOC_NAME);
		spruceGate = new BlockModFenceGate(2, TweakBlockInfo.SPRUCEGATE_UNLOC_NAME);
		ironGate = new BlockModFenceGate(3, TweakBlockInfo.IRONGATE_UNLOC_NAME);

		//Door
		//birchDoor = new BlockModDoor(TweakBlock.DOOR_ID);
		//jungleDoor = new BlockModDoor(TweakBlock.DOOR_ID);
		//spruceDoor = new BlockModDoor(TweakBlock.DOOR_ID);


		//light
		blockLight = new BlockModLight();

		blockStair = new BlockModStairs(Blocks.stone, 0);
		
		doorItem = new ItemModDoor().setUnlocalizedName("modTweakDoorItem");
		GameRegistry.registerItem(doorItem, "modTweakDoorItem");
		
		birchDoor = new BlockModDoor(0, "doorBirch").setBlockName("doorBirch");
		jungleDoor = new BlockModDoor(1, "doorJungle").setBlockName("doorJungle");
		spruceDoor = new BlockModDoor(2, "doorSpruce").setBlockName("doorSpruce");


		//Register Fence
		//GameRegistry.registerBlock(fence, TweakBlock.FENCE_KEY);

		//Register Fence Gate
		GameRegistry.registerBlock(birchGate, TweakBlockInfo.BIRCHGATE_UNLOC_NAME);
		GameRegistry.registerBlock(jungleGate, TweakBlockInfo.JUNGLEGATE_UNLOC_NAME);
		GameRegistry.registerBlock(spruceGate, TweakBlockInfo.SPRUCEGATE_UNLOC_NAME);
		GameRegistry.registerBlock(ironGate, TweakBlockInfo.IRONGATE_UNLOC_NAME);

		GameRegistry.registerBlock(birchDoor, "doorBirch");
		GameRegistry.registerBlock(jungleDoor, "doorJungle");
		GameRegistry.registerBlock(spruceDoor, "doorSpruce");
		GameRegistry.registerBlock(fence, ItemBlockModFence.class, TweakBlockInfo.FENCE_KEY);


		//Register Derp Doors
		//GameRegistry.registerBlock(birchDoor, TweakBlock.BIRCHDOOR_KEY);

		//Register Light
		GameRegistry.registerBlock(blockLight, TweakBlockInfo.BLOCKLIGHT_KEY);

		GameRegistry.registerBlock(blockStair, TweakBlockInfo.STAIR_KEY);

		//Add Fences to connections
		TweakBlockInfo.fences.add(ModTweakBlock.fence);

		//Add Fence Gates to connections
		TweakBlockInfo.fences.add(ModTweakBlock.birchGate);
		TweakBlockInfo.fences.add(ModTweakBlock.jungleGate);
		TweakBlockInfo.fences.add(ModTweakBlock.spruceGate);
		TweakBlockInfo.fences.add(ModTweakBlock.ironGate);
	}

	public static void addNames() {

		//LanguageRegistry.addName(birchGate, TweakBlock.BIRCHGATE_NAME);
		//LanguageRegistry.addName(jungleGate, TweakBlock.JUNGLEGATE_NAME);
		//LanguageRegistry.addName(spruceGate, TweakBlock.SPRUCEGATE_NAME);
		//LanguageRegistry.addName(ironGate, TweakBlock.IRONGATE_NAME);

		//LanguageRegistry.addName(blockLight, TweakBlock.BLOCKLIGHT_NAME);

		//LanguageRegistry.addName(blockStair, TweakBlock.STAIR_NAME);

		//LanguageRegistry.instance().addStringLocalization("tterrag.tile.birchDoor.name", "Birch Door");   
		//LanguageRegistry.instance().addStringLocalization("tterrag.tile.jungleDoor.name", "Jungle Door");   
		//LanguageRegistry.instance().addStringLocalization("tterrag.tile.spruceDoor.name", "Spruce Door");   


	}

	public static void registerRecipes()
	{
		BlockRecipes.addRecipes();
	}
}