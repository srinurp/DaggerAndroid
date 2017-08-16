package com.zoftino.daggerandroid.di;

import android.app.Application;

import com.zoftino.daggerandroid.ExpenseApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules ={AndroidInjectionModule.class,
        AppModule.class})
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }

    void inject(ExpenseApplication app);
}
