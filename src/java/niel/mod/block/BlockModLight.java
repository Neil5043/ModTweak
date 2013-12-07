package niel.mod.block;


import java.util.Random;

import net.minecraft.block.BlockRedstoneLight;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import niel.ModTweak;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModLight  extends BlockRedstoneLight {
	
	public int meta = 0;
	
    public BlockModLight(int id) {
        super(id, false);
        setHardness(1.0F);
        setCreativeTab(ModTweak.tabStoneLamp);
        setUnlocalizedName(TweakBlock.BLOCKLIGHT_UNLOC_NAME);
        meta = 1;
    }
    
    @SideOnly(Side.CLIENT)
    private Icon iconActive, iconInactive;
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister register)
    {
    	iconActive = register.registerIcon("modtweak:" + "light_on");
    	iconInactive = register.registerIcon("modtweak:" + "light_off");
    }
    
    public Icon getIcon()
    {
    	System.out.println("GOT ICON");
    	return meta == 0 ? iconInactive : iconActive;
    }
    
    @Override
    public Icon getIcon(int par1, int par2) {
    	return par2 == 0 ? iconInactive : iconActive;
    }
    
    public boolean isActive()
    {
    	System.out.println("META: " + meta);
    	return meta == 1;
    }
    
    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        if (!par1World.isRemote)
        {
            if (isActive() && !par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
            {
                par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 3);
                meta = 0;
            }
            else if (!isActive() && par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
            {
            	par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, 3);
            	meta = 1;
            }
        }
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        if (!par1World.isRemote)
        {
            if (isActive() && !par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
            {
            	par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 3);
            	meta = 0;
            }
            else if (!isActive() && par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
            {
            	par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, 3);
            	meta = 1;
            }
        }
        if (isActive())
        	this.setLightValue(1.0F);
        else 
        	this.setLightValue(0.0F);
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!par1World.isRemote && isActive() && !par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
        {
        	par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 3);
        	meta = 0;
        }
        else 
        {
        	par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, 3);
        	meta = 1;
        	}
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return this.blockID;
    }

    @SideOnly(Side.CLIENT)

    /**
     * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
     */
    public int idPicked(World par1World, int par2, int par3, int par4)
    {
        return this.blockID;
    }
    
    @Override
    public int damageDropped(int par1) {
    	return 0;
    }
}