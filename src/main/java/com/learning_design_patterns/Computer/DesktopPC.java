package com.learning_design_patterns.Computer;

import java.util.ArrayList;

public class DesktopPC implements Icomputer{

    private ArrayList<String> systemSpecs = new ArrayList<String>();

    public DesktopPC(ArrayList<String> systemSpecs){
        this.systemSpecs = systemSpecs;
    }

    @Override
    public void doAction() {
        //Action for Desktop: RUN APP
        System.out.println("App Opened from: " + systemSpecs);
    }

    @Override
    public ArrayList<String> getPartList() {
        return systemSpecs;
    }
}
