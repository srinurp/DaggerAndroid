package com.zoftino.daggerandroid;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zoftino.daggerandroid.db.Expense;

import java.util.List;

public class ExpenseRViewAdapter extends RecyclerView.Adapter<ExpenseRViewAdapter.ViewHolder> {

    private List<Expense> expList;
    private Context context;

    public ExpenseRViewAdapter(List<Expense> expenseList, Context ctx) {
        expList = expenseList;
        context = ctx;
    }

    @Override
    public ExpenseRViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.expense_details, parent, false);

        ExpenseRViewAdapter.ViewHolder viewHolder = new ExpenseRViewAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ExpenseRViewAdapter.ViewHolder holder, int position) {
        Expense expense = expList.get(position);
        holder.type.setText(expense.getType());
        holder.details.setText(expense.getDetails());
        holder.amount.setText("" + expense.getAmount());
    }

    @Override
    public int getItemCount() {
        return expList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView type;
        public TextView details;
        public TextView amount;

        public ViewHolder(View view) {
            super(view);

            type = (TextView) view.findViewById(R.id.expense_t);
            details = (TextView) view.findViewById(R.id.expense_d);
            amount = (TextView) view.findViewById(R.id.expense_a);

        }
    }
}