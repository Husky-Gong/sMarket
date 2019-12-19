package test;

import java.io.IOException;

import manage.Userinfomanager;

public class test {
	public static void main(String[] args) throws IOException {
		Userinfomanager uim =new Userinfomanager();
		uim.initial();
		uim.mainMenu();
	}
}
