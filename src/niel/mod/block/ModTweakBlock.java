package niel.mod.block;

import net.minecraft.block.Block;
import niel.mod.item.ItemBlockModDoor;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


public class ModTweakBlock  {

    public static Block fence;
    public static Block birchGate, jungleGate, spruceGate, ironGate;
    public static Block modDoor, birchDoor, jungleDoor, spruceDoor;
    public static Block blockLight;
    public static Block blockStair;

    public static void init()  {
        //Fence
        fence = new BlockModFence(TweakBlock.FENCE_ID);
        
        //Fence Gate
        birchGate = new BlockModFenceGate(TweakBlock.BIRCHGATE_ID, TweakBlock.GATE_TEXTURE_NAMES[0], TweakBlock.BIRCHGATE_UNLOC_NAME);
        jungleGate = new BlockModFenceGate(TweakBlock.JUNGLEGATE_ID, TweakBlock.GATE_TEXTURE_NAMES[1], TweakBlock.JUNGLEGATE_UNLOC_NAME);
        spruceGate = new BlockModFenceGate(TweakBlock.SPRUCEGATE_ID, TweakBlock.GATE_TEXTURE_NAMES[2], TweakBlock.SPRUCEGATE_UNLOC_NAME);
        ironGate = new BlockModFenceGate(TweakBlock.IRONGATE_ID, TweakBlock.GATE_TEXTURE_NAMES[3], TweakBlock.IRONGATE_UNLOC_NAME);
        
        //Door
        //birchDoor = new BlockModDoor(TweakBlock.DOOR_ID);
        //jungleDoor = new BlockModDoor(TweakBlock.DOOR_ID);
        //spruceDoor = new BlockModDoor(TweakBlock.DOOR_ID);
        

        //light
        blockLight = new BlockModLight(TweakBlock.BLOCKLIGHT_ID);
        
        blockStair = new BlockModStairs(TweakBlock.STAIR_ID, Block.stone, 0);
        modDoor = new BlockModDoor(TweakBlock.DOOR_ID);

        //Register Fence
        GameRegistry.registerBlock(fence, TweakBlock.FENCE_KEY);

        //Register Fence Gate
        GameRegistry.registerBlock(birchGate, TweakBlock.BIRCHGATE_UNLOC_NAME);
        GameRegistry.registerBlock(jungleGate, TweakBlock.JUNGLEGATE_UNLOC_NAME);
        GameRegistry.registerBlock(spruceGate, TweakBlock.SPRUCEGATE_UNLOC_NAME);
        GameRegistry.registerBlock(ironGate, TweakBlock.IRONGATE_UNLOC_NAME);
        
        GameRegistry.registerBlock(modDoor, ItemBlockModDoor.class, TweakBlock.DOOR_KEY);


        //Register Derp Doors
        //GameRegistry.registerBlock(birchDoor, TweakBlock.BIRCHDOOR_KEY);
        
        //Register Light
        GameRegistry.registerBlock(blockLight, TweakBlock.BLOCKLIGHT_KEY);
        
        GameRegistry.registerBlock(blockStair, TweakBlock.STAIR_KEY);
        
         //Add Fences to connections
        TweakBlock.fenceIDs.add(TweakBlock.FENCE_ID);

        //Add Fence Gates to connections
        TweakBlock.fenceIDs.add(TweakBlock.BIRCHGATE_ID);
        TweakBlock.fenceIDs.add(TweakBlock.JUNGLEGATE_ID);
        TweakBlock.fenceIDs.add(TweakBlock.SPRUCEGATE_ID);
        TweakBlock.fenceIDs.add(TweakBlock.IRONGATE_ID);
    }

        public static void addNames() {

        	LanguageRegistry.instance().addStringLocalization("tterrag.tile.birchFence.name", "Birch Fence");   
            LanguageRegistry.instance().addStringLocalization("tterrag.tile.jungleFence.name", "Jungle Fence");   
            LanguageRegistry.instance().addStringLocalization("tterrag.tile.spruceFence.name", "Spruce Fence");
            LanguageRegistry.instance().addStringLocalization("tterrag.tile.ironFence.name", "Iron Fence");
        
            LanguageRegistry.addName(birchGate, TweakBlock.BIRCHGATE_NAME);
            LanguageRegistry.addName(jungleGate, TweakBlock.JUNGLEGATE_NAME);
            LanguageRegistry.addName(spruceGate, TweakBlock.SPRUCEGATE_NAME);
            LanguageRegistry.addName(ironGate, TweakBlock.IRONGATE_NAME);
        
            LanguageRegistry.addName(blockLight, TweakBlock.BLOCKLIGHT_NAME);
        
            LanguageRegistry.addName(blockStair, TweakBlock.STAIR_NAME);
        
            LanguageRegistry.instance().addStringLocalization("tterrag.tile.birchDoor.name", "Birch Door");   
            LanguageRegistry.instance().addStringLocalization("tterrag.tile.jungleDoor.name", "Jungle Door");   
        	LanguageRegistry.instance().addStringLocalization("tterrag.tile.spruceDoor.name", "Spruce Door");   

        
        }
        
        public static void registerRecipes()
        {
        	BlockRecipes.addRecipes();
        }
}