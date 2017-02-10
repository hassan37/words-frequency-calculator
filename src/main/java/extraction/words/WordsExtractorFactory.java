package extraction.words;

import java.nio.file.Path;

enum WordsExtractorFactory {

	INSTANCE,
	;

	WordsExtractor NewExractor(ExtractorType type, Path path) {
		WordsExtractor e = null;
		switch (type) {
		case LINE_BY_LINE:
			e = LineByLineExtraction.New(path); break;
		}

		return e;
	}
}
