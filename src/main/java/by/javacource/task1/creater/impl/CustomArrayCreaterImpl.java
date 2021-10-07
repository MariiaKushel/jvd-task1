package by.javacource.task1.creater.impl;

import by.javacource.task1.creater.CustomArrayCreater;
import by.javacource.task1.entity.CustomArray;

public class CustomArrayCreaterImpl implements CustomArrayCreater{

	public CustomArray create(int... intArr) {
		
		return new CustomArray (intArr);
	}

}
