package by.javacource.task1.creater.impl;

import by.javacource.task1.creater.ArrayCreater;
import by.javacource.task1.entity.CustomArray;

public class ArrayCreaterImpl implements ArrayCreater{

	public CustomArray create(int... intArr) {
		
		return new CustomArray (intArr);
	}

}
