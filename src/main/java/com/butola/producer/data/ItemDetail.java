package com.butola.producer.data;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by yogibutola on 8/25/18.
 */
@Entity
public class ItemDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long itemDetailID;

    @Column
    Long itemID;

    @Column
    String productionUnit;

    @Column
    Date productionDate;

    public Long getItemDetailID() {
        return itemDetailID;
    }

    public void setItemDetailID(Long itemDetailID) {
        this.itemDetailID = itemDetailID;
    }

    public Long getItemID() {
        return itemID;
    }

    public void setItemID(Long itemID) {
        this.itemID = itemID;
    }

    public String getProductionUnit() {
        return productionUnit;
    }

    public void setProductionUnit(String productionUnit) {
        this.productionUnit = productionUnit;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }
}
