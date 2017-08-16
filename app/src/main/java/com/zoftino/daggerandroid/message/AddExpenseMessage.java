package com.zoftino.daggerandroid.message;

import com.zoftino.daggerandroid.di.AddExpenseScope;

import javax.inject.Inject;

@AddExpenseScope
public class AddExpenseMessage implements Message{
    @Inject
    public AddExpenseMessage(){}

    public String getMessage(){
        return "Last expense was not on essential category";
    }
}
