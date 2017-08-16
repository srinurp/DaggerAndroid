package com.zoftino.daggerandroid.message;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ActivityMessage implements Message{
    @Inject
    public ActivityMessage(){}

    public String getMessage(){
        return "This month's total number of expenses exceeds average";
    }
}
