package com.chrisimoni.bitcoinpriceindex.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class ServiceImpl implements Service {

	public Map<JSONObject, JSONObject> getCurrentBitcoinPriceIndexData() {
		Map<JSONObject, JSONObject> dataMap = new HashMap<JSONObject, JSONObject>();
		HttpResponse<String> data = Unirest.get("https://api.coindesk.com/v1/bpi/currentprice/eur.json").asString();
		JSONParser parser = new JSONParser();
		JSONObject json;
		try {
			json = (JSONObject) parser.parse(data.getBody());
			dataMap = (Map<JSONObject, JSONObject>) json.get("bpi");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return dataMap;
	}

	public List<Double> getHighestAndLowestBitcoinRateInLast30Days(String code) {
		List<Double> highestAndLowestBitcoinRateInLast30Days = new ArrayList<Double>();
		LocalDate startDate = LocalDate.now().minusDays(30);
		LocalDate endDate = LocalDate.now();

		HttpResponse<String> data = Unirest.get("https://api.coindesk.com/v1/bpi/historical/close.json?start="
				+ startDate + "&end=" + endDate + "&currency=" + code.toLowerCase()).asString();
		JSONParser parser = new JSONParser();
		JSONObject json;
		try {
			json = (JSONObject) parser.parse(data.getBody());
			Map<String, Double> bitcoinRateMap = (Map<String, Double>) json.get("bpi");
			for (Map.Entry<String, Double> bitcoinRate : bitcoinRateMap.entrySet()) {
				highestAndLowestBitcoinRateInLast30Days.add(bitcoinRate.getValue());
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Collections.sort(highestAndLowestBitcoinRateInLast30Days);

		return highestAndLowestBitcoinRateInLast30Days;
	}

	public boolean checkCurrencyCodeExist(String code) {
		Map<JSONObject, JSONObject> dataMap = getCurrentBitcoinPriceIndexData();
		if (!dataMap.containsKey(code.toUpperCase())) {
			return false;
		}
		return false;
	}

	public double getCurrentBitcoinRate(String code) {
		Map<JSONObject, JSONObject> dataMap = getCurrentBitcoinPriceIndexData();
		double currentBitcoinRate = Double
				.parseDouble(dataMap.get(code.toUpperCase()).get("rate_float").toString());
		return currentBitcoinRate;
	}

}
