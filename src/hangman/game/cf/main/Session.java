package hangman.game.cf.main;

import java.text.Collator;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

class Session {

	private static final Collator COLLATOR = Collator.getInstance(Locale.UK);
	private static final int MAX_NUM_TRIALS = 12;
	private static final String PATTERN = "[A-Z]";

	private final Scanner scanner;
	private final String wordToFind;
	private final SortedSet<String> wrongGuesses = new TreeSet<>(COLLATOR);
	private final Set<String> hiddenLetters;

	Session(String wordToFind, Scanner scanner) {
		this.wordToFind = wordToFind.toUpperCase();
		this.scanner = scanner;
		hiddenLetters = new HashSet<>(Arrays.asList(wordToFind.toUpperCase().split("")));
	}

	void play() throws QuitException {
		for (printCurrentState(); !isSessionEnd(); printCurrentState()) {
			String currentLetter = requestLetter();
			updateState(currentLetter);
		}
		System.out.printf(
				hiddenLetters.isEmpty() ? "%nYou won, congrats!%n" : "%nThis time you did not succeed! The solution would have been \"%s\"!%n",
				wordToFind);
	}

	private void updateState(String currentLetter) {
		if (!wordToFind.contains(currentLetter)) {
			wrongGuesses.add(currentLetter);
		}
		hiddenLetters.remove(currentLetter.toUpperCase());
	}

	private void printCurrentState() {
		printWord();
		printWrongGuesses();
	}

	private void printWrongGuesses() {
		if (!wrongGuesses.isEmpty()) {
			System.out.print("     Wrong guesses: " + String.join(", ", wrongGuesses));
		}
		System.out.println();
	}

	private void printWord() {
		System.out.println();
		for (String letter : wordToFind.split("")) {
			System.out.print(!hiddenLetters.contains(letter) ? letter + " " : "_ ");
		}
	}

	private boolean isSessionEnd() {
		return hiddenLetters.isEmpty() || MAX_NUM_TRIALS == wrongGuesses.size();
	}

	private String requestLetter() throws QuitException {
		for (;;) {
			System.out.printf("Guess a letter: ");
			String currentLetter = scanner.nextLine().strip().toUpperCase();
			if ("*".equals(currentLetter)) {
				throw new QuitException();
			}
			if (currentLetter.matches(PATTERN)) {
				return currentLetter;
			}
		}
	}
}
