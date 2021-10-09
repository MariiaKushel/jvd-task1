package by.javacource.task1.validator;

public interface StringValidator {

	static final String STRING_AS_INT_ARRAY_REGEX = "(-?\\d{1,10};)+";
	
	boolean validate(String StringAsIntArray);

}
