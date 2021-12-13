package com.kolmakova.dto;

import com.kolmakova.entities.Passenger;
import com.kolmakova.entities.Train;

public class PaymentDTO {

    private Integer id;
    private Train train;
    private Passenger passenger;
    private Double amount;
    private boolean isDeleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "id=" + id +
                ", train=" + train +
                ", passenger=" + passenger +
                ", amount=" + amount +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
