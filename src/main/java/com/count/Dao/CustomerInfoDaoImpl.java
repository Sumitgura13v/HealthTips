package com.count.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.count.Entity.CustomerInfo;

@Component
public class CustomerInfoDaoImpl implements CustomerInfoDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int addCustomer(CustomerInfo customer) {
		String query="insert into customerinfo(name,gender,age,weight,height,activityType) values(?,?,?,?,?,?)";
		int insert = jdbcTemplate.update(query,customer.getName(),customer.getGender(),customer.getAge(),
				customer.getWeight(),customer.getHeight(),customer.getActivityType());
		return insert;
	}

	@Override
	public int updateCustomer(CustomerInfo customer) {
		String query="update customerinfo set age=?, weight=?, height=?, activityType=? where id=?";
		int update=jdbcTemplate.update(query,customer.getAge(),customer.getWeight(),customer.getHeight(),
				customer.getActivityType(),customer.getId());
		return update;
	}

	@Override
	public int deleteCustomer(int id) {
		String query="delete from customerinfo where id=?";
		int delete=jdbcTemplate.update(query,id);
		return delete;
	}

	@Override
	public CustomerInfo getCustomer(int id) {
		String query="select * from customerinfo where id=?";
		CustomerInfo info = jdbcTemplate.queryForObject(query,new RowMapperImpl(),id);
		return info;
	}

	@Override
	public List<CustomerInfo> getAllcustomers() {
		String query="select * from customerinfo";
		List<CustomerInfo> info = jdbcTemplate.query(query,new RowMapperImpl());
		return info;
	}

	@Override
	public int updateCustomoer(CustomerInfo customer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CustomerInfo> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

}
