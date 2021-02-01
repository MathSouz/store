package com.lablogic.store.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="products")
public class Product implements Serializable
{
    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true, columnDefinition = "varchar(13) default ''")
    private String code;

    @Column(columnDefinition = "varchar(30)")
    private String name;

    private float cost;

    @Column(columnDefinition = "timestamp default current_timestamp", insertable = false)
    private LocalDateTime dateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
