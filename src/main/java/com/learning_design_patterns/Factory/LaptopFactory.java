package com.learning_design_patterns.Factory;

import com.learning_design_patterns.Computer.Computer;
import com.learning_design_patterns.RandomComputerGenerator.RandomComputerSpecGenerator;

public class LaptopFactory implements IComputerFactory {

    @Override
    public Computer createComputer() {
        //Generate a random Laptop
        RandomComputerSpecGenerator randomComputerSpecGenerator = new RandomComputerSpecGenerator();
        return randomComputerSpecGenerator.generateComputer("Laptop");
    }
    
}
