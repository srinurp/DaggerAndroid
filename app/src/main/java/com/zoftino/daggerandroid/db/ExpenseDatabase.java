package com.zoftino.daggerandroid.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Expense.class}, version = 1)
public abstract class ExpenseDatabase extends RoomDatabase {
    public abstract ExpenseDAO expenseDAO();
}
