package com.learning_design_patterns;

import java.util.ArrayList;

public final class App {
    
    private App() {
    }

    public static void main(String[] args) {

        //Phone myPhone = new iPhone(15, "20GB", "6949232421");
        // Phone myiPhone = PhoneGeneralFactory.makePhone(new iPhoneFactory(25, "asd", "asd"));

        // System.out.println(myiPhone.toString());

        //Create the TopTierComputersStore
        TopTierComputersStore topTierComputersStore = TopTierComputersStore.getInstance();

        //Create a customer
        Customer mike = new Customer();
        topTierComputersStore.subscribe(mike);
        ArrayList<String> pcSpecs = new ArrayList<String>();
        pcSpecs.add("i3");
        pcSpecs.add("1080");
        topTierComputersStore.newPC(new DesktopPC(pcSpecs));
    }
}
