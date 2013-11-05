package niel.mod.Block;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModLight  extends Block {
    public BlockModLight(int id, String unlocalizedName) {
        super(id, Material.wood);
        setHardness(4.0F);
        setCreativeTab(CreativeTabs.tabDecorations);
        setUnlocalizedName(unlocalizedName);
        setLightValue(3F);
    }
    
    @SideOnly(Side.CLIENT)
    private Icon icon;
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister register)
    {
    	icon = register.registerIcon("modtweak:" + "light");
    }
    
    public Icon getIcon()
    {
    	return icon;
    }
}