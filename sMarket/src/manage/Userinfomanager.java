package manage;

import java.io.IOException;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import entity.UserInfo;

public class Userinfomanager {
	// Ask for user choice
	private Scanner input = new Scanner(System.in);
	
	// Create a user info HashSet
	private Set<UserInfo> userSet;
	
	//initial a user table
	public void initial() {
		userSet = new HashSet<>();
		userSet.add(new UserInfo(100,"jersey","Primary",10,"Active"));
		userSet.add(new UserInfo(121,"Tim","Senior",21,"Active"));
		userSet.add(new UserInfo(231,"Mary","Senior",92,"Locked"));
	}
	
	public void mainMenu() throws IOException{
		boolean loop = true;
		while(loop) {
			System.out.println("\t----WELCOME SUPERMARKET MANAGE SYSTEM----");
			System.out.println("\tYOUR CHOICE:");
			System.out.println("\t\t1. Print all user information.");
			System.out.println("\t\t2. Delete User.");
			System.out.println("\t\t3. Add User.");
			System.out.println("\t\t4. Change User Score.");
			System.out.println("\t\t5. Exit.");
			System.out.println("\t-----------------------------------------");
			int choice = input.nextInt();
			
			switch(choice) {
			case 1:
				searchAll();
				break;
			case 2:
				deleteUserInfo();
				break;
			case 3:
				addUserInfo();
				break;
			case 4:
				changeScore();
				break;
			case 5:
				loop = false;
				break;
			default:
				System.out.println("Invalid Input!");
				throw new InputMismatchException();
				}
			}
		System.out.println("Goodbye~");
	}
	
	
	private void searchAll() {
		System.out.println("\t---------USER TABLE---------");
		System.out.println("ID\tName\tClass\tScore\tStatus");
		for(Iterator<UserInfo> it = userSet.iterator();it.hasNext();) {
			System.out.println(it.next());
		}
		System.out.println("\n");
	}
	
	
	private void addUserInfo() {
		// first, set a new random user Id between 0~1000;
		Random r = new Random();
		int newId = r.nextInt(1000);
		// Ask for more user information and add to the userSet
		System.out.println("Please insert your new username:");
		input.nextLine();
		String newUserName = input.nextLine();
		
		UserInfo searchUser = searchUserWithId(newId);
		
		if(searchUser != null) {
			System.out.println("Randomly generated user Id has existed, do you want to try again?\n");
			System.out.println("1: Try again\t0: Cancel");
			int choice = input.nextInt();
			if(choice == 1) {
				addUserInfo();
				return;
			}
			else if(choice == 0) return;
			else {
				System.out.println("Invalid choice!");
				return;
			}
		}
		
		// searchUser not exist, then create a new user
		UserInfo newUser = new UserInfo(newId,newUserName,"Primary",0,"Active");
		
		// Finally, print the new user and ask whether the information is correct
		System.out.println("ID\tName\tClass\tScore\tStatus");
		System.out.println(newUser);
		System.out.println("Please confirm your new user information. If correct enter 1, else enter 0:");
		int confirm = input.nextInt();
		if(confirm == 1) {
			userSet.add(newUser);
			searchAll();
		}
		else System.out.println("CANCELLED!");
	}
	
	
	
	private void deleteUserInfo(){
		System.out.println("Which user you want to delete? Input that user's Id:");
		try {
			int searchId = input.nextInt();
			UserInfo deleteResult = searchUserWithId(searchId);
			if(deleteResult == null) {
				System.out.println("User Not Exist!");
				return;
			}
			else userSet.remove(deleteResult);
			searchAll();
		}
		
		// Exception thrown when the user types a letter and not an number
		catch(InputMismatchException e) {
			System.out.println("Invalid User Id!");
		}
	}
	
	private void changeScore() {
		try {
			// Ask for the user Id
			System.out.println("\nTo change the user's score, input that user's Id:");
			int scoreId = input.nextInt();
			
			// Get the user information by the user Id
			UserInfo editUser = searchUserWithId(scoreId);
			if(editUser == null) {
				System.out.println("Your input user Id not exists. Do you want to try again?\n1: Try again\t0:Go back");
				int ifTry = input.nextInt();
				if(ifTry == 1) {
					changeScore();
					return;
				}
				else return;
			}
			System.out.println("Information of the user you want to change, please input a new score:");
			System.out.println(editUser+"\n");
			
			// Edit the user information
			int newScore = input.nextInt();
			editUser.setScore(newScore);
			System.out.println(editUser+"\n----DONE----\n");
		}
		
		// Exception thrown when the user types a letter and not an number
		catch(InputMismatchException e) {
			System.out.println("Invalid input number!");
		}
	}
	
	private UserInfo searchUserWithId(int searchId) {
		UserInfo searchUser = null;
		for(Iterator<UserInfo> it = userSet.iterator();it.hasNext();) {
			searchUser = it.next();
			if(searchUser.getId() == searchId) {
				return searchUser;
			}
		}
		//this user id does not exist
		return null;
	}
}
