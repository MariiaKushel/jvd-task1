package by.javacource.task1.creater.impl;

import java.util.function.Supplier;

import by.javacource.task1.creater.CustomArrayCreater;
import by.javacource.task1.entity.CustomArray;

public class CustomArrayCreaterImpl implements CustomArrayCreater{

	public CustomArray create(int... intArr) {
		
		Supplier <CustomArray> creater = () -> new CustomArray (intArr);
		
		return creater.get();
	}

}
