package com.learning_design_patterns;

public class iPhoneFactory implements PhoneAbstractFactoryInterface {

    private final int screenSize;
    private final String storage;
    private final String phoneNumber;

    public iPhoneFactory(int screenSize, String storage, String phoneNumber){
        this.screenSize = screenSize;
        this.storage = storage;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public Phone createPhone() {
        return new iPhone(screenSize, storage, phoneNumber);
    }
    
}
