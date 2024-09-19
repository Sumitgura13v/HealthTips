package com.count;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.count.Dao.CustomerInfoDao;
import com.count.Dao.CustomerInfoDaoImpl;
import com.count.Entity.CustomerInfo;
import com.count.Service.CalculatorService;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

		CustomerInfoDaoImpl customerInfoDaoImpl = context.getBean("customerInfoDaoImpl", CustomerInfoDaoImpl.class);
		CalculatorService calculatorService = context.getBean("calculatorService", CalculatorService.class);

		Scanner scan = new Scanner(System.in);
				
		System.out.println("To create a new account type 'new' " + "\n"
				+ "If you want to update your details type 'update'"+ "\n"
				+ "If you want to delete the data type 'delete'" + "\n"
				+ "If you want to see all users type 'allusers'" + "\n"
				+ "*** Choose correct option ***");
		String ans = scan.nextLine();
					
		// For new Entry
		if (ans.equals("new")) {
			System.out.println("Write Your Name : ");
			String name = scan.nextLine();

			System.out.println("Write Your Weight(in KG) : ");
			double weight = scan.nextDouble();

			System.out.println("Write Your Age : ");
			int age = scan.nextInt();

			System.out.println("Write Your Height(in CM) : ");
			double height = scan.nextDouble();

			System.out.println("Write Your Gender(M/F) : ");
			String gender = scan.next();

			System.out.println("Activity Types : " + "\n" + "1.Active(workout 5-6 days/week)" + "\n"
					+ "2.Moderate(workout 3-4 days/week)" + "\n" + "3.Light(workout 1-2 days/week)" + "\n"
					+ "4.Little or No Exercise");

			System.out.println("Select your ActivityType(1/2/3/4) : ");
			int type = scan.nextInt();

			CustomerInfo customerInfo = new CustomerInfo();
			customerInfo.setName(name);
			customerInfo.setGender(gender);
			customerInfo.setAge(age);
			customerInfo.setWeight(weight);
			customerInfo.setHeight(height);
			customerInfo.setActivityType(type);

			if (gender.equals("M")) {
				int calculateCaloriesForMen = calculatorService.calculateCaloriesForMen(customerInfo);
				calculatorService.dietPlan(calculateCaloriesForMen);
			} else {
				int calculateCaloriesForWomen = calculatorService.calculateCaloriesForWomen(customerInfo);
				calculatorService.dietPlan(calculateCaloriesForWomen);
			}
			customerInfoDaoImpl.addCustomer(customerInfo);
		}

		// for Update Entry
		else if (ans.equals("update")) {

			System.out.println("write your id : ");
			int id = scan.nextInt();

			System.out.println("Write Your Age : ");
			int updateAge = scan.nextInt();

			System.out.println("Write Your Weight(in KG) : ");
			double updateWeight = scan.nextDouble();

			System.out.println("Write Your Height(in CM) : ");
			double updateHeight = scan.nextDouble();

			System.out.println("Activity Types : " + "\n" + "1.Active(workout 5-6 days/week)" + "\n"
					+ "2.Moderate(workout 3-4 days/week)" + "\n" + "3.Light(workout 1-2 days/week)" + "\n"
					+ "4.Little or No Exercise");

			System.out.println("Select your ActivityType(1/2/3/4) : ");
			int updateType = scan.nextInt();

			CustomerInfo customerInfo = new CustomerInfo();
			customerInfo.setId(id);
			customerInfo.setAge(updateAge);
			customerInfo.setWeight(updateWeight);
			customerInfo.setHeight(updateHeight);
			customerInfo.setActivityType(updateType);

			customerInfoDaoImpl.addCustomer(customerInfo);

			CustomerInfo customer = customerInfoDaoImpl.getCustomer(id);

			if (customer.getGender().equals("M")) {
				int calculateCaloriesForMen = calculatorService.calculateCaloriesForMen(customer);
				calculatorService.dietPlan(calculateCaloriesForMen);

			} else {
				int calculateCaloriesForWomen = calculatorService.calculateCaloriesForWomen(customer);
				calculatorService.dietPlan(calculateCaloriesForWomen);
			}
			
		//For delete account	
		} else if (ans.equals("delete")) {
			System.out.println("Give your id");
			int deleteId = scan.nextInt();
			customerInfoDaoImpl.deleteCustomer(deleteId);
			System.out.println("your account get deleted with id " + deleteId);
			
		//for getting all users	
		} else if (ans.equals("allusers")) {
			List<CustomerInfo> allcustomers = customerInfoDaoImpl.getAllCustomers();
			for (CustomerInfo c : allcustomers) {
				System.out.println(c);
			}
		}

		else {
			System.out.println("wrong input!!");
		}
	}
}
