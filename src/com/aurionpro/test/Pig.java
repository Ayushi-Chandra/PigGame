package com.aurionpro.test;

import java.util.Scanner;

public class Pig {
	public static void main(String[] args) {
		int totalScore = 0, turnCount = 1;

		Scanner sc = new Scanner(System.in);
		String choice;

		while (totalScore < 20) {
			System.out.println("TURN " + turnCount);
			System.out.print("Roll or hold? (r/h): ");
			choice = sc.nextLine();
			
			int turnScore = 0;

			if (choice.equals("r")) {
				int die = rollDie();
				System.out.println("Die: " + die);

				if (die == 1) {
					System.out.println("Turn over. No score.");
				} else {
					turnScore += die;
					while (true) {
						System.out.print("Roll or hold? (r/h): ");
						choice = sc.nextLine();
						if (choice.equals("r")) {
							die = rollDie();
							System.out.println("Die: " + die);

							if (die == 1) {
								System.out.println("Turn over. No score.");
								break;
							} else {
								turnScore += die;
								if (totalScore + turnScore >= 20) {
									System.out.println("Score for turn: " + turnScore);
									totalScore += turnScore;
									break;
								}
							}
						} else if (choice.equals("h")) {
							System.out.println("Score for turn: " + turnScore);
							totalScore += turnScore;
							break;
						} else {
							System.out.println("Invalid choice. Please enter 'r' or 'h'.");
						}
					}
				}
			} else if (choice.equals("h")) {
				System.out.println("Score for turn: " + turnScore);
				totalScore += turnScore;
			} else {
				System.out.println("Invalid choice.");
			}

			System.out.println("Total score: " + totalScore + "\n");
			turnCount++;
		}

		System.out.println("You finished in " + (turnCount - 1) + " turns!");
		System.out.println("Game over!");
	}

	private static int rollDie() {
		return (int) (Math.random() * 6) + 1;
	}
}