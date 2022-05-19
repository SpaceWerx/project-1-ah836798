package com.revature;

import java.util.Scanner; // import the Scanner class 

import Service.CLI_Menu_Service;

public class Launcher {

	//CLI Menu is the Command Line Interface Menu for the 
		//initialize a new CLI Menu Service 
	      public static void main(String[] args) {
	        CLI_Menu_Service options = new CLI_Menu_Service();
	        options.displayMenu();
//	        options.loginMenu();
//	        options.registerMenu();
	      }
	}

