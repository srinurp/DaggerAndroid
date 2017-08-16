package com.zoftino.daggerandroid.di;

import android.app.Activity;
import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.zoftino.daggerandroid.MainActivity;
import com.zoftino.daggerandroid.db.ExpenseDAO;
import com.zoftino.daggerandroid.db.ExpenseDatabase;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {ActivityComponent.class})
public abstract class AppModule {
    @Provides
    @Singleton
    public static Context provideAppContext(Application application) {
        return application;
    }

    @Singleton
    @Provides
    public static ExpenseDAO getCouponDAO(ExpenseDatabase expenseDatabase){
        return expenseDatabase.expenseDAO();
    }

    @Singleton
    @Provides
    public static ExpenseDatabase getCouponDatabase(Application application){
        return Room.databaseBuilder(application.getApplicationContext(),
                ExpenseDatabase.class, "expense.db")
                .build();
    }

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    bindMainActivityInjectorFactory(ActivityComponent.Builder builder);
}
