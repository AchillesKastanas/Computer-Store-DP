package com.learning_design_patterns.Computer;

import java.util.ArrayList;

public class Laptop extends Computer{

    private ArrayList<String> systemSpecs = new ArrayList<String>();

    public Laptop(ArrayList<String> systemSpecs){
        this.systemSpecs = systemSpecs;
    }

    @Override
    public void doAction() {
        //Action for Desktop: TAKE PIC
        System.out.println("Picture taken from: " + systemSpecs);
    }

    @Override
    public ArrayList<String> getPartList() {
        return systemSpecs;
    }
    
}
