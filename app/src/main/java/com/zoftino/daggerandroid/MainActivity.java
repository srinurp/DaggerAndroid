package com.zoftino.daggerandroid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.zoftino.daggerandroid.message.Message;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector, DaggerInjectable{

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Inject
    Message message;

    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm = getSupportFragmentManager();

        Toast.makeText(this, message.getMessage(), Toast.LENGTH_LONG).show();
    }
    public void addExpenseScreen(View view){
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.content, new AddExpenseFragment());
        ft.commit();
    }
    public void viewExpenseScreen(View view){
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.content, new ExpenseListFragment());
        ft.commit();
    }
    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}
