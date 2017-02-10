package extraction.words;

import entities.Words;

interface WordsExtractor {

	Words extract() throws Exception;
}
