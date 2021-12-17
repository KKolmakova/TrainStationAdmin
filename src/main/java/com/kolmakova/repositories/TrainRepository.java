package com.kolmakova.repositories;

import com.kolmakova.entities.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainRepository extends JpaRepository<Train, Integer>, JpaSpecificationExecutor<Train> {

    @Query(value = "SELECT t FROM Train t WHERE arrival_place LIKE :arrivalPlace")
    List<Train> findTrainByArrival(@Param("arrivalPlace") String arrivalPlace);
}
