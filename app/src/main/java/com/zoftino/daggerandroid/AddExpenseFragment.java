package com.zoftino.daggerandroid;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.zoftino.daggerandroid.db.Expense;
import com.zoftino.daggerandroid.db.ExpenseDAO;
import com.zoftino.daggerandroid.message.Message;

import java.util.concurrent.Executor;

import javax.inject.Inject;

public class AddExpenseFragment extends Fragment implements DaggerInjectable{
    @Inject
    ExpenseDAO expenseDAO;

    @Inject
    Executor executor;

    @Inject
    Message message;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_expense,
                container, false);

        Button button = (Button) view.findViewById(R.id.add_exp_b);
        button.setOnClickListener(new View.OnClickListener()        {
            @Override
            public void onClick(View v)
            {
                addExpense(v);
            }
        });

        return view;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
    public void addExpense(View view){
        final Expense expense = new Expense();
        expense.setType(((TextView)getActivity().findViewById(R.id.exptype)).getText().toString());
        expense.setDetails(((TextView)getActivity().findViewById(R.id.expdetails)).getText().toString());
        expense.setAmount(Double.parseDouble(((TextView)getActivity().findViewById(R.id.expamount)).getText().toString()));

        executor.execute( new Runnable() {
            @Override
            public void run() {
                expenseDAO.insertCoupon(expense);
            }
        });
        Toast.makeText(this.getActivity(), "Add new expense ,"+message.getMessage(), Toast.LENGTH_LONG).show();
    }
}
