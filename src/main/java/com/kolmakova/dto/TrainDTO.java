package com.kolmakova.dto;

public class TrainDTO {

    private Integer id;
    private int number;
    private String departureTime;
    private String arrivalPlace;
    private String departureDate;

    public void setId(int id) {
        this.id = id;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalPlace(String arrivalPlace) {
        this.arrivalPlace = arrivalPlace;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalPlace() {
        return arrivalPlace;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    @Override
    public String toString() {
        return "TrainDTO{" +
                "id=" + id +
                ", number=" + number +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalPlace='" + arrivalPlace + '\'' +
                ", departureDate='" + departureDate + '\'' +
                '}';
    }
}


