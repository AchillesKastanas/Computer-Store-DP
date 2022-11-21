package com.learning_design_patterns;

public abstract class Phone {

    public abstract int getScreenSize();
    public abstract String getStorage();
    public abstract String getPhoneNumber();

    public String toString(){
        return "Phone Number: " + this.getPhoneNumber()
            + ", Storage" + this.getStorage()
            + ", Screen" + this.getScreenSize();
    }
    
}
