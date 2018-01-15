package com.kool.curseWord;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//create some sample fake reviews for testing
final public class ProductReviews {
	List<ProductModel> loadData(int numOfRecords) {
		List<ProductModel> tempList = new ArrayList<>();
		Random rand = new Random();
		double rangeMin = -9.9;
		double rangeMax = 9.9;
		for (int i = 0; i < numOfRecords; i++) {
			final int maxLength = rand.nextInt(10) + 3;
			StringBuilder tempName = new StringBuilder(maxLength);
			for (int j = 0; j < maxLength; j++) {
				final char nextChar = (char) (rand.nextInt(26) + 65);
				tempName.append(nextChar);
			}
			tempList.add(new ProductModel(rangeMin + (rangeMax - rangeMin) * rand.nextDouble(), tempName.toString()));
		}
		return tempList;
	}
}