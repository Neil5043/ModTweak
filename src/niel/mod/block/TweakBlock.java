package niel.mod.block;

import java.util.ArrayList;

public class TweakBlock {

    // Textures Location
    public static final String TEXTURE_LOC = "example";

    public static final int FENCE_ID = 3002;
    public static final String[] FENCE_NAMES = {"Birch Fence", "Jungle Fence", "Spruce Fence", "Iron Fence"};
    public static final String[] FENCE_UNLOC_NAMES = {"birchFence", "jungleFence", "spruceFence", "ironFence"};
    public static final String FENCE_KEY = "modFence";
	
	public static final int BIRCHGATE_ID = 3003;
	public static final String BIRCHGATE_NAME = "Birch Fence Gate";
	public static final String BIRCHGATE_UNLOC_NAME = "birchGate";
	public static final String BIRCHGATE_KEY = "birchGate";
	
	public static final int JUNGLEGATE_ID = 3004;
	public static final String JUNGLEGATE_NAME = "Jungle Fence Gate";
	public static final String JUNGLEGATE_UNLOC_NAME = "jungleGate";
	public static final String JUNGLEGATE_KEY = "jungleGate";
	
	public static final int SPRUCEGATE_ID = 3005;
	public static final String SPRUCEGATE_NAME = "Spruce Fence Gate";
	public static final String SPRUCEGATE_UNLOC_NAME = "spruceGate";
	public static final String SPRUCEGATE_KEY = "spruceGate";	
	
	public static final int DOOR_ID = 3007;
	public static final String[] DOOR_NAMES = new String[]{"Birch Wood Door", "Jungle Wood Door", "SpruceWoodDoor"};
	public static final String[] DOOR_UNLOC_NAMES = new String[]{"birchDoor", "jungleDoor", "spruceDoor"};
	public static final String DOOR_KEY = "modDoor";


    public static final int IRONGATE_ID = 3006;
    public static final String IRONGATE_NAME = "Iron Fence Gate";
    public static final String IRONGATE_UNLOC_NAME = "ironGate";
    public static final String IRONGATE_KEY = "ironGate";

    public static final int BLOCKLIGHT_ID = 3008;
    public static final String BLOCKLIGHT_NAME = "Light Block";
    public static final String BLOCKLIGHT_UNLOC_NAME = "blockLight";
    public static final String BLOCKLIGHT_KEY = "blockLight";
    
    public static final int STAIR_ID = 3009;
    public static final String STAIR_NAME = "Smooth Stone Stairs";
    public static final String STAIR_UNLOC_NAME = "smoothStoneStair";
    public static final String STAIR_KEY = "smoothStoneStair";
    
    public static final String[] GATE_TEXTURE_NAMES = new String[]{"birch", "jungle", "spruce", "iron"};
    public static final String[] GATE_UNLOC_NAMES = new String[]{"gateBirch", "gateJungle", "gateSpruce", "gateIron"};
		
	public static ArrayList<Integer> fenceIDs = new ArrayList<Integer>();
}
