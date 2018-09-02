package com.butola.producer.controller;

import com.butola.producer.data.Item;
import com.butola.producer.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yogibutola on 8/25/18.
 */
@RestController(value = "/restproducer")
@Api(value = "Producer", description = "Example project for contract test demo.")
public class RestProducerController {

    @Autowired
    ItemService itemService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "Create an Item object.")
    public void addProducerData(@RequestBody Item item) {
        itemService.createItem(new Item());
    }

/*    @GetMapping
    @ApiOperation(value = "Create an Item object.")
    public String getProducerData() {
        return "Hello There !!";
    }*/


}
