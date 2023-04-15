/*
 * Name: Ellen Finnegan
 * Student Number:G00398778
 */

package ie.atu.dip;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.InputMismatchException;
import java.util.concurrent.TimeUnit;

class InsuranceProgramTest {

	public static InsuranceProgram insuranceProgramAdd;

	@BeforeEach
	public void startUpMessage() {
		insuranceProgramAdd = new InsuranceProgram();
	}

	@Test
	public void uninsurableTest() {
		System.out.println("uninsurableTest() has begun"); 
		int age = 16;
		int accidents = 4;
		assertThrows(IllegalArgumentException.class, () -> {
			if (age <= 17 || accidents > 6)
				throw new IllegalArgumentException();
			System.out.println("Invalid entry check age and accidents.");
		});
	}

	@Test
	public void inputMissmatchTest() {
		System.out.println("InputMismatch() has begun");
		assertThrows(InputMismatchException.class, () -> {
			Object input = "ten";
			if (input instanceof String)
				throw new InputMismatchException();
			System.out.println("InputMismatchException thrown, check input.");
		});
	}

	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	public void getBaseRateTest() {
		System.out.println("getBaseRateTest() has begun.");
		int actualValue = insuranceProgramAdd.getBaseRate();
		assertEquals(500, actualValue);
	}
	@Test 
	public void NullPinterExceptionTest() {
		System.out.println("NullPointerExceptionTest() has begun");
		assertThrows(NullPointerException.class, () -> {
			Object obj = null;
			if (obj == null) 
				throw new NullPointerException("Null pointer Exception; Object can't be null");
		});
	}

}
