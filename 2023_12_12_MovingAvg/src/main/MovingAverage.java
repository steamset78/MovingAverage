package main;
import java.util.ArrayList;
import java.util.Scanner;

public class MovingAverage {

	protected void movingAvg(int x) {
		int counter = 1;
		int number = 0;
		int indexToDelete = 0;
		ArrayList<Integer> numbersList = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			try {
				System.out.print("Enter an integer (type 'exit' to quit): ");
				String input = scanner.next();
				if ("exit".equalsIgnoreCase(input)) {
					scanner.close();
					break;
				}
				number = Integer.parseInt(input);
				numbersList.add(number);
			} catch (java.lang.NumberFormatException e) {
				System.out.println("Invalid number format. Please enter a valid integer.");
				if (counter > 1) {
					counter--;
					indexToDelete--;
				}
			}
			if (counter % x == 0) {
				int elementsToSum = Math.min(number, numbersList.size() - 1);
				double totalSum = 0;
				int startIndex = numbersList.size() - 1 - elementsToSum;
				if (number > elementsToSum)
					startIndex = 0;
				for (int i = startIndex; i < startIndex + elementsToSum; i++) {
					totalSum += numbersList.get(i);
				}
				numbersList.remove(indexToDelete);
				indexToDelete--;
				double average = totalSum / number;
				System.out.println("Average is: " + average);
			}
			counter++;
			indexToDelete++;
		}
	}
}
