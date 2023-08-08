package com.main;

import java.util.List;
import java.util.Scanner;

import com.conn.connectDB;
import com.dao.ContactDAO;
import com.entity.contact;

public class mainClass {

	public static void main(String[] args) {

		boolean flag = true;

		while (flag) {
			System.out.println("----------------------");
			System.out.println("1. Create a new Contact");
			System.out.println("2. Update Existing Contact");
			System.out.println("3. Delete a Contact");
			System.out.println("4. View a Particular Contact");
			System.out.println("5. View All Contacts");
			System.out.println("6. Exit App");
			System.out.println("----------------------");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Option: ");
			int option = sc.nextInt();

			ContactDAO dao = new ContactDAO(connectDB.getConn());

			switch (option) {
			case 1:
				// Insert a new Contact
				System.out.println("Enter Contact Details.");
				System.out.println("Enter Name (w/o space): ");
				String name = sc.next();
				System.out.println("Enter Phone Number: ");
				String phno = sc.next();

				contact c = new contact();
				c.setName(name);
				c.setPhno(phno);

				boolean resp = dao.saveContact(c);

				if (resp) {
					System.out.println("Contact Saved Succesfully.");
				} else {
					System.out.println("Something went wrong on server..");
				}
				break;

			case 2:
				// Update Existing Contact based on id
				System.out.println("Enter Id of Contact to update: ");
				int id = sc.nextInt();
				System.out.println("Enter New / Previous Name (w/o space)");
				String name2 = sc.next();
				System.out.println("Enter New / Previous Phone Number");
				String phno2 = sc.next();

				contact c2 = new contact();
				c2.setId(id);
				c2.setName(name2);
				c2.setPhno(phno2);

				boolean resp2 = dao.updateContact(c2);

				if (resp2) {
					System.out.println("Contact Updated Successfully..");
				} else {
					System.out.println("Contact Data Is not Available.");
				}

				break;
			case 3:
				// Delete Existing Contact based on id
				System.out.println("Enter Id of Contact to delete: ");
				int id2 = sc.nextInt();

				boolean resp3 = dao.deleteContact(id2);

				if (resp3) {
					System.out.println("Contact Deleted Sucessfully..");
				} else {
					System.out.println("Contact Data Is not Available.");
				}

				break;
			case 4:
				// View Contact corresponding to a id
				System.out.println("Enter Id of Contact to view: ");
				int id3 = sc.nextInt();
				contact con = dao.showContact(id3);
				
				System.out.println("Requested Data from table: ");
				if (con == null) {
					System.out.println("Contact Data Is not Available.");
				} else {
//					System.out.println("Contact Id= " + con.getId());
//					System.out.println("Contact Name= " + con.getName());
//					System.out.println("Contact Phno= " + con.getPhno());
					System.out.println("---------------------");
					System.out.println("Contact Id  = " + con.getId() + ", Contact Name = " +
							con.getName() + ", Contact Phone = " + con.getPhno());
					System.out.println("---------------------");
				}
				break;
			case 5:
				// View All Contacts
				List<contact> list = dao.showAllContact();
				
				System.out.println("Requested Data from table: ");
				if (list.isEmpty()) {
					System.out.println("Contact Data Is not Available.");
				} else {

					for (contact con2 : list) {
						System.out.println("---------------------");
						System.out.println("Contact Id  = " + con2.getId() + ", Contact Name = " +
								con2.getName() + ", Contact Phone = " + con2.getPhno());
						System.out.println("---------------------");
					}
				}
				break;
			case 6:
				flag = false;
				connectDB.closeConn();
				sc.close();
				System.out.println("Thank u..Visit Again..");
				break;

			default:
				System.out.println("Please Enter Correct Option.");
				break;
			}

		}

	}

}
