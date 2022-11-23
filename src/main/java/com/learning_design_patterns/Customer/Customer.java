package com.learning_design_patterns.Customer;

import com.learning_design_patterns.Computer.Computer;
import com.learning_design_patterns.RandomComputerGenerator.RandomComputerSpecGenerator;
import com.learning_design_patterns.Store.TopTierComputersStore;

public class Customer implements Icustomer{

    private Computer myComputer;
    private TopTierComputersStore topTierComputersStore = TopTierComputersStore.getInstance();

    public Customer(){
        requestComputer();
    }

    @Override
    public void requestComputer() {
        //Generate a random pc to request from the store
        RandomComputerSpecGenerator randomComputerSpecGenerator = new RandomComputerSpecGenerator();
        myComputer = randomComputerSpecGenerator.generateComputerForCustomer();
    
        System.out.println("[CUSTOMER]\tHi, I'm Customer: " + System.identityHashCode(this) +". The computer that i want has: " + myComputer.getPartList()
            + " and it is a " + myComputer.getClass().getSimpleName());
    }
    
    public Computer getMyComputer(){
        return myComputer;
    }

    public void newPcAvailable(Computer newAvailablePc){
        //If the new PC matches the specs the pc has && they are both laptops or desktops
        if(newAvailablePc.getPartList().equals(myComputer.getPartList()) && 
            newAvailablePc.getClass().equals(myComputer.getClass())){
            System.out.println("[CUSTOMER]\tHey! I need that: " + System.identityHashCode(newAvailablePc) + " with specs: " + newAvailablePc.getPartList());
            //Remove from the stores available computers
            topTierComputersStore.removePC(newAvailablePc);
            //Unsubscribe from the store
            topTierComputersStore.unsubscribe(this);
            //Do the action of the computer (Desktop - Run App, Laptop - Take a picture)
            newAvailablePc.doAction();
            //-1 customer remaining
        }
    }
}
