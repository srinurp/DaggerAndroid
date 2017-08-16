package com.zoftino.daggerandroid.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ExpenseDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCoupon(Expense expense);


    @Query("SELECT * FROM Expense WHERE type = :typeIn")
    LiveData<List<Expense>> getExpenseByType(String typeIn);

    @Query("DELETE FROM Expense WHERE type = :typeIn")
    void deleteExpenseByType(String typeIn);
}
