package niel.mod.Block;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;


public class ModTweakBlock  {

    public static  Block birchFence;
    public static  Block jungleFence;
    public static  Block birchGate;
    public static Block jungleGate;

    public static void init()  {
        birchFence = new niel.mod.Block.BlockModFence(TweakBlock.BIRCHFENCE_ID, "birch");
        jungleFence = new BlockModFence(TweakBlock.JUNGLEFENCE_ID, "planks_jungle");
        birchGate = new BlockModFenceGate(TweakBlock.BIRCHGATE_ID, "birch");
        jungleGate = new BlockModFenceGate(TweakBlock.JUNGLEGATE_ID, "planks_jungle");
        
        GameRegistry.registerBlock(birchFence, TweakBlock.BIRCHFENCE_UNLOC_NAME);
        GameRegistry.registerBlock(jungleFence, TweakBlock.JUNGLEFENCE_UNLOC_NAME);
        GameRegistry.registerBlock(birchGate, TweakBlock.BIRCHGATE_UNLOC_NAME);
        GameRegistry.registerBlock(jungleGate, TweakBlock.JUNGLEGATE_UNLOC_NAME);
        
        TweakBlock.fenceIDs.add(TweakBlock.BIRCHFENCE_ID);
        TweakBlock.fenceIDs.add(TweakBlock.JUNGLEFENCE_ID);
        TweakBlock.fenceIDs.add(TweakBlock.BIRCHGATE_ID);
        TweakBlock.fenceIDs.add(TweakBlock.JUNGLEGATE_ID);
    }

        public static void addNames() {

        LanguageRegistry.addName(birchFence, TweakBlock.BIRCHFENCE_NAME);
        LanguageRegistry.addName(jungleFence, TweakBlock.JUNGLEFENCE_NAME);
        LanguageRegistry.addName(birchGate, TweakBlock.BIRCHGATE_NAME);
        LanguageRegistry.addName(jungleGate, TweakBlock.JUNGLEGATE_NAME);
    }
}