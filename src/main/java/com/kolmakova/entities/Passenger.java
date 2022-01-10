package com.kolmakova.entities;

import com.kolmakova.types.DocumentType;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Table(name = "Passenger")
@Entity
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "passenger_name")
    private String name;

    private String surname;
    private String sex;

    @Column(name = "birth_date")
    private Date birthDate;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "document_type_id")
    private Document documentType;

    @Column(name = "document_series")
    private String documentSeries;

    @OneToMany(fetch = FetchType.LAZY)
//    @Where(clause = "mark_as_deleted = false")
    @JoinColumn(name = "passenger_id")
    private List<Payment> paymentList;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setDocumentType(Document documentType) {
        this.documentType = documentType;
    }

    public void setDocumentSeries(String documentSeries) {
        this.documentSeries = documentSeries;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getSex() {
        return sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Document getDocumentType() {
        return documentType;
    }

    public String getDocumentSeries() {
        return documentSeries;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }
}
