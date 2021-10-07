package by.javacource.task1.service.impl;

import java.util.stream.IntStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.javacource.task1.entity.CustomArray;
import by.javacource.task1.exception.CustomException;
import by.javacource.task1.service.CustomArrayActionService;

public class CustomArrayActionServiceImpl implements CustomArrayActionService {

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

		int max = IntStream.of(arr.getArray())
				.max()
				.getAsInt();

		return max;
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

		int min = IntStream.of(arr.getArray())
				.min()
				.getAsInt();

		return min;
	}

	@Override
	public double findMidValue(CustomArray arr) {

		int[] currentArray = arr.getArray();
		long sum = 0L;

		for (int elem : currentArray) {
			sum += elem;
		}

		double mid;
		mid = 1.0 * sum / currentArray.length;

		return mid;

	}

	@Override
	public double findMidValueStream(CustomArray arr) {

		double mid = IntStream.of(arr.getArray())
				.average()
				.getAsDouble();

		return mid;
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

		long sumLong = IntStream.of(arr.getArray())
				.asLongStream()
				.sum();

		int sumInt;

		if (sumLong < Integer.MAX_VALUE && sumLong > Integer.MIN_VALUE) {
			sumInt = (int) sumLong;
		} else {
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

		int amountPositiveElements = (int) IntStream.of(arr.getArray())
				.filter(elem -> elem > 0)
				.count();

		return amountPositiveElements;
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

		int amountNegativeElements = (int) IntStream.of(arr.getArray())
				.filter(elem -> elem < 0)
				.count();

		return amountNegativeElements;
	}

	@Override
	public void changeElementsBelowMiddle(CustomArray arr, int newValue) {

		double mid = findMidValue(arr);
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
		int[] arrAfterChanges = IntStream.of(arr.getArray())
				.map(elem -> (elem < mid) ? elem = newValue : elem)
				.toArray();

		arr.setArray(arrAfterChanges);
	}

}
