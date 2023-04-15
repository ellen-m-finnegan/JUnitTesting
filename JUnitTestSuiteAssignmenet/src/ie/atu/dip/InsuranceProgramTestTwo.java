/*
 * Name: Ellen Finnegan
 * Student Number:G00398778
 */

package ie.atu.dip;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.concurrent.TimeUnit;

class InsuranceProgramTestTwo {
	public static InsuranceProgram insuranceProgram;

	@BeforeAll
	public static void initialMessage() {
		insuranceProgram = new InsuranceProgram();
	}

	@BeforeEach
	public void startUpMessage() {
		insuranceProgram = new InsuranceProgram();
	}

	@AfterEach
	public void singleTestCompletedMessage() {
		System.out.println("This test has completed.");
	}

	@AfterAll
	public static void finalMessage() {
		System.out.println("InsuranceProgramTests are complete.");
	}

	@ParameterizedTest
	@CsvSource({ "0, 0", "50, 1", "125, 2", "225, 3", "375, 4", "575, 5", "800, 6" })
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	public void generateAccidentSurchargeTest(int expectedResult, int accidents) {
		System.out.println("generateAccidentSurchargeTest() has begun.");
		assertEquals(expectedResult, insuranceProgram.generateAccidentSurcharge(accidents));
	}

	@ParameterizedTest
	@CsvSource({ "825, 23, 3", "1175, 17, 5", "550, 32, 1", "725, 26, 3", "875, 56, 4" })
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	public void generateTotalCostTest(int expectedResult, int age, int accidents) {
		System.out.println("generateTotalCostTest() has begun");
		assertEquals(expectedResult, insuranceProgram.generateTotalCost(age, accidents));
	}
	
	@ParameterizedTest
	@CsvSource({ "0, 25", "100, 17", "0, 50", "100, 24", "0, 26" })
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	public void generateAgeSurchargeTest(int expectedResult, int age) {
		System.out.println("generateAgeSurchargeTest() has begun");
		assertEquals(expectedResult, insuranceProgram.generateAgeSurcharge(age));
	}

}
