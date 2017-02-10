package entities;

import java.nio.file.Path;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Files implements Iterable<Path> {

	private List<Path> paths;

	private Files() { paths = new LinkedList<>(); }
	public static Files New() { return new Files(); }

	@Override
	public Iterator<Path> iterator() { return paths.iterator(); }

	public boolean add(Path p) {
		if (null == p)
			return Boolean.FALSE;

		return paths.add(p);
	}

}
