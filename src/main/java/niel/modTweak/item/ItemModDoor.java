package niel.modTweak.item;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import niel.modTweak.ModTweak;
import niel.modTweak.block.ModTweakBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemModDoor extends Item {

	public IIcon[] IIcons;
	public String[] textureNames = new String[]{"birchDoorItem", "jungleDoorItem", "spruceDoorItem"};

	public ItemModDoor()
	{
		super();
		maxStackSize = 16;
		setCreativeTab(ModTweak.tabStoneLamp);
		setHasSubtypes(true);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs par2CreativeTabs, List list) {
		for (int i = 0; i < IIcons.length; i++)
			list.add(new ItemStack(this, 1, i));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister register)
	{
		this.IIcons = new IIcon[textureNames.length];

		for (int i = 0; i < textureNames.length; i++)
			IIcons[i] = register.registerIcon("modtweak:" + textureNames[i]);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int meta) {
		return IIcons[meta];
	}


	@Override
	public boolean onItemUse (ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float clickX, float clickY, float clickZ)
	{
		if (side != 1)
		{
			return false;
		}
		y++;

		Block block = Block.getBlockById(Block.getIdFromBlock(ModTweakBlock.birchDoor) + itemstack.getItemDamage());

		if (!player.canPlayerEdit(x, y, z, side, itemstack) || !player.canPlayerEdit(x, y + 1, z, side, itemstack))
		{
			return false;
		}
		if (!block.canPlaceBlockAt(world, x, y, z))
		{
			return false;
		}
		else
		{
			int rotate = MathHelper.floor_double(((player.rotationYaw + 180F) * 4F) / 360F - 0.5D) & 3;
			placeDoorBlock(world, x, y, z, rotate, block);
			itemstack.stackSize--;
			return true;
		}
	}

	public static void placeDoorBlock (World world, int x, int y, int z, int rotate, Block block)
	{
		byte var6 = 0;
		byte var7 = 0;

		if (rotate == 0)
		{
			var7 = 1;
		}

		if (rotate == 1)
		{
			var6 = -1;
		}

		if (rotate == 2)
		{
			var7 = -1;
		}

		if (rotate == 3)
		{
			var6 = 1;
		}

		int var8 = (world.isBlockNormalCubeDefault(x - var6, y, z - var7, true) ? 1 : 0) + (world.isBlockNormalCubeDefault(x - var6, y + 1, z - var7, true) ? 1 : 0);
		int var9 = (world.isBlockNormalCubeDefault(x + var6, y, z + var7, true) ? 1 : 0) + (world.isBlockNormalCubeDefault(x + var6, y + 1, z + var7, true) ? 1 : 0);
		boolean var10 = world.getBlock(x - var6, y, z - var7) == block || world.getBlock(x - var6, y + 1, z - var7) == block;
		boolean var11 = world.getBlock(x + var6, y, z + var7) == block || world.getBlock(x + var6, y + 1, z + var7) == block;
		boolean var12 = false;

		if (var10 && !var11)
		{
			var12 = true;
		}
		else if (var9 > var8)
		{
			var12 = true;
		}

		world.setBlock(x, y, z, block, rotate, 2);
		world.setBlock(x, y + 1, z, block, 8 | (var12 ? 1 : 0), 2);
		world.notifyBlocksOfNeighborChange(x, y, z, block);
		world.notifyBlocksOfNeighborChange(x, y + 1, z, block);
	}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack)
	{
		switch(par1ItemStack.getItemDamage())
		{
		case 0: return "tile.birchDoor";
		case 1: return "tile.jungleDoor";
		case 2: return "tile.spruceDoor";
		default: return "tile.invalidDoor";
		}
	}
}
