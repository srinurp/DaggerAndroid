package com.zoftino.daggerandroid;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zoftino.daggerandroid.db.Expense;
import com.zoftino.daggerandroid.db.ExpenseDAO;
import com.zoftino.daggerandroid.message.Message;

import java.util.List;

import javax.inject.Inject;

public class ExpenseListFragment extends LifecycleFragment implements DaggerInjectable{
    @Inject
    ExpenseDAO expenseDAO;

    @Inject
    Message message;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.expense_list,
                container, false);

        return view;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        final RecyclerView expRecyclerView = (RecyclerView) this.getActivity().findViewById(R.id.expense_rv);
        RecyclerView.LayoutManager couponLayoutManager = new LinearLayoutManager(this.getActivity());
        expRecyclerView.setLayoutManager(couponLayoutManager);

        expenseDAO.getExpenseByType("shopping").observe(this, new Observer<List<Expense>>() {
            @Override
            public void onChanged(@Nullable List<Expense> expenses) {
                if (expenses == null) {
                    return;
                }
                ExpenseRViewAdapter expenseRViewAdapter =
                        new ExpenseRViewAdapter(expenses, ExpenseListFragment.this.getActivity());
                expRecyclerView.setAdapter(expenseRViewAdapter);
            }
        });

        Toast.makeText(this.getActivity(), message.getMessage(), Toast.LENGTH_LONG).show();
    }
}