package com.learning_design_patterns.Factory;

import com.learning_design_patterns.Computer.Computer;

public class ComputerFactory {
    public Computer makeComputer(IComputerFactory factory){
        return factory.createComputer();
    }
}
