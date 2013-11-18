package niel.mod.block;

import net.minecraft.block.Block;
import niel.mod.item.ItemBlockModDoor;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


public class ModTweakBlock  {

    public static Block birchFence, jungleFence, spruceFence, ironFence;
    public static Block birchGate, jungleGate, spruceGate, ironGate;
    public static Block modDoor, birchDoor, jungleDoor, spruceDoor;
    public static Block blockLight;
    public static Block blockStair;

    public static void init()  {
        //Fence
        birchFence = new BlockModFence(TweakBlock.BIRCHFENCE_ID, "birch", TweakBlock.BIRCHFENCE_UNLOC_NAME);
        jungleFence = new BlockModFence(TweakBlock.JUNGLEFENCE_ID, "jungle", TweakBlock.JUNGLEFENCE_UNLOC_NAME);
        spruceFence = new BlockModFence(TweakBlock.SPRUCEFENCE_ID, "spruce", TweakBlock.SPRUCEFENCE_UNLOC_NAME);
        ironFence = new BlockModFence(TweakBlock.IRONFENCE_ID, "iron", TweakBlock.IRONFENCE_UNLOC_NAME);
        //Fence Gate
        birchGate = new BlockModFenceGate(TweakBlock.BIRCHGATE_ID, TweakBlock.GATE_TEXTURE_NAMES[0], TweakBlock.BIRCHGATE_UNLOC_NAME);
        jungleGate = new BlockModFenceGate(TweakBlock.JUNGLEGATE_ID, TweakBlock.GATE_TEXTURE_NAMES[1], TweakBlock.JUNGLEGATE_UNLOC_NAME);
        spruceGate = new BlockModFenceGate(TweakBlock.SPRUCEGATE_ID, TweakBlock.GATE_TEXTURE_NAMES[2], TweakBlock.SPRUCEGATE_UNLOC_NAME);
        ironGate = new BlockModFenceGate(TweakBlock.IRONGATE_ID, TweakBlock.GATE_TEXTURE_NAMES[3], TweakBlock.IRONGATE_UNLOC_NAME);
        
        //Door
        modDoor = new BlockModDoor(TweakBlock.DOOR_ID);
        //birchDoor = new BlockModDoor(TweakBlock.DOOR_ID);
        //jungleDoor = new BlockModDoor(TweakBlock.DOOR_ID);
        //spruceDoor = new BlockModDoor(TweakBlock.DOOR_ID);
        

        //light
        blockLight = new BlockModLight(TweakBlock.BLOCKLIGHT_ID);
        
        blockStair = new BlockModStairs(TweakBlock.STAIR_ID, Block.stone, 0);
        
        //Register Fence
        GameRegistry.registerBlock(birchFence, TweakBlock.BIRCHFENCE_KEY);
        GameRegistry.registerBlock(jungleFence, TweakBlock.JUNGLEFENCE_KEY);
        GameRegistry.registerBlock(spruceFence, TweakBlock.SPRUCEFENCE_KEY);
        GameRegistry.registerBlock(ironFence, TweakBlock.IRONFENCE_KEY);

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
        TweakBlock.fenceIDs.add(TweakBlock.BIRCHFENCE_ID);
        TweakBlock.fenceIDs.add(TweakBlock.JUNGLEFENCE_ID);
        TweakBlock.fenceIDs.add(TweakBlock.SPRUCEFENCE_ID);
        TweakBlock.fenceIDs.add(TweakBlock.IRONFENCE_ID);

        //Add Fence Gates to connections
        TweakBlock.fenceIDs.add(TweakBlock.BIRCHGATE_ID);
        TweakBlock.fenceIDs.add(TweakBlock.JUNGLEGATE_ID);
        TweakBlock.fenceIDs.add(TweakBlock.SPRUCEGATE_ID);
        TweakBlock.fenceIDs.add(TweakBlock.IRONGATE_ID);
    }

        public static void addNames() {

        LanguageRegistry.addName(birchFence, TweakBlock.BIRCHFENCE_NAME);
        LanguageRegistry.addName(jungleFence, TweakBlock.JUNGLEFENCE_NAME);
        LanguageRegistry.addName(spruceFence, TweakBlock.SPRUCEFENCE_NAME);
        LanguageRegistry.addName(ironFence, TweakBlock.IRONFENCE_NAME);
        
        LanguageRegistry.addName(birchGate, TweakBlock.BIRCHGATE_NAME);
        LanguageRegistry.addName(jungleGate, TweakBlock.JUNGLEGATE_NAME);
        LanguageRegistry.addName(spruceGate, TweakBlock.SPRUCEGATE_NAME);
        LanguageRegistry.addName(ironGate, TweakBlock.IRONGATE_NAME);
        
        LanguageRegistry.addName(modDoor, TweakBlock.DOOR_NAMES[0]);
        LanguageRegistry.addName(blockLight, TweakBlock.BLOCKLIGHT_NAME);
        
        LanguageRegistry.addName(blockStair, TweakBlock.STAIR_NAME);
        }
        
        public static void registerRecipes()
        {
        	BlockRecipes.addRecipes();
        }
}