package hangman.game.cf.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

class TargetSetter {

	private static final String FILE_NAME = "Words.txt";
	private final Random random = new Random();
	private final List<String> words;

	TargetSetter() throws IOException {
		words = Files.readAllLines(Paths.get(FILE_NAME));
	}

	String getWordToFind() {
		return words.get(random.nextInt(words.size()));
	}
}
