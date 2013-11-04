package niel.mod.Block;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;


public class ModTweakBlock  {

    public static  Block BirchFence;

    public static void init()  {
        BirchFence = new niel.mod.Block.BirchFence(TweakBlock.BIRCHFENCE_ID);
        GameRegistry.registerBlock(BirchFence, TweakBlock.BIRCHFENCE_NAME);



    }

        public static void addNames() {


        LanguageRegistry.addName(BirchFence, TweakBlock.BIRCHFENCE_NAME);


    }
}