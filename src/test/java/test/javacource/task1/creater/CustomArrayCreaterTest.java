package test.javacource.task1.creater;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import by.javacource.task1.creater.CustomArrayCreater;
import by.javacource.task1.creater.impl.CustomArrayCreaterImpl;
import by.javacource.task1.entity.CustomArray;

public class CustomArrayCreaterTest {

	private CustomArrayCreater creater;

	@BeforeTest
	public void initialize() {
		creater = new CustomArrayCreaterImpl();
	}

	@Test
	public void testCreate() {
		CustomArray actual = creater.create(1, 5, -6, 13);
		CustomArray expected = new CustomArray(1, 5, -6, 13);
		Assert.assertEquals(actual, expected);
	}

	@AfterTest
	public void clean() {
		creater = null;
	}
}
