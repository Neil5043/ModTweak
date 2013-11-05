package niel.mod.core;

import net.minecraft.launchwrapper.IClassTransformer;

public class CoreTransformer implements IClassTransformer{

	@Override
	public byte[] transform(String arg0, String arg1, byte[] arg2) {
		return arg2;
	}
}
