package niel.modTweak.block;

import java.util.Random;

import net.minecraft.block.BlockRedstoneLight;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import niel.modTweak.ModTweak;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModLight extends BlockRedstoneLight
{

	public BlockModLight(int id)
	{
		super(id, false);
		setHardness(1.0F);
		setCreativeTab(ModTweak.tabStoneLamp);
		setUnlocalizedName(TweakBlockInfo.BLOCKLIGHT_UNLOC_NAME);
	}

	@SideOnly(Side.CLIENT)
	private Icon iconActive, iconInactive;

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		iconActive = register.registerIcon("modtweak:" + "light_on");
		iconInactive = register.registerIcon("modtweak:" + "light_off");
	}

	@Override
	public Icon getIcon(int par1, int par2)
	{
		return par2 == 0 ? iconInactive : iconActive;
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
	public void onNeighborBlockChange(World world, int x, int y, int z, int par5)
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
			this.setLightValue(1.0F);
		else
			this.setLightValue(0.0F);
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
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return this.blockID;
	}

	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
	 */
	public int idPicked(World par1World, int par2, int par3, int par4)
	{
		return this.blockID;
	}

	@Override
	public int damageDropped(int par1)
	{
		return 0;
	}
}