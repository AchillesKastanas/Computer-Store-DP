package com.learning_design_patterns;

public class iPhone extends Phone {

    private final int screenSize;
    private final String storage;
    private final String phoneNumber;

    public iPhone(int screenSize, String storage, String phoneNumber){
        this.screenSize = screenSize;
        this.storage = storage;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int getScreenSize() {
        return screenSize;
    }

    @Override
    public String getStorage() {
        return storage;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
}
