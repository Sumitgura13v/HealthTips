package com.count.Dao;

import java.util.List;

import com.count.Entity.CustomerInfo;

public interface CustomerInfoDao {
	public int addCustomer(CustomerInfo customer);
	public int updateCustomoer(CustomerInfo customer);
	public int deleteCustomer(int d);
	public CustomerInfo getCustomer (int id);
	public List<CustomerInfo> getAllCustomers();
	int updateCustomer(CustomerInfo customer);
	List<CustomerInfo> getAllcustomers();

}
