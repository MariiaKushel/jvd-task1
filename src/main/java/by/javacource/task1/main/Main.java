package by.javacource.task1.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.javacource.task1.creater.ArrayCreater;
import by.javacource.task1.creater.impl.ArrayCreaterImpl;
import by.javacource.task1.entity.CustomArray;
import by.javacource.task1.exception.CustomException;
import by.javacource.task1.parser.StringToIntArrayParser;
import by.javacource.task1.parser.impl.StringToIntArrayParserImpl;
import by.javacource.task1.reader.CustomFileReader;
import by.javacource.task1.reader.impl.CustomFileReaderImpl;
import by.javacource.task1.service.CustomArrayService;
import by.javacource.task1.service.impl.CustomArrayServiceImpl;


public class Main {

	static Logger logger = LogManager.getLogger();

	public static void main(String[] args) {

		CustomFileReader reader = new CustomFileReaderImpl();
		StringToIntArrayParser pareser = new StringToIntArrayParserImpl();
		ArrayCreater creater = new ArrayCreaterImpl();
		CustomArrayService service = new CustomArrayServiceImpl();

		try {
			String line = reader.read("src\\main\\resources\\data\\arrays.txt");

			int[] intArr = pareser.parse(line);

			CustomArray array = creater.create(intArr);

			int resultInt;
			double resultDouble;

			resultInt = service.findMaxValue(array);
			logger.info("Max value > " + resultInt);
			
			resultInt = service.findMaxValueStream(array);
			logger.info("Max value (stream) > " + resultInt);
			
			resultInt = service.findMinValue(array);
			logger.info("Min value > " + resultInt);
			
			resultInt = service.findMinValueStream(array);
			logger.info("Min value (stream) > " + resultInt);
			
			resultDouble = service.findMidValue(array);
			logger.info("Mid value > " + resultInt);
			
			resultDouble = service.findMidValueStream(array);
			logger.info("Mid value (stream) > " + resultInt);
					
			resultInt = service.countSumOfElements(array);
			logger.info("Sum of elements > " + resultInt);
			
			resultInt = service.countSumOfElementsStream(array);
			logger.info("Sum of elements (stream )> " + resultInt);
			
			resultInt = service.countPositiveElements(array);
			logger.info("Positive elements> " + resultInt);
			
			resultInt = service.countPositiveElementsStream(array);
			logger.info("Positive elements (stream) > " + resultInt);
			
			resultInt = service.countNegativeElements(array);
			logger.info("Negative elements > " + resultInt);
			
			resultInt = service.countNegativeElementsStream(array);
			logger.info("Negative elements (stream) > " + resultInt);
			
			service.changeElementsBelowMiddle(array, 99);
			logger.info("Array after changes > " + array);
			
			//service.changeElementsBelowMiddleStream(array, 99);
			//logger.info("Array after changes (stream) > " + array);

			//service.bubbleSort(array);
			//logger.info("Array after bubbleSort > " + array);
			
			//service.selectionSort(array);
			//logger.info("Array after selectionSort > " + array);
			
			//service.insertionSort(array);
			//logger.info("Array after insertionSort > " + array);
			
			//service.shellSort(array);
			//logger.info("Array after shellSort > " + array);
			
			//service.sortStream(array);
			//logger.info("Array after sortStream > " + array);
			
		} catch (CustomException e) {
			logger.error(e);
			e.printStackTrace();
		}

	}

}
