package niel.mod.Block;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockModLight extends Block {
    public BlockModLight(int id, String textureName, String unlocalizedName) {
        super(id, "modtweak" + ":" + textureName, Material.wood);
        setHardness(4.0F);
        setCreativeTab(CreativeTabs.tabDecorations);
        setUnlocalizedName(unlocalizedName);
    }
}