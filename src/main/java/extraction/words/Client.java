package extraction.words;

import java.nio.file.Path;

import entities.Words;

public final class Client {

	private Client() {}
	public static Client New() { return new Client(); }

	public Words extractWordsFrom(Path path) throws Exception {
		WordsExtractor e = WordsExtractorFactory.INSTANCE.NewExractor(ExtractorType.LINE_BY_LINE, path);

		return e.extract();
	}
}
