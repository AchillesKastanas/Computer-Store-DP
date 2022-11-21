package com.learning_design_patterns;

import java.util.ArrayList;
import java.util.Random;

public class RandomComputerSpecGenerator {

    ArrayList<String> CPUS = new ArrayList<String>();
    ArrayList<String> GPUS = new ArrayList<String>();

    public RandomComputerSpecGenerator(){
        //Create CPUS
        CPUS.add("i3");
        // CPUS.add("i5");
        // CPUS.add("i7");
        // CPUS.add("i9");

        //Create GPUS
        GPUS.add("1080");
        // GPUS.add("2080");
        // GPUS.add("3080");
        // GPUS.add("4080");
    }

    public Icomputer generateSpecList(){
        //Setup
        Icomputer generatedComputer;
        ArrayList<String> generatedSpecList = new ArrayList<String>();
        generatedSpecList.add(CPUS.get(new Random().nextInt(CPUS.size()))); 
        generatedSpecList.add(GPUS.get(new Random().nextInt(GPUS.size()))); 

        //true=LAPTOP OR false=DESKTOP PC
        boolean isLaptop = new Random().nextBoolean();
        if(isLaptop){
            generatedComputer = new Laptop(generatedSpecList);
            System.out.println("New Laptop Created");
        }
        else{
            generatedComputer = new DesktopPC(generatedSpecList);
            System.out.println("New Desktop Created");
        }
        
        return generatedComputer;
    }
}
