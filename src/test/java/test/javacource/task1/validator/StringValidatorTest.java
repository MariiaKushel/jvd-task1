package test.javacource.task1.validator;

import org.testng.annotations.Test;

import by.javacource.task1.validator.StringValidator;
import by.javacource.task1.validator.impl.StringValidatorImpl;

import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class StringValidatorTest {

	private static  StringValidator validator = StringValidatorImpl.getInstance();

	@DataProvider(name = "providerStringValidation")
	public static Object[][] createData() {
		return new Object[][] { 
			{ "1;-2;3;-8;0;", true }, 
			{ "1;8;-3.2;1;", false }, 
			{ "7;2;-3A;1;", false },
			{ "1;-3000000000;8;", false },
			{ "3;11111111111111111111111111111111111;8;8;", false }};
	}

	@Test(dataProvider = "providerStringValidation")
	public static void validateTest(String line, boolean expected) {
		boolean actual = validator.validate(line);
		Assert.assertEquals(actual, expected);
	}

}
