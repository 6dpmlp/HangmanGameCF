package hangman.game.cf.main;

class UserInfo {
	private static final int MAX_GUESS_LIMIT = 12;

	void welcome() {
		System.out.printf("Welcome to the Hangman Game!%n");
	}

	void adviseRules() {
		System.out.printf("%nYou have to guess a word in each session.\r\n"
				+ "The word to guess can be at most a seven-letter long English word, which can be a noun, an adjective or a verb.\r\n"
				+ "You can only guess a letter at a time! You have to find all the letters to succeed!\r\n"
				+ "To do so, you have at most %d guesses. If you guess a letter correctly, the program will reveal all of them in the word\r\n"
				+ "and also it will keep track of the wrong guesses. When you take a guess lowercase and uppercase letters are equal.\r\n"
				+ "For the yes-no questions, every word evaluates to true, which does not start with the lettern 'n'!\r\n"
				+"If you want to give up, please press *!%n", MAX_GUESS_LIMIT);
	}

	void goodbye() {
		System.out.printf("%nGoodbye!%n");
	}
}
