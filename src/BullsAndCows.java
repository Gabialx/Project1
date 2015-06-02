import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * 1. ����� � ������ - ����, � ����� ���������� ������ �� ������ ���������
 * �����. ����� �� �� ������� �����: - ��������� ������� �����; - ������ �������
 * �����; - ��������� ������� ����� ����� � ���� ��� � �������; - ������ �������
 * ���� �����; - ��������� ������� ����� ����� � ���� ��� � �����; - ����� ��
 * ������ ������ �� ������ �������. ������� ��� �����, ��� ��� ���������� ��
 * ���� ����� ��� �����, ����� � ��� � �����������. ������� ��� ���, ��� ���
 * ���������� �� ���� ����� ��� �����, ����� � ��� � ����������� � ���� ����� �
 * �� ������ ������� � ����� �����. �����������: ����������� ����� ������ �� �
 * �������������, � �������� �����. ������ �� ����: - ��������� ����� 8456; -
 * �������� ����������� 4231; - �� ������ �� �������: 1 �����; - ��������
 * ������������� 4512; - �� ������ �� ��������: 2 �����; - ��������
 * ������������� 5421; - �� ������ �� �������: 1 �����, 1 ��� - � �.�.
 */
public class BullsAndCows {

	public static void main(String[] args) {
		System.out
				.println("�������, ����� �� �������� ������ � �����. \n����� ����� �: \n****");
		int[] numComputer = numComputer();
		// print(num);
		System.out.println("�� ��, ������ ��!");
		int[] numGamer;
		do {
			numGamer = numGamer();
			// print(numGamer);
			int bulls = numBulls(numComputer, numGamer);
			int cows = numCows(numComputer, numGamer);
			System.out.println("������: " + bulls);
			System.out.println("�����: " + cows);
		} while (different(numComputer, numGamer));
		System.out.println("�������! ����������.");

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
						.println("�� ��� ������ ������������� �����. ����, �������� �������� �����:");
				break;
			case 2:
				System.out
						.println("������ ��� � ����� ������� ����� �����. ����, �������� �������� �����:");
				break;
			case 3:
				System.out
						.println("������ ��� ����� � ��������� �� �����. ����, �������� �������� �����:");
				break;
			}
		} while (errorCode != 0);
		return result;
	}

	public static int validateNumGamer(String numGamer) {
		// ����������� ���� ������� � ����� 4 �������.
		if (numGamer != null && numGamer.length() == 4) {
			// ����������� ���� ������ � ����� ���� �����.
			if (isDigits(numGamer)) {
				// ����������� ��������� �� ������ � ������.
				int[] result = new int[4];
				result = toArray(numGamer);
				// ����������� ���� ������ �� � ����� ��������� �� �����.
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
