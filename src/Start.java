package main;

import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Random;

public class Start {
	public static void main(String[] args) {
		
		DecimalFormat numberFormat = new DecimalFormat("#.00");
		Random rng = new Random();
		int[] baseRNG = {0, 1, 2};
		int fastFoods = 0;
		int atHomes = 0;
		double[] fastFoodPrices = {3.99, 4.99, 6.99};
		double[] atHomePrices = {4.99, 8.99, 12.99};
		int people; 
		int salary; 
		int days = 7; 
		int priceChoosen;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Hello, and welcome to what I like to call the Food Bar Adventure. \nThis tool is designed to measure approximately how much money you would need to make by eating a certain pattern of at home cooking and fast food every week. \nTo begin, type 'play'. To exit, type 'exit'");
		String playOrLoad = input.nextLine();
		
		if (playOrLoad.equals("play")) {
			
			System.out.println("Enter the number of people you need to feed (INT): ");
			people = input.nextInt();
			
			System.out.println("Enter your yearly salary, or a number to simulate (INT): ");
			salary = input.nextInt();
			int weekly = (salary/people)/52;
			double current = (weekly*0.30);
			
			System.out.println("You have " + numberFormat.format(current) + " dollars to spend per person this week, good luck");
			
			while (days > 0) {
				if (days == 1) {System.out.println("1 day left");} else {System.out.println(days + " days left");}
				
				if (current < 0) {
					System.out.println("Sorry! You ran out of money");
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.exit(0);
				}
				
				System.out.println("$" + numberFormat.format(current) + " left per person. Enter 'fast food' for fast food and 'at home' for at home cooking");
				String choice = input.nextLine();
				
				if (choice.equals("fast food")) {
					
					priceChoosen = rng.nextInt(fastFoodPrices.length);
					double price = fastFoodPrices[priceChoosen];
					
					if (rng.nextInt(baseRNG.length) == 2) {
						System.out.println("Your price is decreased because of a meal deal");
						price = price/1.2;
					}
					
					price = price*3;
					
					System.out.println("You pay $" + numberFormat.format(price) + " for 3 meals");
					current = current - price;
					
					days--;
					fastFoods++;
				}
				if (choice.equals("at home")) {
					
					priceChoosen = rng.nextInt(fastFoodPrices.length);
					double price = atHomePrices[priceChoosen];
					
					if (rng.nextInt(baseRNG.length) == 2) {
						System.out.println("Your price is increased because your fresh food has low availability");
						price = price*1.5;
					}
					
					price = price*3;
					
					System.out.println("You pay $" + numberFormat.format(price) + " for 3 meals");
					current = current - price;
					
					days--;
					atHomes++;
				}
			
			}
			
			if (days == 0) {System.out.println("Congratulations, you made it with $" + numberFormat.format(current) + " left. You had " + fastFoods + " day(s) of fast food meals and " + atHomes + " day(s) of home cooking");}
			
		} else if (playOrLoad.equals("exit")) {
			
			System.exit(0);
			
		} else {
			
			System.out.println("Invalid input, please restart the program and try again");
		}
	}
	
	
	
}
