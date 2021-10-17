package com.chrisimoni.bitcoinpriceindex;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

import com.chrisimoni.bitcoinpriceindex.service.Service;

public class BitcoinPriceIndex {
	private Service service;
	Map<JSONObject, JSONObject> dataMap = new HashMap<JSONObject, JSONObject>();

	public BitcoinPriceIndex(Service service) {
		this.service = service;
		this.dataMap = getCurrentBitcoinPriceIndexData();
	}
	
	public Map<JSONObject, JSONObject> getCurrentBitcoinPriceIndexData() {
		return service.getCurrentBitcoinPriceIndexData();
	}

	public boolean checkCurrencyCodeExist(String code) {
		if (!this.dataMap.containsKey(code.toUpperCase())) {
			return false;
		}

		return true;
	}

	public double getCurrentBitcoinRate(String code) {
		double currentBitcoinRate = Double
				.parseDouble(this.dataMap.get(code.toUpperCase()).get("rate_float").toString());
		return currentBitcoinRate;
	}

	public List<Double> getHighestAndLowestBitcoinRateInLast30Days(String code) {
		return service.getHighestAndLowestBitcoinRateInLast30Days(code);
	}
}
