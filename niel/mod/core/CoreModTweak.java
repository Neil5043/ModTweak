package niel.mod.core;

import java.util.Map;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

public class CoreModTweak implements IFMLLoadingPlugin {

	public String[] getLibraryRequestClass() {
		return null;
	}

	@Override
	public String[] getASMTransformerClass() {
		return new String[] {"niel.mod.core.CoreTransformer"};
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

}
