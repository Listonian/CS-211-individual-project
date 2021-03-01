package ianListonIndividualProject.Burger211Update;

//Name: Ian Liston
//Contact info: ian.liston@bellevuecollege.edu
//Student ID: 950457388
//Date: 11/30/2020
//Description: Abstract interface (Super class Burger211) for an advertising section of restaurant Burger211's web site. 
//             This class also stores the main pricing, discounts, and burger names for Burger211"s flagship locations 
//             in the United States. 

public class Burger211 {
	static private double price1,price2,price3;
	static private String name1,name2,name3;
	static private String topping1,topping2,topping3;
	static private String promotion;
	Burger211(){
		prices();
		toppings();
		names();
		promotions();
	}
	void prices() {
		price1 = 3.0;
		price2 = 2.0;
		price3 = 3.5;
	}
	void toppings() {
		topping1 = "beef patty, tomato, onion, ranch sauce";
		topping2 = "chicken breast, gallo, onion, ranch sauce";
		topping3 = "beef patty, lime, onion, lettuce, tomato sauce";
	}
	void names() {
		name1 = "Inheritance Burger";
		name2 = "Polymorphism Burger";
		name3 = "Overriding Burger";
	}
	void promotions() {
		promotion = "Covid-19 special, 50% off any burger (Takeout only)";
	}
	//Gets price of burger1/applies discount
	public double getPrice1(){
		return price1;
	}
	//Gets price of burger2/applies discount
	public double getPrice2(){
		return price2;
	}
	//Gets price of burger3/applies discount
	public double getPrice3(){
		return price3;
	}
	//Gets name of burger1
	public String getName1() {
		return name1;
	}
	//Gets name of burger2
	public String getName2() {
		return name2;
	}
	//Gets name of burger3
	public String getName3() {
		return name3;
	}
	//Gets toppings of burger1
	public String getTopping1() {
		return topping1;
	}
	//Gets toppings of burger2
	public String getTopping2() {
		return topping2;
	}
	//Gets toppings of burger3
	public String getTopping3() {
		return topping3;
	}
	//Gets promotional description
	public String promotion() {
		return promotion;
		}
	//Sends advertising menu data to GUI
	public void menu() {
	}
}

