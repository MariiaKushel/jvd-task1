package by.javacource.task1.reader;

import by.javacource.task1.exception.CustomException;

public interface CustomFileReader {

	String read(String pathToFile) throws CustomException;

}
