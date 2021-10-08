package by.javacource.task1.entity;

import java.util.Arrays;

public class CustomArray {

	private int[] array;

	public CustomArray() {
		super();
	}

	public CustomArray(int... array) {
		this.array = Arrays.copyOf(array, array.length);
	}

	public int[] getArray() {
		return Arrays.copyOf(array, array.length);
	}

	public void setArray(int... array) {
		this.array = Arrays.copyOf(array, array.length);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(array);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomArray other = (CustomArray) obj;
		if (!Arrays.equals(array, other.array))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CustomArray " + Arrays.toString(array);
	}

}
