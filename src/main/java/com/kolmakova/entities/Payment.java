package com.kolmakova.entities;

import javax.persistence.*;

@Table(name = "Payment")
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "train_id")
    private Train train;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passenger_id")
    private com.kolmakova.entities.Passenger passenger;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pricing_id")
    private Pricing pricing;

    @Column(name = "amount")
    private double amount;

    @Column(name = "mark_as_deleted")
    private boolean isDeleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public com.kolmakova.entities.Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(com.kolmakova.entities.Passenger passenger) {
        this.passenger = passenger;
    }

    public Pricing getPricing() {
        return pricing;
    }

    public void setPricing(Pricing pricing) {
        this.pricing = pricing;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
//
//    public static Builder builder(){
//        return new Payment().new Builder();
//    }
//
//    public class Builder {
//
//        private Builder() { }
//
//        public Builder setId(Integer id){
//            Payment.this.id = id;
//            return this;
//        }
//
//        public Builder setTrain(Train train){
//            Payment.this.train = train;
//            return this;
//        }
//
//        public Builder setPassenger(Passenger passenger){
//            Payment.this.passenger = passenger;
//            return this;
//        }
//
//        public Builder setPricing(Pricing pricing){
//            Payment.this.pricing = pricing;
//            return this;
//        }
//
//        public Builder setAmount(Double amount){
//            Payment.this.amount = amount;
//            return this;
//        }
//
//        public Payment build(){
//            return Payment.this;
//        }
//    }
}
