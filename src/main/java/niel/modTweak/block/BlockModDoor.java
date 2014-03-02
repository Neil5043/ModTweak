package niel.modTweak.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.IIconFlipped;
import net.minecraft.client.renderer.texture.IIIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import niel.modTweak.ModTweak;
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
    private IIcon[] IIcons;
    
    private String name;
    private int damage;

    public BlockModDoor(int par1, int damage, String doorName)
    {
        super(par1, Material.wood);
        float f = 0.5F;
        float f1 = 1.0F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
        this.setHardness(3F);
        this.setStepSound(Block.soundWoodFootstep);
        this.name = doorName;
        this.damage = damage;
    }

    @Override
	@SideOnly(Side.CLIENT)
    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public IIcon getIIcon(int par1, int par2)
    {
        return this.IIcons[0];
    }
    
    @Override
    public IIcon getBlockTexture(IBlockAccess blockAccess, int par2, int par3, int par4, int par5)
    {
    	if (par5 != 1 && par5 != 0)
        {
            int i1 = this.getFullMetadata(blockAccess, par2, par3, par4);
            int j1 = i1 & 3;
            boolean flag2 = (i1 & 8) != 0;

            return this.IIcons[(flag2 ? 1 : 0)];
        }
        else
        {
            return this.IIcons[0];
        }
    }

    @Override
	@SideOnly(Side.CLIENT)
    /**
     * When this method is called, your block should register all the IIcons it needs with the given IIIconRegister. This
     * is the only chance you get to register IIcons.
     */
    public void registerIIcons(IIIconRegister register)
    {
        this.IIcons = new IIcon[2];
      
        IIcons[0] = register.registerIIcon("modtweak:" + name + "_upper");
        IIcons[1] = register.registerIIcon("modtweak:" + name + "_lower");
        
        /*this.rearIIcons[0] = register.registerIIcon("modtweak:doorBirch_upper");
        this.frontIIcons[0] = register.registerIIcon("modtweak:doorBirch_lower");
        this.rearIIcons[1] = new IIconFlipped(this.rearIIcons[0], true, false);
        this.frontIIcons[1] = new IIconFlipped(this.frontIIcons[0], true, false);
        
        this.rearIIcons[2] = register.registerIIcon("modtweak:doorJungle_upper");
        this.frontIIcons[2] = register.registerIIcon("modtweak:doorJungle_lower");
        this.rearIIcons[3] = new IIconFlipped(this.rearIIcons[2], true, false);
        this.frontIIcons[3] = new IIconFlipped(this.frontIIcons[2], true, false);
        
        this.rearIIcons[4] = register.registerIIcon("modtweak:doorJungle_upper");
        this.frontIIcons[4] = register.registerIIcon("modtweak:doorJungle_lower");
        this.rearIIcons[5] = new IIconFlipped(this.rearIIcons[4], true, false);
        this.frontIIcons[5] = new IIconFlipped(this.frontIIcons[4], true, false);
    */
    }

    /**
     * Called when the block is clicked by a player. Args: x, y, z, entityPlayer
     */
    @Override
	public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer) {
    	// Do Nothing
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    @Override
	public int idDropped(int meta, Random par2Random, int par3)
    {
    	return (meta & 8) != 0 ? 0 : ModTweakBlock.doorItem.itemID;
    }
    
    @Override
    public int damageDropped(int par1)
    {
    	return damage;
    }

    /**
     * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
     */
    @Override
	public int idPicked(World par1World, int par2, int par3, int par4)
    {
        return this.blockID;
    }
}
