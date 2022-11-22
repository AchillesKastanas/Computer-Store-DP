package com.learning_design_patterns.Store;

import java.util.ArrayList;
import java.util.Random;

import com.learning_design_patterns.Computer.Computer;
import com.learning_design_patterns.Customer.Customer;
import com.learning_design_patterns.Factory.ComputerFactory;
import com.learning_design_patterns.Factory.DesktopPCFactory;
import com.learning_design_patterns.Factory.LaptopFactory;

public class TopTierComputersStore {

    private static volatile TopTierComputersStore instance;
    private ArrayList<Computer> availableComputers = new ArrayList<Computer>();
    private ArrayList<Customer> subscribedCustomers = new ArrayList<Customer>();
    private ComputerFactory computerFactory = new ComputerFactory();

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
                    System.out.println("[STORE] Top Tier Store Created");
                }
            }
        }

        return instance;
    }

    public void subscribe(Customer customer){
        System.out.println("[STORE] Customer: " + System.identityHashCode(customer) + " subscribed to the waitlist");
        subscribedCustomers.add(customer);
    }

    public void unsubscribe(Customer customer){
        System.out.println("[STORE] Customer: " + System.identityHashCode(customer) + " unsubscribed from the waitlist");
        subscribedCustomers.remove(customer);
    }

    private void addPC(Computer computer){
        System.out.println("[STORE] Computer: " + System.identityHashCode(computer) + " marked as Available");
        availableComputers.add(computer);
    }

    public void removePC(Computer computer){
        System.out.println("[STORE] Computer: " + System.identityHashCode(computer) + " marked as Sold");
        availableComputers.remove(computer);
    }

    private void notifyCustomers(Computer justArrivedComputer){
        try{
            subscribedCustomers.forEach(customer -> customer.newPcAvailable(justArrivedComputer));
        }
        //If a user wants this PC, he will remove himself from the ArrayList instantly, making an error
        //Catch the error and print a Delivery Complete message
        catch(Exception e){
            System.out.println("[STORE] Computer: " + System.identityHashCode(justArrivedComputer) + " has been delivered.");
        }
    }

    //Orders a new Computer from the ComputerFactory
    //Decides Randomly if it will be a DesktopPC or a Laptop
    public void orderNewRandomComputerFromRandomFactory(){
        // System.out.println("New " + justArrivedComputer.getClass().getSimpleName()+ " Arrived: " + System.identityHashCode(justArrivedComputer) 
        //     + " with the specs:" + justArrivedComputer.getPartList());

        boolean isLaptop = new Random().nextBoolean();

        Computer newComputer;
        if(isLaptop){
            newComputer = computerFactory.makeComputer(new LaptopFactory());
        }
        else{
            newComputer = computerFactory.makeComputer(new DesktopPCFactory());
        }

        //Add the new PC to the availability list
        addPC(newComputer);
        //Notify the subscribedCustomers of the new Computer
        notifyCustomers(newComputer);
    }

    public ArrayList<Customer> getSubscribedCustomers(){
        return subscribedCustomers;
    }

    public ArrayList<Computer> getAvailableCumputers(){
        return availableComputers;
    }
}
