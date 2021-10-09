package by.javacource.task1.reader.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.javacource.task1.exception.CustomException;
import by.javacource.task1.reader.CustomFileReader;
import by.javacource.task1.validator.StringValidator;
import by.javacource.task1.validator.impl.StringValidatorImpl;

public class CustomFileReaderImpl implements CustomFileReader {

	static Logger logger = LogManager.getLogger();
	private static final String EMPTY_STRING = "";

	public String read(String pathToFile) throws CustomException {

		StringValidator validator = StringValidatorImpl.getInstance();

		String currentLine = EMPTY_STRING;

		try (BufferedReader reader = new BufferedReader(new FileReader(new File(pathToFile)))) {

			boolean isCorrectLine = false;

			while (!isCorrectLine && (currentLine = reader.readLine()) != null) {
				isCorrectLine = validator.validate(currentLine);
			}

			if (currentLine == null) {
				currentLine = EMPTY_STRING;
			}

		} catch (FileNotFoundException e) {
			logger.error("File " + pathToFile + " was not found.", e);
			throw new CustomException("File " + pathToFile + " was not found.", e);
		} catch (IOException e) {
			logger.error("Failed or interrupted I/O operations while working on the file " + pathToFile + ".", e);
			throw new CustomException(
					"Failed or interrupted I/O operations while working on the file " + pathToFile + ".", e);
		}

		return currentLine;
	}

}
