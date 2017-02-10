package main;

import java.nio.file.Path;

import context.AppContext;
import entities.Files;
import entities.Word;
import entities.Words;
import extraction.files.Client;

public class WordsFrequencyCalculator {
	
	public static void main(String[] args) throws Exception {
		AppContext.CONTEXT.load();
		String basePath = "D:\\hafiz.muhammad.hassan\\temp";
		
		Files files = Client.New(basePath).extractFiles();
		for (Path p : files) {
			System.out.println("*** " + p + "***");
			Words words = extraction.words.Client.New().extractWordsFrom(p);
			for (Word w : words) {
				System.out.println(w);
			}
			System.out.println();
		}
	}
}
