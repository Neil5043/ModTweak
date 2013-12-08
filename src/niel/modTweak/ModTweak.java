package niel.modTweak;


import net.minecraft.creativetab.CreativeTabs;
import niel.modTweak.block.ModTweakBlock;
import niel.modTweak.creativeTab.CreativeTabModTweak;
import niel.modTweak.item.ModTweakItem;
import niel.modTweak.lib.Reference;
import niel.modTweak.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class ModTweak {

	@Instance(Reference.MOD_ID)
	public static ModTweak instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;

	public static CreativeTabs tabStoneLamp = new CreativeTabModTweak(CreativeTabs.getNextID());

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		ModTweakItem.init();
		ModTweakBlock.init();
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