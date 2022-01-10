package com.kolmakova.repositories;

import com.kolmakova.entities.Passenger;
import com.kolmakova.entities.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer>, JpaSpecificationExecutor<Passenger> {
}
