package com.zoftino.daggerandroid.di;

import com.zoftino.daggerandroid.message.AddExpenseMessage;
import com.zoftino.daggerandroid.message.Message;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class AddExpenseModule {
    @AddExpenseScope
    @Provides
    @Named("add")
    public Message getExpMessage(AddExpenseMessage addExpenseMessage){
        return addExpenseMessage;
    }

    @AddExpenseScope
    @Provides
    public Executor getExecutor(){
        return  Executors.newFixedThreadPool(2);
    }
}
