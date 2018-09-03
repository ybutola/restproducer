package com.butola.producer.data;


import javax.persistence.*;

/**
 * Created by yogibutola on 8/25/18.
 */
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long itemID;

    @Column(name = "itemname")
    String itemName;

    @Column(name = "itemdescription")
    String itemDescription;

    public Long getItemID() {
        return itemID;
    }

    public void setItemID(Long itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }
}
