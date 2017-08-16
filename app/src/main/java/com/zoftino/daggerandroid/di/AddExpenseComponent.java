package com.zoftino.daggerandroid.di;


import com.zoftino.daggerandroid.AddExpenseFragment;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@AddExpenseScope
@Subcomponent(modules = AddExpenseModule.class)
public interface AddExpenseComponent extends AndroidInjector<AddExpenseFragment> {
    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<AddExpenseFragment> {
    }
}