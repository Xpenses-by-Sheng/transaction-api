package com.xpenses.transaction.repository;

import com.xpenses.transaction.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income, String> {
}
