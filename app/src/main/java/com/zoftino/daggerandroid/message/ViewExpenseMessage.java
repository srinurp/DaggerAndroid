package com.zoftino.daggerandroid.message;


import com.zoftino.daggerandroid.di.ViewExpenseScope;

import javax.inject.Inject;

@ViewExpenseScope
public class ViewExpenseMessage implements Message{
    @Inject
    public ViewExpenseMessage(){}

    public String getMessage(){
        return "You already spent too much in this month";
    }
}
