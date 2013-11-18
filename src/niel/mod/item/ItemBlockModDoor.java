package niel.mod.item;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import niel.mod.block.ModTweakBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBlockModDoor extends ItemBlock {
	
	public Icon[] icons;
	public String[] textureNames = new String[]{"birchDoorItem", "jungleDoorItem", "spruceDoorItem"};
			
	public ItemBlockModDoor(int id)
	{
		super(id);
		maxStackSize = 16;
		setCreativeTab(CreativeTabs.tabRedstone);
		setHasSubtypes(true);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister register)
	{
		this.icons = new Icon[textureNames.length];
		
		for (int i = 0; i < textureNames.length; i++)
			icons[i] = register.registerIcon(textureNames[i]);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int meta) {
		return icons[meta];
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs,
			List list) {
		for (int i = 0; i < icons.length; i++)
			list.add(new ItemStack(this.itemID, 1, i));
	}

	@Override
    public boolean onItemUse (ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float clickX, float clickY, float clickZ)
    {
        if (side != 1)
        {
            return false;
        }
        y++;

        Block block;
        switch (itemstack.getItemDamage())
        {
        case 0:
            block = ModTweakBlock.birchDoor;
            break;
        case 1:
            block = ModTweakBlock.jungleDoor;
            break;
        case 2:
            block = ModTweakBlock.spruceDoor;
            break;
        default:
            block = Block.doorWood;
            break;
        }
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
            int rotate = MathHelper.floor_double((double) (((player.rotationYaw + 180F) * 4F) / 360F) - 0.5D) & 3;
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

        int var8 = (world.isBlockNormalCube(x - var6, y, z - var7) ? 1 : 0) + (world.isBlockNormalCube(x - var6, y + 1, z - var7) ? 1 : 0);
        int var9 = (world.isBlockNormalCube(x + var6, y, z + var7) ? 1 : 0) + (world.isBlockNormalCube(x + var6, y + 1, z + var7) ? 1 : 0);
        boolean var10 = world.getBlockId(x - var6, y, z - var7) == block.blockID || world.getBlockId(x - var6, y + 1, z - var7) == block.blockID;
        boolean var11 = world.getBlockId(x + var6, y, z + var7) == block.blockID || world.getBlockId(x + var6, y + 1, z + var7) == block.blockID;
        boolean var12 = false;

        if (var10 && !var11)
        {
            var12 = true;
        }
        else if (var9 > var8)
        {
            var12 = true;
        }

        world.setBlock(x, y, z, block.blockID, rotate, 2);
        world.setBlock(x, y + 1, z, block.blockID, 8 | (var12 ? 1 : 0), 2);
        world.notifyBlocksOfNeighborChange(x, y, z, block.blockID);
        world.notifyBlocksOfNeighborChange(x, y + 1, z, block.blockID);
    }
}