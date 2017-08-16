package com.zoftino.daggerandroid.di;

import com.zoftino.daggerandroid.MainActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent extends AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<MainActivity> {
    }
}
