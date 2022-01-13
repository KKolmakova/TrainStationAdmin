package com.kolmakova.dto;

public class PricingDTO {

    private Integer id;
    private int trainId;
    private ComfortDTO comfortDTO;
    private int seatsNumber;
    private double price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public ComfortDTO getComfortDTO() {
        return comfortDTO;
    }

    public void setComfortDTO(ComfortDTO comfortDTO) {
        this.comfortDTO = comfortDTO;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
