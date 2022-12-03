package com.crudoperation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class CustomerDao {
JdbcTemplate template;
public void setTemplate(JdbcTemplate template) {    
    this.template = template;    
}    
public int save(Customer cus){    
    String query1="insert into customer values("+cus.getId()+",'"+cus.getName()+"',"+cus.getMobileno()+")";    
    return template.update(query1);    
}    
public int update(Customer cus){    
    String query1="update customer set name='"+cus.getName()+"',mobileno='"+cus.getMobileno()+"' where id="+cus.getId()+"";    
    return template.update(query1);    
}    
public int delete(int id){    
    String sql="delete from customer where id="+id+"";    
    return template.update(sql);    
}    
public Customer getCustomerById(int id){    
    String sql="select * from customer where id=?";    
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Customer>(Customer.class));    
}    
public List<Customer> getCustomers(){    
    return template.query("select * from customer",new RowMapper<Customer>(){    

		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			    Customer e=new Customer();    
		            e.setId(rs.getInt(1));    
		            e.setName(rs.getString(2));    
		            e.setMobileno(rs.getLong(3));    
		             return e;    
		}    
    });    
}    
}