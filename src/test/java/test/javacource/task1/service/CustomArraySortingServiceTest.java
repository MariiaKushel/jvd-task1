package test.javacource.task1.service;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.javacource.task1.entity.CustomArray;
import by.javacource.task1.service.CustomArraySortingService;
import by.javacource.task1.service.impl.CustomArraySortingServiceImpl;

public class CustomArraySortingServiceTest {
	
	private CustomArraySortingService service;
	
	@BeforeMethod
	public void initialize() {
		service = new CustomArraySortingServiceImpl();
	}
	
	@DataProvider(name = "providerArraySorting")
	public Object[][] createData() {
		return new Object[][] { 
			{ new CustomArray(1, 8, 0, 2, 13, 3, 5), new CustomArray(0, 1, 2, 3, 5, 8, 13) },
			{ new CustomArray(-1, -8, 0, -2, -13, -3), new CustomArray(-13, -8, -3, -2, -1, 0) },
			{ new CustomArray(1, 0, 0, 0), new CustomArray(0, 0, 0, 1) }, };
	}
	
	@Test(dataProvider = "providerArraySorting")
	public void testsortStream(CustomArray actual, CustomArray expected) {
		service.sortStream(actual);
		Assert.assertEquals(actual, expected);
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
