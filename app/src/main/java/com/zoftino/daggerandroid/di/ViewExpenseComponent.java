package com.zoftino.daggerandroid.di;

import com.zoftino.daggerandroid.ExpenseListFragment;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ViewExpenseScope
@Subcomponent(modules = ViewExpenseModule.class)
public interface ViewExpenseComponent extends AndroidInjector<ExpenseListFragment> {
    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<ExpenseListFragment> {
    }
}
