package niel.modTweak.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneLight;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import niel.modTweak.ModTweak;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModLight extends BlockRedstoneLight
{

	public BlockModLight()
	{
		super(false);
		setHardness(1.0F);
		setCreativeTab(ModTweak.tabStoneLamp);
	}

	@SideOnly(Side.CLIENT)
	private IIcon IIconActive, IIconInactive;

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register)
	{
		IIconActive = register.registerIcon("modtweak:" + "light_on");
		IIconInactive = register.registerIcon("modtweak:" + "light_off");
	}

	@Override
	public IIcon getIcon(int par1, int par2)
	{
		return par2 == 0 ? IIconInactive : IIconActive;
	}

	public boolean isActive(World world, int x, int y, int z)
	{
		return world.getBlockMetadata(x, y, z) == 1;
	}

	/**
	 * Called whenever the block is added into the world. Args: world, x, y, z
	 */
	@Override
	public void onBlockAdded(World world, int x, int y, int z)
	{
		if (!world.isRemote)
		{
			if (isActive(world, x, y, z) && !world.isBlockIndirectlyGettingPowered(x, y, z))
			{
				world.setBlockMetadataWithNotify(x, y, z, 0, 3);
			}
			else if (!isActive(world, x, y, z) && world.isBlockIndirectlyGettingPowered(x, y, z))
			{
				world.setBlockMetadataWithNotify(x, y, z, 1, 3);
			}
		}
	}

	/**
	 * Lets the block know when one of its neighbor changes. Doesn't know which
	 * neighbor changed (coordinates passed are their own) Args: x, y, z,
	 * neighbor blockID
	 */
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
	{
		if (!world.isRemote)
		{
			if (isActive(world, x, y, z) && !world.isBlockIndirectlyGettingPowered(x, y, z))
			{
				world.setBlockMetadataWithNotify(x, y, z, 0, 3);
			}
			else if (!isActive(world, x, y, z) && world.isBlockIndirectlyGettingPowered(x, y, z))
			{
				world.setBlockMetadataWithNotify(x, y, z, 1, 3);
			}
		}
		if (isActive(world, x, y, z))
			this.setLightLevel(1.0F);
		else
			this.setLightLevel(0.0F);
	}

	/**
	 * Ticks the block if it's been scheduled
	 */
	@Override
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		if (!par1World.isRemote && isActive(par1World, par2, par3, par4) && !par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 3);
		}
		else
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, 3);
		}
	}

	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
	{
		return this.getItem(null, 0, 0, 0);
	}

	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
	 */
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z)
	{
		return new ItemStack(this);
	}

	@Override
	public int damageDropped(int par1)
	{
		return 0;
	}
}