
package entities;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import utils.FileTypeBySize;

public class Words implements Iterable<Word> {
    private Map<String, Word> words;
    private FileTypeBySize fSize;
    private Integer totalNumOfWords;

    private Words() { words = new HashMap<>(); }
    public static Words New() { return new Words(); }

    public void addAndIncrement(Word word) {
		words.putIfAbsent(word.key, word);

		words.get(word.key).incrementFrequency();
	}

    public int size() { return words.size(); }
    
    public int totalNumberOfWords() {
        if (null == totalNumOfWords) {
            words.values().stream().forEach((w) -> { 
                totalNumOfWords += w.getFrequency();
            });
        }

        return null == totalNumOfWords ? 0 : totalNumOfWords;
    }

    @Override
    public Iterator<Word> iterator() { return words.values().iterator(); }

    private FileTypeBySize getFileTypeBySize() {
        if (null == fSize)
           fSize = FileTypeBySize.getType(totalNumberOfWords());
        
        return fSize;
    }
    
    public boolean isLargeFile() {
        return FileTypeBySize.LARGE == getFileTypeBySize();
    }
    
    public boolean isShortFile() {
        return FileTypeBySize.SHORT == getFileTypeBySize();
    }

    public static void main(String[] args) {
    	System.out.println(System.getProperty("user.dir"));
	}
}
