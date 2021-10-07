package by.javacource.task1.service.impl;

import java.util.stream.IntStream;

import by.javacource.task1.entity.CustomArray;
import by.javacource.task1.service.CustomArraySortingService;

public class CustomArraySortingServiceImpl implements CustomArraySortingService {

	@Override
	public void sortStream(CustomArray arr) {

		int[] sortedArray = IntStream.of(arr.getArray())
				.sorted()
				.toArray();
		
		arr.setArray(sortedArray);
	}

	@Override
	public void bubbleSort(CustomArray arr) {

		int[] currentArray = arr.getArray();
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
		
		arr.setArray(currentArray);
	}

	@Override
	public void selectionSort(CustomArray arr) {

		int[] currentArray = arr.getArray();

		for (int i = 0; i < currentArray.length; i++) {
			int indexMinElement = i;

			for (int j = i + 1; j < currentArray.length; j++) {
				if (currentArray[indexMinElement] > currentArray[j]) {
					indexMinElement = j;
				}
			}
			swap(currentArray, i, indexMinElement);
		}

		arr.setArray(currentArray);
	}

	@Override
	public void insertionSort(CustomArray arr) {
		int[] currentArray = arr.getArray();

		for (int i = 1; i < currentArray.length; i++) {
			int currentElement = currentArray[i];
			int j = i - 1;

			while (j >= 0 && currentElement < currentArray[j]) {
				currentArray[j + 1] = currentArray[j];
				j--;
			}
			currentArray[j + 1] = currentElement;
		}

		arr.setArray(currentArray);
	}

	@Override
	public void shellSort(CustomArray arr) {
		int[] currentArray = arr.getArray();
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

		arr.setArray(currentArray);
	}

	private void swap(int[] arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

}
