package hangman.game.cf.main;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		new Main().run();
	}

	private void run() {
		var userInfo = new UserInfo();
		userInfo.welcome();
		userInfo.adviseRules();
		run0();
		userInfo.goodbye();
	}

	private void run0() {
		try (Scanner scanner = new Scanner(System.in)) {
			for (boolean first = true; chooseToPlay(scanner, first); first = false) {
				runGame(scanner);
			}
		} catch (IOException ioe) {
			System.out.println("Unfortunately the file cannot be read");
		} catch (QuitException qe) {
			return;
		}
	}

	private void runGame(Scanner scanner) throws QuitException, IOException {
		var target = new TargetSetter();
		String wordToFind = target.getWordToFind();
		var session = new Session(wordToFind, scanner);
		session.play();
	}

	private boolean chooseToPlay(Scanner scanner, boolean first) {
		System.out.printf("%nCan the %s round start? ", first ? "first" : "next");
		return !scanner.nextLine().strip().toLowerCase().startsWith("n");
	}
}
