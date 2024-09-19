package com.count.Service;

import org.springframework.stereotype.Component;

import com.count.Entity.CustomerInfo;

@Component

public class CalculatorService {
	
	//calculating calories for men
	public int calculateCaloriesForMen(CustomerInfo customerInfo) {
	int calories;
	double wt = (10* customerInfo.getWeight());
	double ht = (6.25* customerInfo.getHeight());
	double ag = (5* customerInfo.getAge());
	double bmr = wt+ht-ag+5;
	
	if(customerInfo.getActivityType()==1) {
		calories = (int)(1.55*bmr);
	}
	else if(customerInfo.getActivityType()==2) {
		calories = (int)(1.46*bmr);
	}
	else if(customerInfo.getActivityType()==3) {
		calories = (int)(1.37*bmr);
	}
	else {
		calories = (int)(1.20*bmr);
	}
	return calories;
			
	}
	//calculating calories for Women
		public int calculateCaloriesForWomen(CustomerInfo customerInfo) {
		int calories;
		double wt = (10* customerInfo.getWeight());
		double ht = (6.25* customerInfo.getHeight());
		double ag = (5* customerInfo.getAge());
		double bmr = wt+ht-ag+5;
		
		if(customerInfo.getActivityType()==1) {
			calories = (int)(1.55*bmr);
		}
		else if(customerInfo.getActivityType()==2) {
			calories = (int)(1.38*bmr);
		}
		else if(customerInfo.getActivityType()==3) {
			calories = (int)(1.22*bmr);
		}
		else {
			calories = (int)(0.90*bmr);
		}
		return calories;
	
		}
		public void dietPlan(int calories) {
			System.out.println("Your maintainance calories are "+ calories +" calories"+"\n" +
					"If you want to lose 0.25kg/week consume "+ (calories-250)+" calories"+"\n" +
					"If you want to lose 0.50kg/week consume "+ (calories-500)+" calories"+"\n" +
					"If you want to lose 0.75kg/week consume "+ (calories-750)+" calories");
			System.out.println("If you want to gain 0.25kg/week consume "+ (calories+250)+" calories"+ "\n" +
					"If you want to gain 0.50kg/week consume "+ (calories+500)+" calories"+ "\n" +
					"If you want to gain 0.75kg/week consume "+ (calories+750)+ " calories");
		}
}
