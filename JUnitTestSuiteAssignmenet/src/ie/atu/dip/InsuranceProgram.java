/*
 * Name: Ellen Finnegan
 * Student Number:G00398778
 */



package ie.atu.dip;

import java.util.Scanner;

public class InsuranceProgram {

	private static final int basicInsurance = 500;
	private int ageSurcharge;
	private int accidentSurcharge;
	private int totalCost;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.print("Enter your age: ");
		int age = input.nextInt();
		
		
		// Checks inputs, sends error message for age < 17 and for accidents > 6
		if (age < 17) {
			System.out.println("You are too young to drive in Ireland. We cannot provide you with insurance.");
		} else {
			System.out.println("How many accidents have you had in the past 10 years?");
			int accidents = input.nextInt();
			if (accidents > 6) {
				System.out.println("Sorry, you have had too many accidents for us to provide you with insurance.");
			} else {
				System.out.println("Basic Insurance: €" + new InsuranceProgram().getBaseRate());
				System.out.println("Surcharge: €" + new InsuranceProgram().generateAgeSurcharge(age));
				System.out.println(
						"Accident(s) Surcharge: €" + new InsuranceProgram().generateAccidentSurcharge(accidents));
				System.out.println("Total Cost : €" + new InsuranceProgram().generateTotalCost(age, accidents));
			}
		}
		input.close();
	}

	public int getBaseRate() {
		return basicInsurance;
	}
	
	// Calculates Surcharge for people < 25
	protected int generateAgeSurcharge(int age) {
		if (age < 25 && age >= 17) {
			ageSurcharge = 100;
		} else {
			ageSurcharge = 0;
		}
		return ageSurcharge;
	}
	
	// Calculates surcharge based on no. of accidents
	protected int generateAccidentSurcharge(int accidents) {
		switch (accidents) {
		case 0:
			accidentSurcharge = 0;
			break;
		case 1:
			accidentSurcharge = 50;
			break;
		case 2:
			accidentSurcharge = 125;
			break;
		case 3:
			accidentSurcharge = 225;
			break;
		case 4:
			accidentSurcharge = 375;
			break;
		case 5:
			accidentSurcharge = 575;
			break;
		case 6:
			accidentSurcharge = 800;
			break;
		default:
			accidentSurcharge = 0;
		}
		return accidentSurcharge;
	}
	
	// Calculates total cost of insurance
	protected int generateTotalCost(int age, int accidents) {
		if (age < 25 && age >=17) {
			ageSurcharge = generateAgeSurcharge(age);
			accidentSurcharge = generateAccidentSurcharge(accidents);
			totalCost = basicInsurance + ageSurcharge + accidentSurcharge;
		} else {
			accidentSurcharge = generateAccidentSurcharge(accidents);
			totalCost = basicInsurance + accidentSurcharge;
		}
		return totalCost;
	}
}