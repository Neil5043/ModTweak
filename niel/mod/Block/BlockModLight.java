package niel.mod.Block;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockModLight extends Block
{
    public BlockModLight(int par1, Material par2Material)
    {
        super(par1, par2Material);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setLightValue(10F);
    }
}