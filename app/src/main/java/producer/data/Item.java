package producer.data;


import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 * Created by yogibutola on 8/25/18.
 */
@Entity
public class Item {

    @ApiModelProperty(notes = "Unique ID of the Item.")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long itemID;

    @ApiModelProperty(notes = "Name of the Item.")
    @Column(name = "itemname")
    String itemName;

    @ApiModelProperty(notes = "Description of the Item.")
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
