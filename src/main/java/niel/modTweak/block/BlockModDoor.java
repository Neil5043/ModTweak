package niel.modTweak.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.IconFlipped;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
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
    private Icon[] icons;
    
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
    public Icon getIcon(int par1, int par2)
    {
        return this.icons[0];
    }
    
    @Override
    public Icon getBlockTexture(IBlockAccess blockAccess, int par2, int par3, int par4, int par5)
    {
    	if (par5 != 1 && par5 != 0)
        {
            int i1 = this.getFullMetadata(blockAccess, par2, par3, par4);
            int j1 = i1 & 3;
            boolean flag2 = (i1 & 8) != 0;

            return this.icons[(flag2 ? 1 : 0)];
        }
        else
        {
            return this.icons[0];
        }
    }

    @Override
	@SideOnly(Side.CLIENT)
    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister register)
    {
        this.icons = new Icon[2];
      
        icons[0] = register.registerIcon("modtweak:" + name + "_upper");
        icons[1] = register.registerIcon("modtweak:" + name + "_lower");
        
        /*this.rearIcons[0] = register.registerIcon("modtweak:doorBirch_upper");
        this.frontIcons[0] = register.registerIcon("modtweak:doorBirch_lower");
        this.rearIcons[1] = new IconFlipped(this.rearIcons[0], true, false);
        this.frontIcons[1] = new IconFlipped(this.frontIcons[0], true, false);
        
        this.rearIcons[2] = register.registerIcon("modtweak:doorJungle_upper");
        this.frontIcons[2] = register.registerIcon("modtweak:doorJungle_lower");
        this.rearIcons[3] = new IconFlipped(this.rearIcons[2], true, false);
        this.frontIcons[3] = new IconFlipped(this.frontIcons[2], true, false);
        
        this.rearIcons[4] = register.registerIcon("modtweak:doorJungle_upper");
        this.frontIcons[4] = register.registerIcon("modtweak:doorJungle_lower");
        this.rearIcons[5] = new IconFlipped(this.rearIcons[4], true, false);
        this.frontIcons[5] = new IconFlipped(this.frontIcons[4], true, false);
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
