package niel.mod.Block;

import java.util.ArrayList;

import net.minecraft.block.Block;

public class TweakBlock {

    // Textures Location
    public static final String TEXTURE_LOC = "example";

    public static final int BIRCHFENCE_ID = 3002;
    public static final String BIRCHFENCE_NAME = "Birch Fence";
    public static final String BIRCHFENCE_UNLOC_NAME = "birchFence";

	public static final int JUNGLEFENCE_ID = 3003;
	public static final String JUNGLEFENCE_NAME = "Jungle Fence";
	public static final String JUNGLEFENCE_UNLOC_NAME = "jungleFence";
	
	public static final String VANILLAFENCE_NAME = Block.fence.getLocalizedName();
	public static final String VANILLAFENCE_UNLOC_NAME = Block.fence.getUnlocalizedName();
	
	public static ArrayList<Integer> fenceIDs = new ArrayList<Integer>();
}
