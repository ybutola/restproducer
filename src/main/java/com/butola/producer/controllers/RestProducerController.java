package com.butola.producer.controllers;

import com.butola.producer.data.Item;
import com.butola.producer.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Item> addProducerData(@RequestBody Item item) {
        return new ResponseEntity<>(itemService.createItem(item), HttpStatus.CREATED);
    }

    @GetMapping("{itemID}")
    @ApiOperation(value = "Find an Item by it's id.")
    public ResponseEntity<Item> getProducerData(@PathVariable Long itemID) {
        Optional<Item> itemOptional = itemService.findItem(itemID);
        if (itemOptional.get() != null) {
            return new ResponseEntity<>(itemOptional.get(), HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
