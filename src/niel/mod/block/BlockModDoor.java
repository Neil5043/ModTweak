package niel.mod.block;

import java.util.Random;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.IconFlipped;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Created with IntelliJ IDEA.
 * User: niel
 * Date: 11/4/13
 * Time: 8:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class BlockModDoor extends BlockDoor
{
    @SideOnly(Side.CLIENT)
    private Icon[] rearIcons;
    @SideOnly(Side.CLIENT)
    private Icon[] frontIcons;

    protected BlockModDoor(int par1)
    {
        super(par1, Material.wood);
        float f = 0.5F;
        float f1 = 1.0F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
        setCreativeTab(CreativeTabs.tabBlock);
    }

    @SideOnly(Side.CLIENT)
    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getIcon(int par1, int par2)
    {
        return this.frontIcons[0];
    }

    @SideOnly(Side.CLIENT)
    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.rearIcons = new Icon[2];
        this.frontIcons = new Icon[2];
        this.rearIcons[0] = par1IconRegister.registerIcon(this.getTextureName() + "_upper");
        this.frontIcons[0] = par1IconRegister.registerIcon(this.getTextureName() + "_lower");
        this.rearIcons[1] = new IconFlipped(this.rearIcons[0], true, false);
        this.frontIcons[1] = new IconFlipped(this.frontIcons[0], true, false);
    }

    /**
     * Called when the block is clicked by a player. Args: x, y, z, entityPlayer
     */
    public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer) {
    	// Do Nothing
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
    	return this.blockID;
    }

    /**
     * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
     */
    public int idPicked(World par1World, int par2, int par3, int par4)
    {
        return this.blockID;
    }
}
