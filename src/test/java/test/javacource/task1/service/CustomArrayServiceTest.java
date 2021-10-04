package test.javacource.task1.service;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.javacource.task1.entity.CustomArray;
import by.javacource.task1.exception.CustomException;
import by.javacource.task1.service.CustomArrayService;
import by.javacource.task1.service.impl.CustomArrayServiceImpl;

public class CustomArrayServiceTest {

	private CustomArrayService service;

	@BeforeMethod
	public void initialize() {
		service = new CustomArrayServiceImpl();
	}

	@Test
	public void testFindMaxValue() {
		int actual = service.findMaxValue(new CustomArray(2, -4, 0, 12));
		int expectedMax = 12;
		Assert.assertEquals(actual, expectedMax);
	}
	
	@Test
	public void testFindMaxValueStream() {
		int actual = service.findMaxValueStream(new CustomArray(-10, -4, -3, -12));
		int expectedMax = -3;
		Assert.assertEquals(actual, expectedMax);
	}

	@Test
	public void testFindMinValue() {
		int actual = service.findMinValue(new CustomArray(2, -4, 0, 12));
		int expectedMin = -4;
		Assert.assertEquals(actual, expectedMin);
	}
	
	@Test
	public void testFindMinValueStream() {
		int actual = service.findMinValueStream(new CustomArray(-2, -4, 0, -12));
		int expectedMin = -12;
		Assert.assertEquals(actual, expectedMin);
	}

	@Test
	public void testFindMidValue() {
		double actual = service.findMidValueStream(new CustomArray(2, -4, 2147483647, 2147483647));
		double expectedMid = 1073741823;
		Assert.assertEquals(actual, expectedMid);
	}

	@Test
	public void testFindMidValueStream(){
		double actual = service.findMidValueStream(new CustomArray(2, -4, 2147483647, 2147483647));
		double expectedMid = 1073741823;
		Assert.assertEquals(actual, expectedMid);
	}
	
	@Test
	public void testCountSumOfElements() throws CustomException {
		int actual = service.countSumOfElements(new CustomArray(2, -4, 0, 12));
		int expectedSum = 10;
		Assert.assertEquals(actual, expectedSum);
	}

	@Test(expectedExceptions = CustomException.class)
	public void testCountSumOfElementsException() throws CustomException {
		service.countSumOfElements(new CustomArray(2, -4, 2147483647, 2147483647));
	}
	
	@Test
	public void testCountSumOfElementsStream() throws CustomException{
		int actual = service.countSumOfElementsStream(new CustomArray(0, 100, 1, 10));
		int expectedSum = 111;
		Assert.assertEquals(actual, expectedSum);
	}

	@Test(expectedExceptions = CustomException.class)
	public void testCountSumOfElementsStreamException() throws CustomException {
		service.countSumOfElements(new CustomArray(2, -4, 2147483647, 2147483647));
	}
	
	@Test
	public void testCountPositiveElements() {
		int actual = service.countPositiveElements(new CustomArray(2, -4, 0, 12));
		int expectedPositive = 2;
		Assert.assertEquals(actual, expectedPositive);
	}
	
	@Test
	public void testCountPositiveElementsStream() {
		int actual = service.countPositiveElementsStream(new CustomArray(2, -4, 0, 12));
		int expectedPositive = 0;
		Assert.assertEquals(actual, expectedPositive);
	}

	@Test
	public void testCountNegativeElements() {
		int actual = service.countNegativeElements(new CustomArray(2, -4, 0, 12));
		int expectedNegative = 1;
		Assert.assertEquals(actual, expectedNegative);
	}

	@Test
	public void tesrChangeElementsBelowMiddle() {
		CustomArray actual = new CustomArray(2, -4, 0, 12);
		service.changeElementsBelowMiddle(actual, 999);
		CustomArray expectedArrAfterChange = new CustomArray(2, 999, 999, 12);
		Assert.assertEquals(actual, expectedArrAfterChange);
	}

	@Test
	public void tesrChangeElementsBelowMiddleStream() {
		CustomArray actual = new CustomArray(3, -4, 0, 11);
		service.changeElementsBelowMiddleStream(actual, 999);
		CustomArray expected = new CustomArray(3, 999, 999, 11);
		Assert.assertEquals(actual, expected);
	}
	
	@DataProvider(name = "providerArraySorting")
	public Object[][] createData() {
		return new Object[][] { 
			{ new CustomArray(1, 8, 0, 2, 13, 3, 5), new CustomArray(0, 1, 2, 3, 5, 8, 13) },
			{ new CustomArray(-1, -8, 0, -2, -13, -3), new CustomArray(-13, -8, -3, -2, -1, 0) },
			{ new CustomArray(0, 0, 0, 0), new CustomArray(0, 0, 0, 0) }, };
	}

	@Test(dataProvider = "providerArraySorting")
	public void testBubbleSort(CustomArray actual, CustomArray expected) {
		service.bubbleSort(actual);
		Assert.assertEquals(actual, expected);
	}

	@Test(dataProvider = "providerArraySorting")
	public void testSelectionSort(CustomArray actual, CustomArray expected) {
		service.selectionSort(actual);
		Assert.assertEquals(actual, expected);
	}
	
	@Test(dataProvider = "providerArraySorting")
	public void testInsertionSort(CustomArray actual, CustomArray expected) {
		service.insertionSort(actual);
		Assert.assertEquals(actual, expected);
	}
	
	@Test(dataProvider = "providerArraySorting")
	public void testShellSort(CustomArray actual, CustomArray expected) {
		service.shellSort(actual);
		Assert.assertEquals(actual, expected);
	}
		
	@AfterMethod
	public void clean() {
		service = null;
	}
}
