package utils;

import context.AppContext;
import context.ConfigPropKey;

public enum Defaults {

	CONFIG_FILE_NAME("config.xml"),
	FILE_EXT_FILTER("*.{txt,text}"),
	;

	public final String val;
	private Defaults(String val) { this.val = val; }

	public static String getFileGlobFilter() {
		String fileExtensions = AppContext.CONTEXT.getStrProp(ConfigPropKey.FILE_EXTENSIONS);
		if (null == fileExtensions || fileExtensions.length() < 1)
			return FILE_EXT_FILTER.val;

		String fileExtGlobFilter = "*.{" + fileExtensions + "}" ;

		return fileExtGlobFilter;
	}

}
