package extraction.words;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import context.AppContext;
import entities.Word;
import entities.Words;

class LineByLineExtraction implements WordsExtractor {

	private final Path path;
	private final Words words;

	private LineByLineExtraction(Path path) {
		this.path = path;
		words = Words.New();
	}
	static WordsExtractor New(Path path) { return new LineByLineExtraction(path); }

	public Words extract() throws Exception {
		readFile();

		return words;
	}

	private void readFile() throws IOException {
		try (BufferedReader reader = Files.newBufferedReader(path)) {
		    String line = null;
		    while ((line = reader.readLine()) != null)
		    	extractWordsFrom(line);
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		    throw x;
		}
	}

	private void extractWordsFrom(String line) {
		Iterable<String> extractedWords = AppContext.CONTEXT.getSplitter().split(line);
		for (String w : extractedWords) {
			Word wo = Word.New(w);
			words.addAndIncrement(wo);
		}
	}

}
