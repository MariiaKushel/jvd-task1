package by.javacource.task1.parser.impl;

import by.javacource.task1.parser.StringToIntArrayParser;

public class StringToIntArrayParserImpl implements StringToIntArrayParser {

	private static final String STRING_SPLIT_REGEX = ";";

	public int[] parse(String line) {

		String[] strArr = line.split(STRING_SPLIT_REGEX);
		int[] intArr = new int[strArr.length];

		for (int i = 0; i < strArr.length; i++) {
			intArr[i] = Integer.parseInt(strArr[i]);
		}

		return intArr;
	}

}
