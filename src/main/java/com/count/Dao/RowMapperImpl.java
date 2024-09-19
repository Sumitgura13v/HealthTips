package com.count.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.count.Entity.CustomerInfo;

public class RowMapperImpl implements RowMapper<CustomerInfo> {
	
	public CustomerInfo mapRow(ResultSet rs,int rowNum) throws SQLException{
		
		CustomerInfo customerInfo = new CustomerInfo();
		customerInfo.setId(rs.getInt(1));
		customerInfo.setName(rs.getString(2));
		customerInfo.setGender(rs.getString(3));
		customerInfo.setAge(rs.getInt(4));
		customerInfo.setWeight(rs.getDouble(5));
		customerInfo.setHeight(rs.getDouble(6));
		customerInfo.setActivityType(rs.getInt(7));		
		return customerInfo;
	}
	
}
