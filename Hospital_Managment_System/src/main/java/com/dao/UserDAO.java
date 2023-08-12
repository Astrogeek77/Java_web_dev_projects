package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.User;

public class UserDAO {
	private Connection conn;

	public UserDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean insertData(User user) {
		boolean result = false;
		try {
			// database design => tablename -> id, Fullname, email, password
			String databaseTableName = "user_details";
			// as id attribute is set as auto increment, we need to specify columns we want
			// to insert data to.
			String insertquery = "insert into " + databaseTableName + "(fullname, email, password) values(?, ?, ?)";

			// create a prepared statement to execute a query
			PreparedStatement ps = conn.prepareStatement(insertquery);
			// feed data to the database through prepared statement)
			ps.setString(1, user.getFullname());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());

			// response upon executing query, output as 1 signifies successful operation
			int resp = ps.executeUpdate();
			if (resp == 1) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

//		if (result) {
//			System.out.println("Data Inserted Successfully!");
//		} else {
//			System.out.println("Some problem occured while inserting data to the database.");
//		}
		return result;
	}

	public User handleLogin(String email, String password) {
		User user = null;
		try {
			// database design => tablename -> id, Fullname, email, password
			String databaseTableName = "user_details";
			String selectquery = "select * from " + databaseTableName + " where email = ? and password = ?";

			// create a prepared statement to execute a query
			PreparedStatement ps = conn.prepareStatement(selectquery);
			ps.setString(1, email);
			ps.setString(2, password);
			// result response
			ResultSet resp = ps.executeQuery();

			while (resp.next()) {

				// create an employee object
				user = new User();

				// fill values in the employee object
				user.setId(resp.getInt(1));
				user.setFullname(resp.getString(2));
				user.setEmail(resp.getString(3));
				user.setPassword(resp.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	public boolean updateData(User user) {
		boolean result = false;
		try {
			// database design => tablename -> id, Fullname, email, password
			String databaseTableName = "user_details";
			String updatequery = "update " + databaseTableName + " set fullname = ?, email = ?,"
					+ " password = ? where id = ?";

			// create a prepared statement to execute a query
			PreparedStatement ps = conn.prepareStatement(updatequery);
			// feed data to the database through prepared statement)
			ps.setString(1, user.getFullname());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setInt(4, user.getId());

			// response upon executing query, output as 1 signifies successful operation
			int resp = ps.executeUpdate();
			if (resp == 1) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

//		if (result) {
//			System.out.println("Data with empid = " + user.getId() + " Updated Successfully!");
//		} else {
//			System.out.println("Some problem occured while updating data in the database.");
//		}
		return result;
	}

	public boolean deleteData(int id) {
		boolean result = false;
		try {
			// database design => tablename -> id, Fullname, email, password
			String databaseTableName = "user_details";
			String deletequery = "delete from " + databaseTableName + " where id = ?";

			// create a prepared statement to execute a query
			PreparedStatement ps = conn.prepareStatement(deletequery);
			// feed data to the database through prepared statement)
			ps.setInt(1, id);

			// response upon executing query, output as 1 signifies successful operation
			int resp = ps.executeUpdate();
			if (resp == 1) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

//		if (result) {
//			System.out.println("Data with empid = " + id + " deleted Successfully!");
//		} else {
//			System.out.println("Some problem occured while deleting data in the database.");
//		}
		return result;
	}

	// show a user data
	public User showDataId(int id) {
		User user = null;
		try {
			// database design => tablename -> id, Fullname, email, password
			String databaseTableName = "user_details";
			String selectquery = "select * from " + databaseTableName + " where id = ?";

			// create a prepared statement to execute a query
			PreparedStatement ps = conn.prepareStatement(selectquery);
			ps.setInt(1, id);
			// result response
			ResultSet resp = ps.executeQuery();

			while (resp.next()) {

				// create an employee object
				user = new User();

				// fill values in the employee object
				user.setId(resp.getInt(1));
				user.setFullname(resp.getString(2));
				user.setEmail(resp.getString(3));
				user.setPassword(resp.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	public List<User> showData() {
		User user = null;
		List<User> userData = new ArrayList<User>();
		;
		try {
			// database design => tablename -> id, Fullname, email, password
			String databaseTableName = "user_details";
			String selectquery = "select * from " + databaseTableName;

			// create a prepared statement to execute a query
			PreparedStatement ps = conn.prepareStatement(selectquery);

			// result response
			ResultSet resp = ps.executeQuery();

			while (resp.next()) {
				// create an employee object
				user = new User();

				// fill values in the employee object
				user.setId(resp.getInt(1));
				user.setFullname(resp.getString(2));
				user.setEmail(resp.getString(3));
				user.setPassword(resp.getString(4));

				userData.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return userData;
	}

	public boolean checkOldPassword(int userid, String oldPassword) {
		boolean result = false;

		try {
			String sql = "select * from user_details where id=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.setString(2, oldPassword);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				result = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean changePassword(int userid, String newPassword) {
		boolean result = false;

		try {
			String sql = "update user_details set password=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setInt(2, userid);

			int i = ps.executeUpdate();
			if (i == 1) {
				result = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}
