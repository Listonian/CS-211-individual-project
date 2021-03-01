package ianListonIndividualProject.Burger211Update;

//Name: Ian Liston
//Contact info: ian.liston@bellevuecollege.edu
//Student ID: 950457388
//Date: 11/30/2020
//Description: Class ExchangeRate retrieves currency data from outside JSON file and then structures the currency data for retrieval from class Franchise
//             for use in calculating USA to foreign currency exchange rates.
//

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.HashMap;

public class ExchangeRate {
	    private static String ratesURL = "https://v6.exchangerate-api.com/v6/206f2fb762faf6860beafb31/latest/USD";
		private static String currenciesURL = "http://country.io/currency.json";
		private static String symbolssURL = "https://gist.githubusercontent.com/Fluidbyte/2973986/raw/8bb35718d0c90fdacb388961c98b8d56abc392c9/Common-Currency.json";
	    private static HashMap<String, Double> rates = new HashMap<>();
		private static HashMap<String, String> currencies = new HashMap<>();
		private static HashMap<String, HashMap> symbols = new HashMap<>();

		ExchangeRate() throws Exception {
			setData();
		}
	    private static Object parseJson(String URL) throws Exception{
			StringBuilder builder = new StringBuilder();
			try {
				URL url = new URL(URL);
				BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
				String str = "";
				while (null != (str = br.readLine())) {
					builder.append(str + "\n");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			JSONParser jsonParser = new JSONParser();	 
		    Object object = jsonParser.parse(builder.toString());

		    return object;
		}

		private static void ratesData() throws Exception {
			Object object = parseJson(ratesURL);
			JSONObject jsonObject = (JSONObject)object;
		  	rates = (HashMap<String, Double>) jsonObject.get("conversion_rates");
		}

		private static void currenciesData() throws Exception {
			Object object = parseJson(currenciesURL);
			JSONObject jsonObject = (JSONObject)object;
			currencies = (HashMap<String, String>) jsonObject;
		}

		private static void symbolsData() throws Exception {
			Object object = parseJson(symbolssURL);
			JSONObject jsonObject = (JSONObject)object;
			symbols = (HashMap<String, HashMap>) jsonObject;
		}

		private static void setData() throws Exception {
			ratesData();
			currenciesData();
			symbolsData();
		}

		double getRate(String country)  {
			String currCurrency = currencies.get(country);
			double currRate = rates.get(currCurrency);
			return currRate;
		}

		String getSymbol(String country)  {
			String currCurrency = currencies.get(country);
			HashMap currCurrencyInfo = symbols.get(currCurrency);
			String currSym = (String) currCurrencyInfo.get("symbol_native");
			return currSym;
		}
		public double returnRate(String name) {
			ExchangeRate convert = null;
			double rate=0.0;
			String country;	
			String symbol;
		     try {
		            convert = new ExchangeRate();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }	  	  
			  country=name + "";  		  
	          rate = convert.getRate(country);
	          symbol= convert.getSymbol(country); 
			return rate;
		}
	}	
