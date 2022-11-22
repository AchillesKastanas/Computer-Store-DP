package com.learning_design_patterns.Store;

import java.util.ArrayList;

import com.learning_design_patterns.Computer.Computer;
import com.learning_design_patterns.Customer.Customer;

public class TopTierComputersStore {

    private static volatile TopTierComputersStore instance;
    private ArrayList<Computer> availableComputers = new ArrayList<Computer>();
    private ArrayList<Customer> subscribedCustomers = new ArrayList<Customer>();

    private TopTierComputersStore(){
        //ArrayList containg all the available computers
        this.availableComputers = new ArrayList<Computer>();
    }

    public static TopTierComputersStore getInstance(){

        // Optimised for Multi Threaded Run
        // Avoids multiple instances when the app is run with more than 1 threads
        if(instance == null){
            synchronized (TopTierComputersStore.class){

                if(instance == null){
                    instance = new TopTierComputersStore();
                    System.out.println("Top Tier Store Created");
                }
            }
        }

        return instance;
    }

    public void subscribe(Customer customer){
        System.out.println("Customer: " + System.identityHashCode(customer) + " subscribed to the waitlist");
        subscribedCustomers.add(customer);
    }

    public void unsubscribe(Customer customer){
        System.out.println("Customer: " + System.identityHashCode(customer) + " unsubscribed to the waitlist");
        subscribedCustomers.remove(customer);
    }

    public void removePC(Computer computer){
        System.out.println("Customer: " + System.identityHashCode(computer) + " removed from the availability list");
        availableComputers.remove(computer);
    }

    public void newPC(Computer justArrivedComputer){
        System.out.println("New " + justArrivedComputer.getClass().getSimpleName()+ " Arrived: " + System.identityHashCode(justArrivedComputer) 
            + " with the specs:" + justArrivedComputer.getPartList());
        try{
            subscribedCustomers.forEach(customer -> customer.newPcAvailable(justArrivedComputer));
        }
        catch(Exception e){
            System.out.println("Computer: " + System.identityHashCode(justArrivedComputer) + " has been delivered.");
        }
        
    }
    
}
