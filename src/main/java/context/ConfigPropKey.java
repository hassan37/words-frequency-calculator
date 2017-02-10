package context;

public enum ConfigPropKey {
	
	FILE_EXTENSIONS("file_extensions"),
	MAX_THREADS("max_threads"),
	WORDS_THRESHOLD("words_threshold"),
	FILTER_WORDS_BY("filter_words_by"),
	;

	public final String val;
	private ConfigPropKey(String val) { this.val = val; }
}
