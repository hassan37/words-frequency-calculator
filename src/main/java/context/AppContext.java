package context;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.google.common.base.Splitter;

import utils.Defaults;

public enum AppContext {

	CONTEXT,
	;

	public final Properties CONFIG_PROPS = new Properties();
	private Splitter splitter;

	public void load() throws IOException {
		try (InputStream in =  getClass().getClassLoader().getResourceAsStream(Defaults.CONFIG_FILE_NAME.val);) {
			CONFIG_PROPS.loadFromXML(in);
		}
	}

	public void reload() throws IOException {
		CONFIG_PROPS.clear();
		load();
	}

	public String getStrProp(ConfigPropKey key) { return CONFIG_PROPS.getProperty(key.val); }

	public Integer getIntProp(ConfigPropKey key) {
		String strProp = getStrProp(key);
		Integer intProp = null;
		try {
			intProp = Integer.parseInt(strProp);
		} catch (Exception e) {
			System.out.println("Exception occured in interger conversion due to: " + e.getMessage());
		}

		return intProp;
	}

	public char getCharProp(ConfigPropKey key) {
		String strProp = getStrProp(key);
		
		return strProp.charAt(0);
	}

	public Splitter getSplitter() {
		if (null == splitter) {
			char filterWordsBy = getCharProp(ConfigPropKey.FILTER_WORDS_BY);
			splitter = Splitter.on(filterWordsBy).omitEmptyStrings().trimResults();
		}

		return splitter;
	}
}
