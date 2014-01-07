package niel.modTweak.block;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import niel.modTweak.item.ItemModDoor;
import niel.modTweak.item.ItemBlockModFence;
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
		fence = new BlockModFence(TweakBlockInfo.FENCE_ID).setUnlocalizedName("fence");
		//Fence Gate
		birchGate = new BlockModFenceGate(TweakBlockInfo.BIRCHGATE_ID, 0, TweakBlockInfo.BIRCHGATE_UNLOC_NAME);
		jungleGate = new BlockModFenceGate(TweakBlockInfo.JUNGLEGATE_ID, 1, TweakBlockInfo.JUNGLEGATE_UNLOC_NAME);
		spruceGate = new BlockModFenceGate(TweakBlockInfo.SPRUCEGATE_ID, 2, TweakBlockInfo.SPRUCEGATE_UNLOC_NAME);
		ironGate = new BlockModFenceGate(TweakBlockInfo.IRONGATE_ID, 3, TweakBlockInfo.IRONGATE_UNLOC_NAME);

		//Door
		//birchDoor = new BlockModDoor(TweakBlock.DOOR_ID);
		//jungleDoor = new BlockModDoor(TweakBlock.DOOR_ID);
		//spruceDoor = new BlockModDoor(TweakBlock.DOOR_ID);


		//light
		blockLight = new BlockModLight(TweakBlockInfo.BLOCKLIGHT_ID);

		blockStair = new BlockModStairs(TweakBlockInfo.STAIR_ID, Block.stone, 0);
		
		doorItem = new ItemModDoor(24000).setUnlocalizedName("modTweakDoorItem");
		GameRegistry.registerItem(doorItem, "modTweakDoorItem");
		
		birchDoor = new BlockModDoor(3110, 0, "doorBirch").setUnlocalizedName("doorBirch");
		jungleDoor = new BlockModDoor(3111, 0, "doorJungle").setUnlocalizedName("doorJungle");
		spruceDoor = new BlockModDoor(3112, 0, "doorSpruce").setUnlocalizedName("doorSpruce");


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
		TweakBlockInfo.fenceIDs.add(TweakBlockInfo.FENCE_ID);

		//Add Fence Gates to connections
		TweakBlockInfo.fenceIDs.add(TweakBlockInfo.BIRCHGATE_ID);
		TweakBlockInfo.fenceIDs.add(TweakBlockInfo.JUNGLEGATE_ID);
		TweakBlockInfo.fenceIDs.add(TweakBlockInfo.SPRUCEGATE_ID);
		TweakBlockInfo.fenceIDs.add(TweakBlockInfo.IRONGATE_ID);
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