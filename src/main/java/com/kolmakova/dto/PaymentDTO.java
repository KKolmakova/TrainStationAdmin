package com.kolmakova.dto;

public class PaymentDTO {

    private Integer id;
    private com.kolmakova.dto.TrainDTO trainDTO;
    private com.kolmakova.dto.PassengerDTO passengerDTO;
    private PricingDTO pricingDTO;
    private double amount;
    private boolean isDeleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public com.kolmakova.dto.TrainDTO getTrainDTO() {
        return trainDTO;
    }

    public void setTrainDTO(TrainDTO trainDTO) {
        this.trainDTO = trainDTO;
    }

    public com.kolmakova.dto.PassengerDTO getPassengerDTO() {
        return passengerDTO;
    }

    public void setPassengerDTO(PassengerDTO passengerDTO) {
        this.passengerDTO = passengerDTO;
    }

    public PricingDTO getPricingDTO() {
        return pricingDTO;
    }

    public void setPricingDTO(PricingDTO pricingDTO) {
        this.pricingDTO = pricingDTO;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "id=" + id +
                ", trainDTO=" + trainDTO +
                ", passengerDTO=" + passengerDTO +
                ", pricingDTO=" + pricingDTO +
                ", amount=" + amount +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
