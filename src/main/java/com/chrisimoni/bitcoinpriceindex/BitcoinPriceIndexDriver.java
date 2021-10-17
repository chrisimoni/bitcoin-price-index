package com.chrisimoni.bitcoinpriceindex;

import java.util.List;
import java.util.Scanner;

import com.chrisimoni.bitcoinpriceindex.service.ServiceImpl;

public class BitcoinPriceIndexDriver {

	public static void main(String[] args) {
		BitcoinPriceIndex bitcoinPriceIndex = new BitcoinPriceIndex(new ServiceImpl());
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a currency code: ");
		String code = in.nextLine();

		if (!bitcoinPriceIndex.checkCurrencyCodeExist(code)) {
			System.out.println("The currency code you provided is not supported, try a different one.");
			return;
		}

		double currentBitcoinRate = bitcoinPriceIndex.getCurrentBitcoinRate(code);
		List<Double> bitcoinRateInLast30Days = bitcoinPriceIndex.getHighestAndLowestBitcoinRateInLast30Days(code);

		System.out.println();
		System.out.println("Current Bitcoin rate: " + currentBitcoinRate);
		System.out.println("Lowest Bitcoin rate in the last 30 days: " + bitcoinRateInLast30Days.get(0));
		System.out.println("Highest Bitcoin rate in the last 30 days: "
				+ bitcoinRateInLast30Days.get(bitcoinRateInLast30Days.size() - 1));
	}

}
