package blackjack.view;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);
	private static final String MESSAGE_ASK_PARTICIPANTS = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
	private static final String NAME_DELIMITER = ",";
	private static final String MESSAGE_ASK_HIT_CHOICE = "%s, 한장의 카드를 더 받겠습니까?(예는 Y/y, 아니오는 N/n)%n";
	private static final String CHOICE_YES = "y";
	private static final String CHOICE_NO = "n";
	private static final String ERROR_MESSAGE_ILLEGAL_CHOICE_FORMAT = "[ERROR] y 또는 n 으로 입력해야 합니다.";
	private static final String MESSAGE_ASK_BET_AMOUNT = "%s의 배팅 금액은?%n";

	public static List<String> askPlayerName() {
		System.out.println(MESSAGE_ASK_PARTICIPANTS);
		String input = scanner.nextLine();
		return Arrays.asList(input.split(NAME_DELIMITER));
	}

	public static String askHit(String name) {
		System.out.printf(MESSAGE_ASK_HIT_CHOICE, name);
		try {
			String input = scanner.nextLine().toLowerCase(Locale.ROOT);
			checkValidChoice(input);
			return input;
		} catch (IllegalArgumentException e) {
			return askHit(name);
		}
	}

	private static void checkValidChoice(String choice) {
		if (!(choice.equals(CHOICE_YES) || choice.equals(CHOICE_NO))) {
			throw new IllegalArgumentException(ERROR_MESSAGE_ILLEGAL_CHOICE_FORMAT);
		}
	}

	public static String askBetAmount(String name) {
		System.out.printf(MESSAGE_ASK_BET_AMOUNT, name);
		return scanner.nextLine();
	}
}
