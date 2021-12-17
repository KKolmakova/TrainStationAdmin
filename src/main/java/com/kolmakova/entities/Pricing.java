package com.kolmakova.entities;

import javax.persistence.*;

@Table(name = "Pricing")
@Entity
public class Pricing {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "train_id")
    private int trainId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "comfort_type_id")
    private Comfort comfortType;

    @Column(name = "seats_number")
    private int seatsNumber;

    @Column(name = "price")
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

    public Comfort getComfortType() {
        return comfortType;
    }

    public void setComfortType(Comfort comfortType) {
        this.comfortType = comfortType;
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
