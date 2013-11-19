package niel;


import net.minecraft.creativetab.CreativeTabs;
import niel.lib.ModLib;
import niel.mod.block.ModTweakBlock;
import niel.mod.creativeTab.CreativeTabModTweak;
import niel.mod.item.ModTweakItem;
import niel.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = ModLib.MOD_ID, name = ModLib.MOD_NAME, version = ModLib.VERSION)
public class ModTweak {

    @Instance(ModLib.MOD_ID)
    public static ModTweak instance;

    @SidedProxy(clientSide = ModLib.CLIENT_PROXY_CLASS, serverSide = ModLib.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    public static CreativeTabs tabStoneLamp = new CreativeTabModTweak(CreativeTabs.getNextID());
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {

        ModTweakItem.init();
        ModTweakBlock.init();
        
        LanguageRegistry.instance().addStringLocalization("itemGroup." + "modTweak" , "en_US", "Mod Tweak");

    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        ModTweakItem.addNames();
        ModTweakItem.registerRecipes();
        ModTweakBlock.addNames();
        ModTweakBlock.registerRecipes();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

}
}