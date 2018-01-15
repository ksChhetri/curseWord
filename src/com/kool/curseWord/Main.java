package com.kool.curseWord;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		ProductReviews productReviews = new ProductReviews();
		int minRating = 6;
		int maxRating = 9;
		System.out.println("\nNumber of reviews in " + minRating + " - " + maxRating);
		System.out.println(RatingInRange(productReviews, minRating, maxRating, 100));

		System.out.println("\nReviews with negaitve rating");
		RatingsWithErrors(productReviews, 10);

		System.out.println("\nWord Filtering Testing");
		System.out.println("\nTest 1");
		WordFilterTesting("Hello Test");
		System.out.println("\nTest 2");
		WordFilterTesting("GoodBye Test");
	}

	public static void WordFilterTesting(String reviewBody) {
		WordFilter wordFilter = new WordFilter();
		if (!wordFilter.foundBadWord(reviewBody, wordFilter.loadList())) {
			System.out.println("Reivew Accepted");
			;
		} else {
			System.out.println("Review Denied");
		}
	}

	private static void RatingsWithErrors(ProductReviews productReviews, int sampleSize) {
		final List<ProductModel> productModels = productReviews.loadData(sampleSize);
		System.out.println("\nOriginal List2:");
		productModels.forEach(x -> System.out.println(x.toString()));
		System.out.println("\nProcessed List:");
		for (ProductModel p : productModels) {
			if (p.getRating() < 0) {
				try {
					throw new Exception("Invalid Review\nRating Less Then 0\nRating=" + p.getRating());
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("Valid Review\n" + p);
			}
		}
	}

	private static long RatingInRange(ProductReviews productReviews, double minRating, double maxRating,
			int sampleSize) {
		final List<ProductModel> productModels = productReviews.loadData(sampleSize);
		return productModels.stream().filter(x -> (x.getRating() >= minRating && x.getRating() <= maxRating)).count();
	}
}