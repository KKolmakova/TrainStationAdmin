package com.kolmakova.repositories;

import com.kolmakova.entities.Payment;
import com.kolmakova.entities.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    @Query(value = "SELECT p FROM Payment p WHERE passenger_id = :passengerId")
    List<Payment> getPassengerPayments(@Param("passengerId") Integer passengerId);
}
