package test.javacource.task1.service;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.javacource.task1.entity.CustomArray;
import by.javacource.task1.exception.CustomException;
import by.javacource.task1.service.CustomArrayActionService;
import by.javacource.task1.service.impl.CustomArrayActionServiceImpl;

public class CustomArrayActionServiceTest {

	private CustomArrayActionService service;

	@BeforeMethod
	public void initialize() {
		service = new CustomArrayActionServiceImpl();
	}

	@Test
	public void testFindMaxValue() {
		int actual = service.findMaxValue(new CustomArray(-300, -4, 0, -1));
		int expected = 0;
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testFindMaxValueStream() {
		int actual = service.findMaxValueStream(new CustomArray(-10, -4, -3, -12));
		int expected = -3;
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testFindMinValue() {
		int actual = service.findMinValue(new CustomArray(2, -4, 0, 12));
		int expected = -4;
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testFindMinValueStream() {
		int actual = service.findMinValueStream(new CustomArray(-2, -4, 0, -12));
		int expected = -12;
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testFindMidValue() {
		double actual = service.findMidValueStream(new CustomArray(2, -4, 2147483647, 2147483647));
		double expected = 1073741823;
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testFindMidValueStream() {
		double actual = service.findMidValueStream(new CustomArray(2, -4, 2147483647, 2147483647));
		double expected = 1073741823;
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testCountSumOfElements() throws CustomException {
		int actual = service.countSumOfElements(new CustomArray(2, -4, 0, 12));
		int expected = 10;
		Assert.assertEquals(actual, expected);
	}

	@Test(expectedExceptions = CustomException.class)
	public void testCountSumOfElementsException() throws CustomException {
		service.countSumOfElements(new CustomArray(2, -4, 2147483647, 2147483647));
	}

	@Test
	public void testCountSumOfElementsStream() throws CustomException {
		int actual = service.countSumOfElementsStream(new CustomArray(0, 100, 1, 10));
		int expected = 111;
		Assert.assertEquals(actual, expected);
	}

	@Test(expectedExceptions = CustomException.class)
	public void testCountSumOfElementsStreamException() throws CustomException {
		service.countSumOfElements(new CustomArray(2, -4, 2147483647, 2147483647));
	}

	@Test
	public void testCountPositiveElements() {
		int actual = service.countPositiveElements(new CustomArray(2, -4, 0, 12, 0));
		int expected = 2;
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testCountPositiveElementsStream() {
		int actual = service.countPositiveElementsStream(new CustomArray(-2, -4, 0, -12));
		int expected = 0;
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testCountNegativeElements() {
		int actual = service.countNegativeElements(new CustomArray(2, -4, 0, 12));
		int expected = 1;
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void testCountNegativeElementsStream() {
		int actual = service.countNegativeElementsStream(new CustomArray(2, 4, 0, 12));
		int expected = 0;
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testChangeElementsBelowMiddle() {
		CustomArray actual = new CustomArray(2, -4, 0, 12);
		service.changeElementsBelowMiddle(actual, 999);
		CustomArray expected = new CustomArray(2, 999, 999, 12);
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testChangeElementsBelowMiddleStream() {
		CustomArray actual = new CustomArray(3, -4, 0, 11);
		service.changeElementsBelowMiddleStream(actual, 999);
		CustomArray expected = new CustomArray(3, 999, 999, 11);
		Assert.assertEquals(actual, expected);
	}

}
