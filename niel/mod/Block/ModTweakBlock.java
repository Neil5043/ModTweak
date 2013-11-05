package niel.mod.Block;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;


public class ModTweakBlock  {

    public static  Block BirchFence;
    public static  Block JungleFence;
    public static  Block TweakedVanillaFence;

    public static void init()  {
        BirchFence = new niel.mod.Block.BlockModFence(TweakBlock.BIRCHFENCE_ID, "birch");
        JungleFence = new BlockModFence(TweakBlock.JUNGLEFENCE_ID, "planks_jungle");
        //TweakedVanillaFence = new BlockModFence(Block.fence.blockID, "oak");
        
        GameRegistry.registerBlock(BirchFence, TweakBlock.BIRCHFENCE_UNLOC_NAME);
        GameRegistry.registerBlock(JungleFence, TweakBlock.JUNGLEFENCE_UNLOC_NAME);
        
        TweakBlock.fenceIDs.add(TweakBlock.BIRCHFENCE_ID);
        TweakBlock.fenceIDs.add(TweakBlock.JUNGLEFENCE_ID);
       // GameRegistry.registerBlock(TweakedVanillaFence, TweakBlock.VANILLAFENCE_UNLOC_NAME);
    }

        public static void addNames() {

        LanguageRegistry.addName(BirchFence, TweakBlock.BIRCHFENCE_NAME);
        LanguageRegistry.addName(JungleFence, TweakBlock.JUNGLEFENCE_NAME);
     //   LanguageRegistry.addName(TweakedVanillaFence, TweakBlock.VANILLAFENCE_NAME);
    }
}