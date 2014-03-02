package niel.modTweak.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
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
    private IIcon[] icons;
    
    private String name;
    private int damage;

    public BlockModDoor(int damage, String doorName)
    {
        super(Material.wood);
        float f = 0.5F;
        float f1 = 1.0F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
        this.setHardness(3F);
        this.setStepSound(Block.soundTypeWood);
        this.name = doorName;
        this.damage = damage;
    }

	@SideOnly(Side.CLIENT)
    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    @Override
    public IIcon getIcon(int side, int meta)
    {
        return this.icons[0];
    }
    
    @Override
    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int meta)
    {
    	if (meta != 1 && meta != 0)
        {
            int i1 = this.func_150012_g(world, x, y, z);
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
     * When this method is called, your block should register all the IIcons it needs with the given IIIconRegister. This
     * is the only chance you get to register IIcons.
     */
    public void registerBlockIcons(IIconRegister register)
    {
        this.icons = new IIcon[2];
      
        icons[0] = register.registerIcon("modtweak:" + name + "_upper");
        icons[1] = register.registerIcon("modtweak:" + name + "_lower");
        
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
    public Item getItemDropped(int meta, Random p_149650_2_, int p_149650_3_)
    {
    	return (meta & 8) != 0 ? null : ModTweakBlock.doorItem;
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
    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z)
    {
        return new ItemStack(this);
    }
}
