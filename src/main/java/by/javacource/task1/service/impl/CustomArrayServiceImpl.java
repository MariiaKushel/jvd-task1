package by.javacource.task1.service.impl;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.javacource.task1.entity.CustomArray;
import by.javacource.task1.exception.CustomException;
import by.javacource.task1.service.CustomArrayService;

public class CustomArrayServiceImpl implements CustomArrayService {

	static Logger logger = LogManager.getLogger();

	@Override
	public int findMaxValue(CustomArray arr) {

		int[] currentArray = arr.getArray();

		int max = currentArray[0];

		for (int i = 1; i < currentArray.length; i++) {

			if (max < currentArray[i]) {
				max = currentArray[i];
			}
		}

		return max;
	}

	@Override
	public int findMaxValueStream(CustomArray arr) {

		return IntStream.of(arr.getArray()).max().getAsInt();
	}

	@Override
	public int findMinValue(CustomArray arr) {

		int[] currentArray = arr.getArray();

		int min = currentArray[0];

		for (int i = 1; i < currentArray.length; i++) {

			if (min > currentArray[i]) {
				min = currentArray[i];
			}
		}

		return min;
	}

	@Override
	public int findMinValueStream(CustomArray arr) {

		return IntStream.of(arr.getArray()).min().getAsInt();
	}

	@Override
	public double findMidValue(CustomArray arr) {

		int[] currentArray = arr.getArray();
		long sum = 0L;

		for (int elem : currentArray) {
			sum = sum + elem;
		}

		double mid;
		mid = sum / currentArray.length;

		return mid;

	}

	@Override
	public double findMidValueStream(CustomArray arr) {

		return IntStream.of(arr.getArray()).average().getAsDouble();
	}

	@Override
	public int countSumOfElements(CustomArray arr) throws CustomException {

		int[] currentArray = arr.getArray();

		int sum = 0;

		for (int element : currentArray) {

			int delta;

			if (sum >= 0) {
				delta = Integer.MAX_VALUE - sum;
			} else {
				delta = Integer.MIN_VALUE - sum;
			}

			if ((delta > 0 && delta > element) || (delta < 0 && delta < element)) {
				sum = sum + element;
			} else {
				logger.error("Int overflow");
				throw new CustomException("Int overflow");
			}
		}

		return sum;
	}

	@Override
	public int countSumOfElementsStream(CustomArray arr) throws CustomException {

		int[] currentArrayInt = arr.getArray();
				
		long sumLong = IntStream.of(arr.getArray()).asLongStream().sum();
		
		int sumInt;
		
		if (sumLong < Integer.MAX_VALUE && sumLong > Integer.MIN_VALUE) {
			sumInt = (int) sumLong;
		}else {
			logger.error("Int overflow");
			throw new CustomException("Int overflow");
		}

		return sumInt;
	}

	@Override
	public int countPositiveElements(CustomArray arr) {

		int[] currentArray = arr.getArray();

		int amountPositiveElements = 0;

		for (int element : currentArray) {
			if (element > 0) {
				amountPositiveElements++;
			}
		}

		return amountPositiveElements;
	}

	@Override
	public int countPositiveElementsStream(CustomArray arr) {

		int amtPositiveElements = (int) IntStream.of(arr.getArray()).filter(e -> e > 0).count();
		return amtPositiveElements;
	}

	@Override
	public int countNegativeElements(CustomArray arr) {

		int[] currentArray = arr.getArray();

		int amountNegativeElements = 0;

		for (int element : currentArray) {
			if (element < 0) {
				amountNegativeElements++;
			}
		}

		return amountNegativeElements;
	}

	@Override
	public int countNegativeElementsStream(CustomArray arr) {

		int amtNegativeElements = (int) IntStream.of(arr.getArray()).filter(e -> e < 0).count();
		return amtNegativeElements;
	}

	@Override
	public void changeElementsBelowMiddle(CustomArray arr, int newValue) {

		double mid;
		mid = findMidValue(arr);

		int[] currentArray = arr.getArray();

		for (int i = 0; i < currentArray.length; i++) {
			if (currentArray[i] < mid) {
				currentArray[i] = newValue;
			}
		}

		arr.setArray(currentArray);

	}

	@Override
	public void changeElementsBelowMiddleStream(CustomArray arr, int newValue) {

		double mid = findMidValueStream(arr);
		int[] arrAfterChanges = IntStream.of(arr.getArray()).map(e -> (e < mid) ? e = newValue : e).toArray();
		arr.setArray(arrAfterChanges);
	}

	@Override
	public void sortStream(CustomArray array) {

	}

	@Override
	public void bubbleSort(CustomArray array) {

		int[] currentArray = array.getArray();
		boolean needMoreIterations = true;
		int end = currentArray.length;

		while (needMoreIterations) {
			needMoreIterations = false;

			for (int i = 1; i < end; i++) {
				if (currentArray[i - 1] > currentArray[i]) {
					swap(currentArray, i, i - 1);
					needMoreIterations = true;
				}
			}
			end--;
		}
		array.setArray(currentArray);
	}

	@Override
	public void selectionSort(CustomArray array) {

		int[] currentArray = array.getArray();

		for (int i = 0; i < currentArray.length; i++) {
			int indexMinElement = i;

			for (int j = i + 1; j < currentArray.length; j++) {
				if (currentArray[indexMinElement] > currentArray[j]) {
					indexMinElement = j;
				}
			}
			swap(currentArray, i, indexMinElement);
		}

		array.setArray(currentArray);
	}

	@Override
	public void insertionSort(CustomArray array) {
		int[] currentArray = array.getArray();

		for (int i = 1; i < currentArray.length; i++) {
			int currentElement = currentArray[i];
			int j = i - 1;

			while (j >= 0 && currentElement < currentArray[j]) {
				currentArray[j + 1] = currentArray[j];
				j--;
			}
			currentArray[j + 1] = currentElement;
		}

		array.setArray(currentArray);
	}

	@Override
	public void shellSort(CustomArray array) {
		int[] currentArray = array.getArray();

		int arrLenght = currentArray.length;

		for (int g = arrLenght / 2; g > 0; g /= 2) {

			for (int i = g; i < arrLenght; i++) {

				for (int j = i - g; j >= 0; j -= g) {

					if (currentArray[j] > currentArray[j + g]) {
						swap(currentArray, j, j + g);
					}
				}
			}
		}

		array.setArray(currentArray);
	}

	private void swap(int[] arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
}
