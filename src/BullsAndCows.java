import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * 1. Крави и бикове - Игра, в която участникът трябва да познае намислено
 * число. Играе се по следния начин: - Компютъра намисля число; - Играча въвежда
 * число; - Компютъра извежда колко крави и бика има в числото; - Играча въвежда
 * ново число; - Компютъра извежда колко крави и бика има в число; - Играе се
 * докато играча не познае числото. Играчът има крава, ако във въведеното от
 * него число има цифра, която я има в намисленото. Играчът има бик, ако във
 * въведеното от него число има цифра, която я има в намисленото и тази цифра е
 * на същата позиция в двете числа. Ограничения: намисленото число трябва да е
 * четирицифрено, с различни цифри. Пример за игра: - Намислено число 8456; -
 * Въведено предложение 4231; - На екрана се изписва: 1 крава; - Въведено
 * предположение 4512; - На екрана са изписани: 2 крави; - Въведено
 * предположение 5421; - На екрана се изписва: 1 крава, 1 бик - и т.н.
 */
public class BullsAndCows {

	public static void main(String[] args) {
		System.out
				.println("Здравей, хайде да поиграем бикове и крави. \nМоето число е: \n****");
		int[] numComputer = numComputer();
		// print(num);
		System.out.println("Ти си, познай го!");
		int[] numGamer;
		do {
			numGamer = numGamer();
			// print(numGamer);
			int bulls = numBulls(numComputer, numGamer);
			int cows = numCows(numComputer, numGamer);
			System.out.println("Бикове: " + bulls);
			System.out.println("Крави: " + cows);
		} while (different(numComputer, numGamer));
		System.out.println("Честито! Спечелихте.");

	}

	public static boolean different(int[] num, int[] numGamer) {
		boolean result = false;
		for (int i = 0; i < 4; i++) {
			if (num[i] != numGamer[i]) {
				return true;

			}
		}
		return result;

	}

	public static int[] numComputer() {
		int[] result = new int[4];
		Random rnd = new Random();
		do {
			for (int i = 0; i < result.length; i++) {
				result[i] = rnd.nextInt(10);

			}
		} while (wrongNumber(result));
		return result;

	}

	public static boolean wrongNumber(int[] num) {
		for (int i = 0; i < num.length - 1; i++) {
			for (int j = i + 1; j < num.length; j++) {
				if (num[i] == num[j]) {
					return true;
				}
			}
		}
		return false;

	}

	public static void print(int[] num) {
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i]);

		}
		System.out.println();
	}
	public static int[] numGamer() {
		int[] result = new int[4];
		Scanner sc = new Scanner(System.in);
		int errorCode = 0;
		do {
			String input = sc.nextLine();
			errorCode = validateNumGamer(input);
			switch (errorCode) {
			case 0:
				result = toArray(input);
				break;
			case 1:
				System.out
						.println("Не сте въвели четирицифрено число. Моля, въведете правилно число:");
				break;
			case 2:
				System.out
						.println("Въвели сте и други символи освен цифри. Моля, въведете правилно число:");
				break;
			case 3:
				System.out
						.println("Въвели сте число с повтарящи се цифри. Моля, въведете правилно число:");
				break;
			}
		} while (errorCode != 0);
		return result;
	}

	public static int validateNumGamer(String numGamer) {
		// Проверяваме дали играчът е въвел 4 символа.
		if (numGamer != null && numGamer.length() == 4) {
			// Проверяваме дали играча е въвел само числа.
			if (isDigits(numGamer)) {
				// Прехвърляме символите от текста в масива.
				int[] result = new int[4];
				result = toArray(numGamer);
				// Проверяваме дали играча не е въвел повтарящи се числа.
				if (!wrongNumber(result)) {
					return 0;
				} else {
					return 3;
				}
			} else {
				return 2;
			}
		} else {
			return 1;
		}
	}

	public static int[] toArray(String s) {
		int[] result = new int[s.length()];
		for (int i = 0; i < result.length; i++) {
			result[i] = Integer.parseInt("" + s.charAt(i));
		}
		return result;
	}

	public static boolean isDigits(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) < '0' || s.charAt(i) > '9') {
				return false;
			}
		}
		return true;
	}

	public static int numBulls(int[] num, int[] numGamer) {
		int result = 0;

		for (int i = 0; i < num.length; i++) {
			if (num[i] == numGamer[i]) {
				result++;

			}

		}

		return result;
	}

	public static int numCows(int[] num, int[] numGamer) {
		int result = 0;

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (num[i] == numGamer[j] && i != j) {
					result++;

				}

			}

		}

		return result;
	}
}
