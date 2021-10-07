package by.javacource.task1.service;

import by.javacource.task1.entity.CustomArray;

public interface CustomArraySortingService {

	void sortStream(CustomArray array);

	void bubbleSort(CustomArray array);

	void selectionSort(CustomArray array);

	void insertionSort(CustomArray array);

	void shellSort(CustomArray array);

}
