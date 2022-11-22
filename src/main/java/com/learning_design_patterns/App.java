package com.learning_design_patterns;

import com.learning_design_patterns.Customer.Customer;
import com.learning_design_patterns.Store.TopTierComputersStore;

public final class App {
    
    private App() {

    }

    public static void main(String[] args) {
        //Create the TopTierComputersStore
        TopTierComputersStore topTierComputersStore = TopTierComputersStore.getInstance();

        //Create a customer
        synchronized(App.class){
            Customer mike = new Customer();
            Customer mina = new Customer();
    
            topTierComputersStore.subscribe(mike);
            topTierComputersStore.subscribe(mina);
        }
        
        synchronized(App.class){
            topTierComputersStore.orderNewRandomComputerFromRandomFactory();
            topTierComputersStore.orderNewRandomComputerFromRandomFactory();
            topTierComputersStore.orderNewRandomComputerFromRandomFactory();
            topTierComputersStore.orderNewRandomComputerFromRandomFactory();
            topTierComputersStore.orderNewRandomComputerFromRandomFactory();
            topTierComputersStore.orderNewRandomComputerFromRandomFactory();
        }
        
    }
}
