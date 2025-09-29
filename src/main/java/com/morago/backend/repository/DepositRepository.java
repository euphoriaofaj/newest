package com.morago.backend.repository;

import com.morago.backend.entity.Deposit;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepositRepository extends JpaRepository<Deposit, Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select d from Deposit d where d.id = :id")
    Optional<Deposit> findByIdForUpdate(Long id);
}
