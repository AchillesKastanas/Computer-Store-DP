package com.learning_design_patterns;

import java.util.Scanner;

import com.learning_design_patterns.Customer.Customer;
import com.learning_design_patterns.Store.TopTierComputersStore;

public final class App {
    
    private App() {

    }

    public static void main(String[] args) {

        //Create the TopTierComputersStore
        TopTierComputersStore topTierComputersStore = TopTierComputersStore.getInstance();

        System.out.println("------------------------------------------------");
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Welcome to Design Patters Part 1.\nPlease enter the [Number of Customers]: ");
        int customerCount = Integer.parseInt(scanner.nextLine());  // Read user input
        System.out.println("\nNow please enter the [Number of Computers to be created]: ");
        int computerCount = Integer.parseInt(scanner.nextLine());  // Read user input
        scanner.close();
        System.out.println("\n------------------------------------------------");

        //Create the Customers
        for(int i = 0; i <customerCount; i++){
            topTierComputersStore.subscribe( new Customer());
        }

        //Create the Computers
        for(int i = 0; i <computerCount; i++){
            topTierComputersStore.orderNewRandomComputerFromRandomFactory();
        }

        //Print all the remaining Customers that have not recieved a computer
        System.out.println("\n-------------- [APP FINISHED] -----------------\n");
        System.out.println("STATISTICS:");
        System.out.println("Remainig Customers without a Computer: " + topTierComputersStore.getSubscribedCustomers().size());
        System.out.println("Remainig Computers: " + topTierComputersStore.getAvailableCumputers().size() + "\n");
    }
}
