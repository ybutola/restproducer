package com.butola.producer.controllers;

import com.butola.producer.data.Item;
import com.butola.producer.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created by yogibutola on 8/25/18.
 */
@RestController
@RequestMapping("/restproducer")
@Api(value = "Producer", description = "Example project for contract test demo.")
public class RestProducerController {

    @Autowired
    ItemService itemService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "Create an Item object.")
    public void addProducerData(@RequestBody Item item) {
        itemService.createItem(item);
    }

    @GetMapping("{itemID}")
    @ApiOperation(value = "Find an Item by it's id.")
    public Optional<Item> getProducerData(@PathVariable Long itemID) {
        return itemService.findItem(itemID);
    }
}
