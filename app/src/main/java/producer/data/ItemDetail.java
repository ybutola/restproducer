package producer.data;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by yogibutola on 8/25/18.
 */
@Entity
public class ItemDetail {

    @ApiModelProperty(notes = "Unique ID of the Item Detail.")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long itemDetailID;

    @ApiModelProperty(notes = "Item ID of the parent Item.")
    @Column
    Long itemID;

    @ApiModelProperty(notes = "Production Unit of the Item.")
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
