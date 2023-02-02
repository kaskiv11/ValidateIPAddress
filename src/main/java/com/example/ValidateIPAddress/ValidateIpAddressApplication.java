package com.example.ValidateIPAddress;


import com.example.ValidateIPAddress.files.FileIO;
import com.example.ValidateIPAddress.validation.ValidateIPv4;

import java.io.IOException;
import java.util.Scanner;


public class ValidateIpAddressApplication {

	public static void main(String[] args) throws IOException {
		FileIO fileIO = new FileIO();
		ValidateIPv4 validateIPv4 = new ValidateIPv4();

		Scanner scanner = new Scanner(System.in);
		String message;

		do {
			System.out.println("Enter IP address or quit to exit");
			message = scanner.nextLine();
			System.out.println(validateIPv4.validateIPAddressWithBlockList(message,fileIO.listOfBlockedAddresses())+"\n");
		}while (!message.equals("quit"));
	}
}
