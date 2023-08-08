package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.contact;

public class ContactDAO {

	private Connection conn;

	public ContactDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean saveContact(contact c) {
		boolean result = false;
		try {
			// database design => tablename -> id, name, phone
			String databaseTableName = "contact";
			// as id attribute is set as auto increment, we need to specify columns we want to insert data to.
			String insertquery = "insert into " + databaseTableName + "(name, phone) values(?, ?)";
			
			// create a prepared statement to execute a query
			PreparedStatement ps = conn.prepareStatement(insertquery);
			// feed data to the database through prepared statement)
			ps.setString(1, c.getName());
			ps.setString(2, c.getPhno());
			
			// response upon executing query, output as 1 signifies successful operation
			int resp = ps.executeUpdate();
			if(resp == 1) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(result) {
			System.out.println("Data Inserted Successfully!");
		} else {
			System.out.println("Some problem occured while inserting data to the database table.");
		}
		return result;
	}
	
	public boolean updateContact(contact c) {
		boolean result = false;
		try {
			// database design => tablename -> id, name, phone
			String databaseTableName = "contact";
			String updatequery = "update " + databaseTableName + " set name = ?, phone = ? where id = ?";
			
			// create a prepared statement to execute a query
			PreparedStatement ps = conn.prepareStatement(updatequery);
			// feed data to the database through prepared statement)
			ps.setString(1, c.getName());
			ps.setString(2, c.getPhno());
			ps.setInt(3, c.getId());
			
			// response upon executing query, output as 1 signifies successful operation
			int resp = ps.executeUpdate();
			if(resp == 1) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(result) {
			System.out.println("Data with Contactid = " + c.getId() + " Updated Successfully!");
		} else {
			System.out.println("Some problem occured while updating data in the database.");
		}
		return result;
	}
	
	public boolean deleteContact(int id) {
		boolean result = false;
		try {
			// database design => tablename -> id, name, phone
			String databaseTableName = "contact";
			String deletequery = "delete from " + databaseTableName + " where id = ?";
			
			// create a prepared statement to execute a query
			PreparedStatement ps = conn.prepareStatement(deletequery);
			// feed data to the database through prepared statement)
			ps.setInt(1, id);
//			ps.setString(1, emp.getName());
//			ps.setString(2, emp.getAddress());
//			ps.setInt(3, emp.getSalary());
			
			// response upon executing query, output as 1 signifies successful operation
			int resp = ps.executeUpdate();
			if(resp == 1) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(result) {
			System.out.println("Data with Contactid = " + id + " deleted Successfully!");
		} else {
			System.out.println("Some problem occured while deleting data in the database.");
		}
		return result;
	}
	
	public contact showContact(int id) {
		contact contact = null;
		try {
			// database design => tablename -> id, name, phone
			String databaseTableName = "contact";
			String selectquery = "select * from " + databaseTableName + " where id = ?";
			
			// create a prepared statement to execute a query
			PreparedStatement ps = conn.prepareStatement(selectquery);
			ps.setInt(1, id);
			// result response
			ResultSet resp = ps.executeQuery();
			

			
			if(resp.next()) {
				
				// create an employee object
				contact = new contact();
				
				// fill values in the employee object
				contact.setId(resp.getInt(1));
				contact.setName(resp.getString(2));
				contact.setPhno(resp.getString(3));
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return contact;
	}
	
	public List<contact> showAllContact() {
		contact contact = null;
		List<contact> contactData = new ArrayList<contact>();;
		try {
			// database design => tablename -> id, name, phone
			String databaseTableName = "contact";
			String selectquery = "select * from " + databaseTableName;
			
			// create a prepared statement to execute a query
			PreparedStatement ps = conn.prepareStatement(selectquery);
			
			// result response
			ResultSet resp = ps.executeQuery();
		
			
			while(resp.next()) {
				
				// create an employee object
				contact = new contact();
				
				// fill values in the employee object
				contact.setId(resp.getInt(1));
				contact.setName(resp.getString(2));
				contact.setPhno(resp.getString(3));
				
				contactData.add(contact);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return contactData;
	}

}
