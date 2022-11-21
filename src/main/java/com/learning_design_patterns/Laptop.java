package com.learning_design_patterns;

import java.io.Console;
import java.util.ArrayList;

public class Laptop implements Icomputer{

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
