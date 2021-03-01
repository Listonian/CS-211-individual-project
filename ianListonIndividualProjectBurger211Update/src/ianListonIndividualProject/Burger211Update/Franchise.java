package ianListonIndividualProject.Burger211Update;

//Name: Ian Liston
//Contact info: ian.liston@bellevuecollege.edu
//Student ID: 950457388
//Date: 11/30/2020
//Description: Class extends Burger211 and collects and structures information for advertising (MenuGUI).
//         
//

import java.text.DecimalFormat;

public class Franchise extends Burger211 {
	static private char countrySym;
	static private double exchangeRate;
	static private String price1,price2,price3;
	static private double discountRate = 0.5;
	static DecimalFormat df = new DecimalFormat("#,###,##0.00");
	public Franchise(String country1,char countrySym1,double exchangeRate1) {
		super();
		countrySym = countrySym1;;
		exchangeRate = exchangeRate1;
		price1 = df.format(super.getPrice1()*exchangeRate);
		price2 = df.format(super.getPrice2()*exchangeRate);
		price3 = df.format(super.getPrice3()*exchangeRate);
	}
	public double getPrice1(){
		if(discountRate > 0.0) {
			return (super.getPrice1()*exchangeRate)*(1-discountRate);
		}
		return (super.getPrice1()*exchangeRate);
	}
	// Gets price of burger2/applies discount
	public double getPrice2(){
		if(discountRate > 0.0) {
			return (super.getPrice2()*exchangeRate)*(1-discountRate);
		}
		return (super.getPrice2()*exchangeRate);
	}
	// Gets price of burger3/applies discount
	public double getPrice3(){
		if(discountRate > 0.0) {
			return (super.getPrice3()*exchangeRate)*(1-discountRate);
		}
		return (super.getPrice3()*exchangeRate);
	}
	// Gets name of burger1
	public String getName1() {
		return super.getName1();
	}
	// Gets name of burger2
	public String getName2() {
		return super.getName2();
	}
	// Gets name of burger3
	public String getName3() {
		return super.getName3();
	}
	// Gets toppings of burger1
	public String getTopping1() {
		return super.getTopping1();
	}
	// Gets toppings of burger2
	public String getTopping2() {
		return super.getTopping2();
	} 
	// Gets toppings of burger3
	public String getTopping3() {
		return super.getTopping3();
	}
	// Gets promotional description
	public String promotion() {
		return super.promotion();
		}
	// Burger name and pricing string structure
	private String getInfo(double priceDiscounted,String burgerName,String price) {
		String pString = df.format(priceDiscounted);
		return burgerName + " / " + countrySym + pString + "(was "+ countrySym + price + ")";	
	}
	
	// Sends advertising menu data to GUI
	public void menu(String franchise) {
		new MenuGUI(franchise,getInfo(getPrice1(),getName1(),price1),getTopping1(),getInfo(getPrice2(),getName2(),price2),getTopping2(),getInfo(getPrice3(),getName3(),price3),getTopping3(),promotion());
	}
}
