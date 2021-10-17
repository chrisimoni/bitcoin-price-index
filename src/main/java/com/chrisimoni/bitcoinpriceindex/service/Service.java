package com.chrisimoni.bitcoinpriceindex.service;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

public interface Service {
	Map<JSONObject, JSONObject> getCurrentBitcoinPriceIndexData();
	List<Double> getHighestAndLowestBitcoinRateInLast30Days(String code);
	boolean checkCurrencyCodeExist(String code);
	double getCurrentBitcoinRate(String code);
}
