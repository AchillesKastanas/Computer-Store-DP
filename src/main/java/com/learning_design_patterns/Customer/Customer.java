package com.learning_design_patterns.Customer;

import com.learning_design_patterns.Computer.Icomputer;
import com.learning_design_patterns.RandomComputerGenerator.RandomComputerSpecGenerator;
import com.learning_design_patterns.Store.TopTierComputersStore;

public class Customer implements Icustomer{

    private Icomputer myComputer;
    private TopTierComputersStore topTierComputersStore = TopTierComputersStore.getInstance();

    public Customer(){
        requestComputer();
    }

    @Override
    public void requestComputer() {
        //Generate a random pc to request from the store
        RandomComputerSpecGenerator randomComputerSpecGenerator = new RandomComputerSpecGenerator();
        myComputer = randomComputerSpecGenerator.generateSpecList();
    
        System.out.println("Hi, I'm Customer: " + System.identityHashCode(this) +". The computer that i want has: " + myComputer.getPartList()
            + " and it is a " + myComputer.getClass().getSimpleName());
    }
    
    public Icomputer getMyComputer(){
        return myComputer;
    }

    public void newPcAvailable(Icomputer newAvailablePc){
        //If the new PC matches the specs the pc has && they are both laptops or desktops
        if(newAvailablePc.getPartList().equals(myComputer.getPartList()) && 
            newAvailablePc.getClass().equals(myComputer.getClass())){
            System.out.println("Hey! I need that: " + System.identityHashCode(newAvailablePc) + " with specs: " + newAvailablePc.getPartList());
            //Remove from the stores available computers
            topTierComputersStore.removePC(newAvailablePc);
            //Unsubscribe from the store
            topTierComputersStore.unsubscribe(this);
            //-1 customer remaining
        }
    }
}
