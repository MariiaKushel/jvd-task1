package by.javacource.task1.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidator {

	private static final StringValidator instance = new StringValidator();

	private static final String STRING_AS_INT_ARRAY_REGEX = "(-?\\d{1,10};)+";
	private static final String STRING_AS_INT_OVERFLOW_CANDIDATE_REGEX = "-?\\d{10}";
	private static final String MAX_INT_AS_STRING = String.valueOf(Integer.MAX_VALUE);
	private static final String MIN_INT_AS_STRING = String.valueOf(Integer.MIN_VALUE);

	private StringValidator() {

	}

	public static StringValidator getInstance() {
		return instance;
	}

	//	5;-30;17;1258; // correct line 	
	//	5,-30,5 // wrong line
	// 	8;r2;2;9 // wrong line
	// 	3;11111111111111111111111111;5 // wrong line
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

	//	cheсk only the substring which containes an int overflow candidate
	//	3000000000 - will check
	//	-300000000 - will not check
	private boolean additionalValidateToIntOverflow(String parameter) {

		boolean isValid = true;

		Pattern pattern = Pattern.compile(STRING_AS_INT_OVERFLOW_CANDIDATE_REGEX);
		Matcher matcher = pattern.matcher(parameter);

		while (matcher.find()) {
			String candidate = matcher.group();

			if (candidate.compareTo(MAX_INT_AS_STRING) > 0 || candidate.compareTo(MIN_INT_AS_STRING) > 0) {
				isValid = false;
				break;
			}
		}

		return isValid;
	}

}
