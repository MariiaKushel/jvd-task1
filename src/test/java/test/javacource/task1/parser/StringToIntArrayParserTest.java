package test.javacource.task1.parser;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.javacource.task1.parser.StringToIntArrayParser;
import by.javacource.task1.parser.impl.StringToIntArrayParserImpl;

public class StringToIntArrayParserTest {

	private StringToIntArrayParser parser;

	@BeforeMethod
	public void initialize() {
		parser = new StringToIntArrayParserImpl();
	}

	@DataProvider(name = "providerParsing")
	public Object[][] createDataParse() {
		return new Object[][] { 
			{ "5;", new int[] { 5 } }, 
			{ "8;-3;00011;6;", new int[] { 8, -3, 11, 6 } },
			{ "-09;0;17;-324;", new int[] { -9, 0, 17, -324 } } };
	}

	@Test(dataProvider = "providerParsing")
	public void testParse(String str, int[] expected) {
		int[] actual = parser.parse(str);
		Assert.assertEquals(actual, expected);
	}

	@AfterMethod
	public void clean() {
		parser = null;
	}

}
