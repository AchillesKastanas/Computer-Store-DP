package com.learning_design_patterns.Factory;

import com.learning_design_patterns.Computer.Computer;
import com.learning_design_patterns.RandomComputerGenerator.RandomComputerSpecGenerator;

public class DesktopPCFactory implements IComputerFactory{

    @Override
    public Computer createComputer() {
        //Generate a random Desktop
        RandomComputerSpecGenerator randomComputerSpecGenerator = new RandomComputerSpecGenerator();
        return randomComputerSpecGenerator.generateComputer("DesktopPC");
    }
    
}
