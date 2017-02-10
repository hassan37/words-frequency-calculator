package extraction.files;

import entities.Files;

interface FilesExtractor {

	Files extract() throws Exception;
}
