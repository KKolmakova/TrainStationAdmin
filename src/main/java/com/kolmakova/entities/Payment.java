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
    private Passenger passenger;

    @Column(name = "amount")
    private Double amount;

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

    public static Builder builder(){
        return new Payment().new Builder();
    }

    public class Builder {

        private Builder() { }

        public Builder setId(Integer id){
            Payment.this.id = id;
            return this;
        }

        public Builder setTrain(Train train){
            Payment.this.train = train;
            return this;
        }

        public Builder setPassenger(Passenger passenger){
            Payment.this.passenger = passenger;
            return this;
        }

        public Builder setAmount(Double amount){
            Payment.this.amount = amount;
            return this;
        }

        public Payment build(){
            return Payment.this;
        }
    }
}
