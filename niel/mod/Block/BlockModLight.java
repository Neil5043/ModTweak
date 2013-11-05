package niel.mod.Block;


import net.minecraft.block.BlockRedstoneLight;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import niel.ModTweak;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModLight  extends BlockRedstoneLight {
    public BlockModLight(int id) {
        super(id, false);
        setHardness(4.0F);
        setCreativeTab(CreativeTabs.tabDecorations);
        setUnlocalizedName(TweakBlock.BLOCKLIGHT_UNLOC_NAME);
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