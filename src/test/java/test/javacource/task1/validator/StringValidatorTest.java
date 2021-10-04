package test.javacource.task1.validator;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import by.javacource.task1.validator.StringValidator;

public class StringValidatorTest {

	private static StringValidator validator = StringValidator.getInstance();

	@DataProvider(name = "providerStringValidation")
	public static Object[][] createData() {
		return new Object[][] { 
			{ "1;-2;3;-8;0;", true }, 
			{ "1;8;-3.2;1;", false }, 
			{ "1;-2147483699;8;", false } };
	}

	@Test(dataProvider = "providerStringValidation")
	public static void validateTest(String line, boolean expected) {
		boolean actual = validator.validate(line);
		Assert.assertEquals(actual, expected);
	}

}
