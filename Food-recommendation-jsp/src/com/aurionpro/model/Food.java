package com.aurionpro.model;

import java.util.ArrayList;
import java.util.List;

public class Food {
	public List<String> getFood(String taste) {
		
		List<String> tasteList = new ArrayList();
		if (taste.equals("sweet")) {
			tasteList.add("Sugar");
			tasteList.add("Cake");
			tasteList.add("Custard");
			tasteList.add("Chocolate");
		} else if (taste.equals("spicy")) {
			tasteList.add("Curry");
			tasteList.add("Piro Aloo");
			tasteList.add("Spicy Soup");
			tasteList.add("Peri-Peri Fries");
		} else if (taste.equals("salty")) {
			tasteList.add("Cheese");
			tasteList.add("Butter");
			tasteList.add("Pickles");
			tasteList.add("potato chips");
		}else if(taste.equals("sour")) {
			tasteList.add("Lemon");
			tasteList.add("Tamrind");
			tasteList.add("Butter Milk");

		}
		return tasteList;

	}
}
