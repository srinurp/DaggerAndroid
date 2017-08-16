package com.zoftino.daggerandroid.di;

import com.zoftino.daggerandroid.message.Message;
import com.zoftino.daggerandroid.message.ViewExpenseMessage;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
@Module
public class ViewExpenseModule {
    @ViewExpenseScope
    @Named("view")
    @Provides
    public Message getExpMessage(ViewExpenseMessage viewExpenseMessage){
        return viewExpenseMessage;
    }
}
