package niel.mod.block;

import net.minecraft.block.BlockFenceGate;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModFenceGate extends BlockFenceGate
{

	private String textureName;

	public BlockModFenceGate(int id, String textureName, String unlocName)
	{
		super(id);
		setHardness(4.0F);
		this.textureName = textureName;
		setUnlocalizedName(unlocName);
	}

	@SideOnly(Side.CLIENT)
	private Icon icon;

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		icon = par1IconRegister.registerIcon("modtweak:" + textureName);
	}

	@Override
	public Icon getIcon(int par1, int par2)
	{
		return icon;
	}
}
