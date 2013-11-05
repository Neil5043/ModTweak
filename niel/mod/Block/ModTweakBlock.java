package niel.mod.Block;

import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


public class ModTweakBlock  {

    public static Block birchFence, jungleFence, spruceFence;
    public static Block birchGate, jungleGate, spruceGate;
    public static Block birchDoor;

    public static void init()  {
        birchFence = new BlockModFence(TweakBlock.BIRCHFENCE_ID, "planks_birch", TweakBlock.BIRCHFENCE_UNLOC_NAME);
        jungleFence = new BlockModFence(TweakBlock.JUNGLEFENCE_ID, "jungle", TweakBlock.JUNGLEFENCE_UNLOC_NAME);
        spruceFence = new BlockModFence(TweakBlock.SPRUCEFENCE_ID, "spruce", TweakBlock.SPRUCEFENCE_UNLOC_NAME);
        
        birchGate = new BlockModFenceGate(TweakBlock.BIRCHGATE_ID, "birch", TweakBlock.BIRCHGATE_UNLOC_NAME);
        jungleGate = new BlockModFenceGate(TweakBlock.JUNGLEGATE_ID, "jungle", TweakBlock.JUNGLEGATE_UNLOC_NAME);
        spruceGate = new BlockModFenceGate(TweakBlock.SPRUCEGATE_ID, "spruce", TweakBlock.SPRUCEGATE_UNLOC_NAME);
        
        birchDoor = new BlockModDoor(TweakBlock.BIRCHDOOR_ID, TweakBlock.BIRCHDOOR_UNLOC_NAME);
        
        
        GameRegistry.registerBlock(birchFence, TweakBlock.BIRCHFENCE_KEY);
        GameRegistry.registerBlock(jungleFence, TweakBlock.JUNGLEFENCE_KEY);
        GameRegistry.registerBlock(spruceFence, TweakBlock.SPRUCEFENCE_KEY);
        
        GameRegistry.registerBlock(birchGate, TweakBlock.BIRCHGATE_KEY);
        GameRegistry.registerBlock(jungleGate, TweakBlock.JUNGLEGATE_KEY);
        GameRegistry.registerBlock(spruceGate, TweakBlock.SPRUCEGATE_KEY);
        
        GameRegistry.registerBlock(birchDoor, TweakBlock.BIRCHDOOR_KEY);
        
        
        TweakBlock.fenceIDs.add(TweakBlock.BIRCHFENCE_ID);
        TweakBlock.fenceIDs.add(TweakBlock.JUNGLEFENCE_ID);
        TweakBlock.fenceIDs.add(TweakBlock.SPRUCEFENCE_ID);
        
        TweakBlock.fenceIDs.add(TweakBlock.BIRCHGATE_ID);
        TweakBlock.fenceIDs.add(TweakBlock.JUNGLEGATE_ID);
        TweakBlock.fenceIDs.add(TweakBlock.SPRUCEGATE_ID);
    }

        public static void addNames() {

        LanguageRegistry.addName(birchFence, TweakBlock.BIRCHFENCE_NAME);
        LanguageRegistry.addName(jungleFence, TweakBlock.JUNGLEFENCE_NAME);
        LanguageRegistry.addName(spruceFence, TweakBlock.SPRUCEFENCE_NAME);
        
        LanguageRegistry.addName(birchGate, TweakBlock.BIRCHGATE_NAME);
        LanguageRegistry.addName(jungleGate, TweakBlock.JUNGLEGATE_NAME);
        LanguageRegistry.addName(spruceGate, TweakBlock.SPRUCEGATE_NAME);
        
        LanguageRegistry.addName(birchDoor, TweakBlock.BIRCHDOOR_NAME);
        }
}