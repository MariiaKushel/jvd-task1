package by.javacource.task1.service;

import by.javacource.task1.entity.CustomArray;
import by.javacource.task1.exception.CustomException;

public interface CustomArrayService {

	int findMaxValue(CustomArray arr);
	
	int findMaxValueStream(CustomArray arr);

	int findMinValue(CustomArray arr);
	
	int findMinValueStream(CustomArray arr);

	double findMidValue(CustomArray arr);
	
	double findMidValueStream(CustomArray arr);

	int countSumOfElements(CustomArray arr) throws CustomException;
	
	int countSumOfElementsStream(CustomArray arr) throws CustomException;

	int countPositiveElements(CustomArray arr);
	
	int countPositiveElementsStream(CustomArray arr);

	int countNegativeElements(CustomArray arr);
	
	int countNegativeElementsStream(CustomArray arr);

	void changeElementsBelowMiddle(CustomArray arr, int newValue);
	
	void changeElementsBelowMiddleStream(CustomArray arr, int newValue) ;
	
	void sortStream(CustomArray array);

	void bubbleSort(CustomArray array);

	void selectionSort(CustomArray array);
	
	void insertionSort(CustomArray array);
	
	void shellSort(CustomArray array);

}
