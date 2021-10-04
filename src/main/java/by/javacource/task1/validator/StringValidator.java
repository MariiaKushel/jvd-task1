package by.javacource.task1.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidator {
	
	private static final StringValidator instance = new StringValidator();

	private static final String STRING_AS_INT_ARRAY_REGEX = "(-?\\d{1,10};)+";
	private static final String STRING_AS_INT_REGEX = "-?\\d{10}";
	private static final String MAX_INT_AS_STRING = String.valueOf(Integer.MAX_VALUE);
	private static final String MIN_INT_AS_STRING = String.valueOf(Integer.MIN_VALUE);

	private StringValidator () {
		
	}
	
	public static StringValidator getInstance () {
		return instance;
	}
	
	public boolean validate(String parameter) {

		Pattern pattern = Pattern.compile(STRING_AS_INT_ARRAY_REGEX);
		Matcher matcher = pattern.matcher(parameter);

		boolean isValid;
		isValid = matcher.matches();

		if (isValid) {
			isValid = additionalValidateToIntOverflow(parameter);
		}

		return isValid;
	}

	private boolean additionalValidateToIntOverflow(String parameter) {

		boolean isValid = true;

		Pattern pattern = Pattern.compile(STRING_AS_INT_REGEX);
		Matcher matcher = pattern.matcher(parameter);

		while (matcher.find()) {

			String currentStr = matcher.group();

			if (currentStr.compareTo(MAX_INT_AS_STRING) > 0 || currentStr.compareTo(MIN_INT_AS_STRING) > 0) {
				isValid = false;
				break;
			}
		}
		
		return isValid;
	}
}
