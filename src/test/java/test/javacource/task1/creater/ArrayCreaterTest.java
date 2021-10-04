package test.javacource.task1.creater;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import by.javacource.task1.creater.ArrayCreater;
import by.javacource.task1.creater.impl.ArrayCreaterImpl;
import by.javacource.task1.entity.CustomArray;

public class ArrayCreaterTest {

	private ArrayCreater creater;

	@BeforeTest
	public void initialize() {
		creater = new ArrayCreaterImpl();
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
