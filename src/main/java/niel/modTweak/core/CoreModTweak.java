package niel.modTweak.core;

import java.util.Map;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

public class CoreModTweak implements IFMLLoadingPlugin {

	@Override
	public String[] getASMTransformerClass() {
		return new String[] {"niel.modTweak.core.CoreTransformer"};
	}

	@Override
	public String getModContainerClass() {
		return null;
	}

	@Override
	public String getSetupClass() {
		return null;
	}

	@Override
	public void injectData(Map<String, Object> data) {
	}

	@Override
	public String getAccessTransformerClass()
	{
		return null;
	}
}
