package com.zoftino.daggerandroid.di;

import android.support.v4.app.Fragment;

import com.zoftino.daggerandroid.AddExpenseFragment;
import com.zoftino.daggerandroid.ExpenseListFragment;
import com.zoftino.daggerandroid.message.ActivityMessage;
import com.zoftino.daggerandroid.message.Message;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {AddExpenseComponent.class, ViewExpenseComponent.class})
public abstract class ActivityModule {
    @Provides
    public static Message getExpMessage(ActivityMessage activityMessage){
        return activityMessage;
    }

    @Binds
    @IntoMap
    @FragmentKey(AddExpenseFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> provideAddExpenseFragment(AddExpenseComponent.Builder builder);

    @Binds
    @IntoMap
    @FragmentKey(ExpenseListFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> provideExpenseListFragment(ViewExpenseComponent.Builder builder);
}
