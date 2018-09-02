package com.butola.producer.data;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Created by yogibutola on 8/25/18.
 */
@Entity
public class Item {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    Long itemID;

    @Column
    String name;

    @Column
    String itemDescription;

    public Long getItemID() {
        return itemID;
    }

    public void setItemID(Long itemID) {
        this.itemID = itemID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }
}
