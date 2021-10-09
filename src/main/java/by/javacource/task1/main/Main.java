package by.javacource.task1.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.javacource.task1.creater.CustomArrayCreater;
import by.javacource.task1.creater.impl.CustomArrayCreaterImpl;
import by.javacource.task1.entity.CustomArray;
import by.javacource.task1.exception.CustomException;
import by.javacource.task1.parser.StringToIntArrayParser;
import by.javacource.task1.parser.impl.StringToIntArrayParserImpl;
import by.javacource.task1.reader.CustomFileReader;
import by.javacource.task1.reader.impl.CustomFileReaderImpl;
import by.javacource.task1.service.CustomArrayActionService;
import by.javacource.task1.service.CustomArraySortingService;
import by.javacource.task1.service.impl.CustomArrayActionServiceImpl;
import by.javacource.task1.service.impl.CustomArraySortingServiceImpl;


public class Main {

	static Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		
		CustomFileReader reader = new CustomFileReaderImpl();
		StringToIntArrayParser pareser = new StringToIntArrayParserImpl();
		CustomArrayCreater creater = new CustomArrayCreaterImpl();
		CustomArrayActionService actionService = new CustomArrayActionServiceImpl();
		CustomArraySortingService sortService = new CustomArraySortingServiceImpl();

		try {
			String line = reader.read("src\\main\\resources\\data\\arrays.txt");

			int[] intArr = pareser.parse(line);

			CustomArray array = creater.create(intArr);

			int resultInt;
			double resultDouble;

			logger.info("Base array > " + array);
			
			resultInt = actionService.findMaxValue(array);
			logger.info("Max value > " + resultInt);
			
			resultInt = actionService.findMaxValueStream(array);
			logger.info("Max value (stream) > " + resultInt);
			
			resultInt = actionService.findMinValue(array);
			logger.info("Min value > " + resultInt);
			
			resultInt = actionService.findMinValueStream(array);
			logger.info("Min value (stream) > " + resultInt);
			
			resultDouble = actionService.findMidValue(array);
			logger.info("Mid value > " + resultDouble);
			
			resultDouble = actionService.findMidValueStream(array);
			logger.info("Mid value (stream) > " + resultDouble);
					
			resultInt = actionService.countSumOfElements(array);
			logger.info("Sum of elements > " + resultInt);
			
			resultInt = actionService.countSumOfElementsStream(array);
			logger.info("Sum of elements (stream )> " + resultInt);
			
			resultInt = actionService.countPositiveElements(array);
			logger.info("Positive elements> " + resultInt);
			
			resultInt = actionService.countPositiveElementsStream(array);
			logger.info("Positive elements (stream) > " + resultInt);
			
			resultInt = actionService.countNegativeElements(array);
			logger.info("Negative elements > " + resultInt);
			
			resultInt = actionService.countNegativeElementsStream(array);
			logger.info("Negative elements (stream) > " + resultInt);
			
			actionService.changeElementsBelowMiddle(array, 99);
			logger.info("Array after changes > " + array);
			
			//actionService.changeElementsBelowMiddleStream(array, 99);
			//logger.info("Array after changes (stream) > " + array);

			sortService.bubbleSort(array);
			logger.info("Array after bubbleSort > " + array);
			
			//sortService.selectionSort(array);
			//logger.info("Array after selectionSort > " + array);
			
			//sortService.insertionSort(array);
			//logger.info("Array after insertionSort > " + array);
			
			//sortService.shellSort(array);
			//logger.info("Array after shellSort > " + array);
			
			//sortService.sortStream(array);
			//logger.info("Array after sortStream > " + array);
				
		} catch (CustomException e) {
			logger.error(e);
			e.printStackTrace();
		}

	}

}
