package com.chrisimoni.bitcoinpriceindex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.chrisimoni.bitcoinpriceindex.service.Service;

public class ServiceStub implements Service {

	public Map<JSONObject, JSONObject> getCurrentBitcoinPriceIndexData(String code) {
		Map<JSONObject, JSONObject> dataMap = new HashMap<JSONObject, JSONObject>();
		JSONParser parser = new JSONParser();
		String sampleData = "{\"bpi\":{\"USD\":{\"code\":\"USD\",\"rate\":\"60,873.2183\",\"description\":\"United States Dollar\",\"rate_float\":60873.2183}}}";
		JSONObject json;
		try {
			json = (JSONObject) parser.parse(sampleData);
			dataMap = (Map<JSONObject, JSONObject>) json.get("bpi");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return dataMap;
	}

	public List<Double> getHighestAndLowestBitcoinRateInLast30Days(String code) {
		List<Double> highestAndLowestBitcoinRateInLast30Days = new ArrayList<Double>();
		if(!code.isEmpty() && code != null) {
			highestAndLowestBitcoinRateInLast30Days = Arrays.asList(47770.4467, 47297.3683, 61693.79, 48315.0433, 47247.4317, 40681.445);
			Collections.sort(highestAndLowestBitcoinRateInLast30Days);
		}

		return highestAndLowestBitcoinRateInLast30Days;
	}

	public boolean checkCurrencyCodeExist(String code) {
		Map<JSONObject, JSONObject> dataMap = getCurrentBitcoinPriceIndexData(code);
		if (!dataMap.containsKey(code.toUpperCase())) {
			return false;
		}
		return false;
	}

	public double getCurrentBitcoinRate(String code) {
		Map<JSONObject, JSONObject> dataMap = getCurrentBitcoinPriceIndexData(code);
		double currentBitcoinRate = Double
				.parseDouble(dataMap.get(code.toUpperCase()).get("rate_float").toString());
		return currentBitcoinRate;
	}

}
