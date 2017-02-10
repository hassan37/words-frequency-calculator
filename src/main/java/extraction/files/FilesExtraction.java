package extraction.files;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import entities.Files;
import utils.Defaults;

class FilesExtraction implements FilesExtractor {

	private final Path basePath;
	private final Files files;
	private final PathMatcher matcher;

	private FilesExtraction(String basePath) {
		this.basePath = Paths.get(basePath);
		files = Files.New();
		matcher = FileSystems.getDefault().getPathMatcher("glob:" + Defaults.getFileGlobFilter());
	}
	public static FilesExtractor New(String basePath) { return new FilesExtraction(basePath); }

	private class FilesTreeVisiting extends SimpleFileVisitor<Path> {

		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
			Path name = file.getFileName();
			boolean isReadable = java.nio.file.Files.isReadable(file);
			boolean isFileNameMatchesToFilter = (name != null && matcher.matches(name));
			if (isReadable && isFileNameMatchesToFilter)
				files.add(file);

			return FileVisitResult.CONTINUE;
		}
	}

	@Override
	public Files extract() throws Exception {
		FilesTreeVisiting vis = new FilesTreeVisiting();
		java.nio.file.Files.walkFileTree(basePath, vis);

		return files;
	}

}
