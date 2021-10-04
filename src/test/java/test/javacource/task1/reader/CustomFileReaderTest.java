package test.javacource.task1.reader;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.javacource.task1.exception.CustomException;
import by.javacource.task1.reader.CustomFileReader;
import by.javacource.task1.reader.impl.CustomFileReaderImpl;

public class CustomFileReaderTest {

	private CustomFileReader reader;

	@BeforeMethod
	public void initialize() {
		reader = new CustomFileReaderImpl();
	}

	@Test
	public void testRead() throws CustomException {
		String actual = reader.read("src\\test\\resources\\testdata\\correctArrays.txt");
		String expected = "1;-3;6;10;-5;2;";
		Assert.assertEquals(actual, expected);
	}

	@Test(expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp = ".*was not found.*")
	public void testReadExceptionFileNotFound() throws CustomException {
		reader.read("src\\test\\resources\\testdata\\notFountArrays.txt");
	}

	@Test(expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp = ".*does not containe correct data.*")
	public void testReadExceptionNotCorrectData() throws CustomException {
		reader.read("src\\test\\resources\\testdata\\notCorrectArrays.txt");
	}

	@AfterMethod
	public void clean() {
		reader = null;
	}

}
