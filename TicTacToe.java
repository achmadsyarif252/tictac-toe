package tictactoe;

import java.util.Scanner;
import java.util.Arrays;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int xs;
	static int os;
    public static void main(String[] args) {
		stage2();
    }
		static void stage2() {
//		System.out.print("Enter cells: ");
		String[] input = new String[9];

		System.out.println("---------");
		for (int i = 0; i < (9); i++) {
			input[i] = " ";
			if (i == 0 || i == 3 || i == 6) {
				System.out.print("| ");

			}
			System.out.print(input[i] + " ");
			if (i == 2 || i == 5 || i == 8) {
				System.out.println("|");
			}
		}

		System.out.println("---------");

		boolean isX = true;
		boolean isWin = false;
		while (isWin == false) {
			boolean isValid = false;

			boolean isOccupied = false;
			while (isValid == false) {
				System.out.println("\nEnter the coordinates: ");
				String coordinate[] = scanner.nextLine().split(" ");

				try {
					if (Integer.parseInt(coordinate[0]) > 3 || Integer.parseInt(coordinate[0]) < 1
							|| Integer.parseInt(coordinate[1]) > 3 || Integer.parseInt(coordinate[1]) < 1) {
						System.out.println("Coordinates should be from 1 to 3!");
					} else {
						for (int i = 0; i < 3; i++) {
							if (coordinate[0].equals("1") && coordinate[1].equals(String.valueOf(i + 1))) {
								if (!input[i].equals(" ")) {
									System.out.println("This cell is occupied! Choose another one!");
									isOccupied = true;
								} else {
									if (isX == true) {
										input[i] = "X";
										isX = false;
									} else {
										input[i] = "O";
										isX = true;
									}
									isOccupied = false;
									isValid = true;
								}

							}

							if (coordinate[0].equals("2") && coordinate[1].equals(String.valueOf(i + 1))) {
								if (!input[i + 3].equals(" ")) {
									System.out.println("This cell is occupied! Choose another one!");
									isOccupied = true;
								} else {
									if (isX == true) {
										input[i + 3] = "X";
										isX = false;
									} else {
										input[i + 3] = "O";
										isX = true;
									}
									isOccupied = false;
									isValid = true;
								}

							}

							if (coordinate[0].equals("3") && coordinate[1].equals(String.valueOf(i + 1))) {
								if (!input[i + 6].equals(" ")) {
									System.out.println("This cell is occupied! Choose another one!");
									isOccupied = true;
								} else {
									if (isX == true) {
										input[i + 6] = "X";
										isX = false;
									} else {
										input[i + 6] = "O";
										isX = true;
									}
									isOccupied = false;
									isValid = true;
								}

							}

						}
					}
				} catch (Exception e) {
					System.out.println("You should enter numbers!");
				}

			}

			if (isOccupied == false) {
				System.out.println("---------");
				for (int i = 0; i < (input.length > 9 ? 9 : input.length); i++) {
					if (i == 0 || i == 3 || i == 6) {
						System.out.print("| ");

					}
					System.out.print(input[i] + " ");
					if (i == 2 || i == 5 || i == 8) {
						System.out.println("|");
					}
				}
				System.out.println("---------");
			}

			int x = countChar(Arrays.toString(input), 'X');
			int o = countChar(Arrays.toString(input), 'O');

//			if (isXInARow(input, "X") && isXInARow(input, "O") || (xs - os > 1 || os - xs > 1)) {
//				System.out.println("Impossible");
//			} else if (IsHaveEmptySpace(input)
//					&& (isXInARow(input, "X") == false && (isXInARow(input, "O") == false))) {
//				System.out.println("Game not finished");
//			} 
			if (x >= 264 && isXInARow(input, "X") && (isXInARow(input, "O") == false)) {
				System.out.println("X wins");
				isWin = true;
			} else if (o >= 237 && isXInARow(input, "O") && (isXInARow(input, "X") == false)) {
				System.out.println("O wins");
				isWin = true;
			} else if (!(isXInARow(input, "X")) && !(isXInARow(input, "O")) && (xs + os == 9)) {
				System.out.println("Draw");
				isWin = true;
			}
		}
	}

	static boolean IsHaveEmptySpace(String[] input) {
		for (int i = 0; i < 9; i++) {
			if (input[i].equals("_")) {
				return true;
			}
		}
		return false;
	}

	static int countChar(String c, char cari) {
		int chartTotal = 0;
		for (int i = 0; i < c.length(); i++) {
			if (c.charAt(i) == cari) {
				chartTotal += c.charAt(i);
				if (cari == 'X') {
					xs++;
				} else if (cari == 'O') {
					os++;
				}
			}
		}
		return chartTotal;
	}

	static boolean isXInARow(String[] string, String cari) {
		int x = 0;
		if ((string[0].equals(cari) && string[1].equals(cari) && string[2].equals(cari))
				|| (string[3].equals(cari) && string[4].equals(cari) && string[5].equals(cari))
				|| (string[6].equals(cari) && string[7].equals(cari) && string[8].equals(cari))
				|| (string[0].equals(cari) && string[3].equals(cari) && string[6].equals(cari))
				|| (string[1].equals(cari) && string[4].equals(cari) && string[7].equals(cari))
				|| (string[2].equals(cari) && string[5].equals(cari) && string[8].equals(cari))
				|| (string[0].equals(cari) && string[4].equals(cari) && string[8].equals(cari))
				|| (string[2].equals(cari) && string[4].equals(cari) && string[6].equals(cari))) {
			return true;
		}
		return false;
	}
}
