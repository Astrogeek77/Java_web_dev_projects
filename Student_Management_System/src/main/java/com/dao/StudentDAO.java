package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Student;

public class StudentDAO {
	private Connection conn;

	public StudentDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean insertData(Student student) {
		boolean result = false;
		try {
			// database design => tablename -> id, name. dob, address, qualification, email
			String databaseTableName = "student";
			// as id attribute is set as auto increment, we need to specify columns we want to insert data to.
			String insertquery = "insert into " + databaseTableName + "(name, dob, address, qualification, email) values(?, ?, ?, ?, ?)";
			
			// create a prepared statement to execute a query
			PreparedStatement ps = conn.prepareStatement(insertquery);
			// feed data to the database through prepared statement)
			ps.setString(1, student.getFullname());
			ps.setString(2, student.getDob());
			ps.setString(3, student.getAddress());
			ps.setString(4, student.getQualification());
			ps.setString(5, student.getEmail());
			
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
			System.out.println("Some problem occured while inserting data to the database.");
		}
		return result;
	}
	
	public boolean updateData(Student student) {
		boolean result = false;
		try {
			// database design => tablename -> id, name. dob, address, qualification, email
			String databaseTableName = "student";
			String updatequery = "update " + databaseTableName + " set name = ?, dob = ?, "
					+ "address = ?, qualification = ?, email = ? where id = ?";
			
			// create a prepared statement to execute a query
			PreparedStatement ps = conn.prepareStatement(updatequery);
			// feed data to the database through prepared statement)
			ps.setString(1, student.getFullname());
			ps.setString(2, student.getDob());
			ps.setString(3, student.getAddress());
			ps.setString(4, student.getQualification());
			ps.setString(5, student.getEmail());
			ps.setInt(6, student.getId());
			
			// response upon executing query, output as 1 signifies successful operation
			int resp = ps.executeUpdate();
			if(resp == 1) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(result) {
			System.out.println("Data with empid = " + student.getId() + " Updated Successfully!");
		} else {
			System.out.println("Some problem occured while updating data in the database.");
		}
		return result;
	}
	
	public boolean deleteData(int id) {
		boolean result = false;
		try {
			// database design => tablename -> id, name. dob, address, qualification, email
			String databaseTableName = "student";
			String deletequery = "delete from " + databaseTableName + " where id = ?";
			
			// create a prepared statement to execute a query
			PreparedStatement ps = conn.prepareStatement(deletequery);
			// feed data to the database through prepared statement)
			ps.setInt(1, id);
			
			// response upon executing query, output as 1 signifies successful operation
			int resp = ps.executeUpdate();
			if(resp == 1) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(result) {
			System.out.println("Data with empid = " + id + " deleted Successfully!");
		} else {
			System.out.println("Some problem occured while deleting data in the database.");
		}
		return result;
	}
	
	// show a student data
	public Student showDataId(int id) {
		Student student = null;
		try {
			// database design => tablename -> id, name. dob, address, qualification, email
			String databaseTableName = "student";
			String selectquery = "select * from " + databaseTableName + " where id = ?";
			
			// create a prepared statement to execute a query
			PreparedStatement ps = conn.prepareStatement(selectquery);
			ps.setInt(1, id);
			// result response
			ResultSet resp = ps.executeQuery();
			

			
			while(resp.next()) {
				
				// create an employee object
				student = new Student();
				
				// fill values in the employee object
				student.setId(resp.getInt(1));
				student.setFullname(resp.getString(2));
				student.setDob(resp.getString(3));
				student.setAddress(resp.getString(4));
				student.setQualification(resp.getString(5));
				student.setEmail(resp.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return student;
	}
	
	public List<Student> showData() {
		Student student = null;
		List<Student> studentData = new ArrayList<Student>();;
		try {
			// database design => tablename -> id, name. dob, address, qualification, email
			String databaseTableName = "student";
			String selectquery = "select * from " + databaseTableName;
			
			// create a prepared statement to execute a query
			PreparedStatement ps = conn.prepareStatement(selectquery);
			
			// result response
			ResultSet resp = ps.executeQuery();
		
			
			while(resp.next()) {
				// create an employee object
				student = new Student();
				
				// fill values in the employee object
				student.setId(resp.getInt(1));
				student.setFullname(resp.getString(2));
				student.setDob(resp.getString(3));
				student.setAddress(resp.getString(4));
				student.setQualification(resp.getString(5));
				student.setEmail(resp.getString(6));
				
				studentData.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return studentData;
	}
}