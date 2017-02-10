package extraction.files;

import entities.Files;

public final class Client {

	private String basePath;
	private Files files;

	private Client(String basePath) {
		this.basePath = basePath;
		files = Files.New();
	}
	public static Client New(String basePath) { return new Client(basePath); }

	public Files extractFiles() throws Exception {
		files = FilesExtraction.New(basePath).extract();

		return files;
	}

}
