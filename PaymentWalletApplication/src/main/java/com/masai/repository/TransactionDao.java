package com.masai.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.model.PaymentMode;
import com.masai.model.Transaction;
import com.masai.model.TransactionType;

public interface TransactionDao extends JpaRepository<Transaction, Integer>{
	
	public Set<Transaction> findByType(TransactionType type);
	
	public Set<Transaction> findByMode(PaymentMode mode);
	
	@Query("select t from Transaction t where DATE(t.transactionTime)>?1 and DATE(t.transactionTime)<?2")
	public Set<Transaction> findTransactionBetweenDates(LocalDate start, LocalDate end);
	
	@Query("select t.mode, count(t) from Transaction t group by t.mode")
	public List<Object[]> findMonthlyTransactionByMode();
	
	@Query("select t.type , count(t) from Transaction t group by t.type")
	public List<Object[]> findMonthlyTransactionByType();
	
	@Query("select t.type , sum(t.amount) from Transaction t group by t.type")
	public List<Object[]> findTotalRevenueByType();
	
	@Query("select t.mode , sum(t.amount) from Transaction t group by t.mode")
	public List<Object[]> findToalRevenueByMode();
	
	@Query("select t.transactionTime , t.amount from Transaction t")
	public List<Object[]> findByNameTime();
	
	
}
