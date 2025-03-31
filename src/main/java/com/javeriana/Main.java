package com.javeriana;

import java.util.Scanner;

public class Main {
    

    public static void main(String[] args) {

    // This is the way to ask for the user input

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the name of the artist:");
        String artistName = scanner.nextLine();

        System.out.println("Customer entered: " + artistName);

        //You should create a menu to ask the user what he wants to do



        //At the end, you should close the scanner
        scanner.close();
    }
  
}
