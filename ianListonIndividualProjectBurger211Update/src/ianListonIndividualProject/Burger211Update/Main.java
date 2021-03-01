package ianListonIndividualProject.Burger211Update;

//Name: Ian Liston
//Contact info: Listonian@ymail.com
//Date: 11/30/2020
//Description: Class main runs classes Burger211, ExchangeRate, Franchise, MenuGUI, and GetInputGUI.
//           
//           

import java.util.HashMap;

public class Main {
	static HashMap<String,Character> currencyCharSym = new HashMap<String,Character>();
	static HashMap<String,String> currencyCodeMap = new HashMap<String,String>();
	static String countryName;
	static String franchiseName;
	static double exchangeRate;
	static String currencyCode;
	static boolean tripLine;
	static int count;
	
	
	// Program Main.
	public static void main(String[] args) throws Exception {
		ExchangeRate r = new ExchangeRate(); // Pre-loads real time currency exchange rates data from outside JSON file.
		loadCurrencySymbol(); // Pre-loads internal program data.
		
		// Loads GUI to retrieve country name of franchise.
		do {
			GetInputGUI getCountryGUI = null;
			if(count<=0) {
				count = 1;
		getCountryGUI = new GetInputGUI("Valid franchise countries are: USA, South Korea, Australia, Canada, Britain, Mexico, Japan, Hong Kong, and China.","                      Enter your franchises country","globe.png","");
			}
			else {
				getCountryGUI = new GetInputGUI("Valid franchise countries are: USA, South Korea, Australia, Canada, Britain, Mexico, Japan, Hong Kong, and China.","                      Enter your franchises country","globe.png","Please enter a valid country");	
			}
		do {
			countryName = getCountryGUI.getCountry();
			tripLine = getCountryGUI.getBool();
			System.out.println();
		}while(!tripLine);
		countryName = countryName.toLowerCase();
		}while(!currencyCodeMap.containsKey(countryName));
		tripLine = false;
		
		// Retrieves currency exchange rate from class IPExchange rate
		currencyCode = currencyCodeMap.get(countryName);
		if(currencyCode != "USD") {
		exchangeRate = r.returnRate(currencyCode);
		}
		else {
			exchangeRate = 1;
		}
		
		// Loads GUI to retrieve country name of franchise.
		GetInputGUI getFranchiseGUI = new GetInputGUI("","                      Enter your franchises name","restaurant.png","");
		System.out.println();
		do {
			franchiseName = getFranchiseGUI.getCountry();
			tripLine = getFranchiseGUI.getBool();
			System.out.println();
		}while(!tripLine);
		
		// Runs class IPFranchise to structure and load GUI for advertisement page.
		String franchiseNameHold = franchiseName.substring(0,1).toUpperCase() + franchiseName.substring(1);
		Franchise franchise = new Franchise(countryName,currencyCharSym.get(countryName),exchangeRate);
		franchise.menu(franchiseNameHold);
	}
	
	// Loads internal (non-JSON file) program data.
	public static void loadCurrencySymbol() {
		currencyCharSym.put("usa", (char) 36);
		currencyCodeMap.put("usa", "USD");
		currencyCharSym.put("south korea",(char) 8361);
		currencyCodeMap.put("south korea","KR");
		currencyCharSym.put("australia",(char) 36);
		currencyCodeMap.put("australia","AU");
		currencyCharSym.put("canada",(char) 36);
		currencyCodeMap.put("canada","CA");
		currencyCharSym.put("britain",(char) 163);
		currencyCodeMap.put("britain","GG");
		currencyCharSym.put("mexico",(char) 36);
		currencyCodeMap.put("mexico","MX");
		currencyCharSym.put("japan",(char) 165);
		currencyCodeMap.put("japan","JP");
		currencyCharSym.put("hong kong",(char) 36);
		currencyCodeMap.put("hong kong","HK");
		currencyCharSym.put("china",(char) 165);
		currencyCodeMap.put("china","CN");
	}
}
