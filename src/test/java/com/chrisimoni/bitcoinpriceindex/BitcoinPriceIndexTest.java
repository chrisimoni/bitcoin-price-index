package com.chrisimoni.bitcoinpriceindex;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import com.chrisimoni.bitcoinpriceindex.service.Service;

public class BitcoinPriceIndexTest {
	Service serviceStub = new ServiceStub();
	BitcoinPriceIndex bitcoinPriceIndex = new BitcoinPriceIndex(serviceStub);
	String code = "usd";

	@Test
	void testCheckCurrencyCodeExist() {
		assertTrue(bitcoinPriceIndex.checkCurrencyCodeExist(code));
	}

	@Test
	void testGetCurrentBitcoinPriceIndexData() {
		Map<JSONObject, JSONObject> data = bitcoinPriceIndex.getCurrentBitcoinPriceIndexData();
		assertEquals(1, data.size());
	}

	@Test
	void testGetCurrentBitcoinRate() {
		double currentBitcoinRate = bitcoinPriceIndex.getCurrentBitcoinRate(code);
		assertEquals(60873.2183, currentBitcoinRate);
	}

	@Test
	void testGetHighestBitcoinRateInLast30Days() {
		List<Double> highestBitcoinRateInLast30Days = bitcoinPriceIndex
				.getHighestAndLowestBitcoinRateInLast30Days(code);

		assertEquals(61693.79, highestBitcoinRateInLast30Days.get(highestBitcoinRateInLast30Days.size() - 1));
	}

	@Test
	void testGetLowestBitcoinRateInLast30Days() {
		List<Double> lowestBitcoinRateInLast30Days = bitcoinPriceIndex.getHighestAndLowestBitcoinRateInLast30Days(code);

		assertEquals(40681.445, lowestBitcoinRateInLast30Days.get(0));
	}
}
