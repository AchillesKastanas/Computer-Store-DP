package com.learning_design_patterns;

public class PhoneGeneralFactory {
    public static Phone makePhone(PhoneAbstractFactoryInterface factory){
        return factory.createPhone();
    }
}
