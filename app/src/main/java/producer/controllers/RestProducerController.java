package producer.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import producer.data.Item;
import producer.service.ItemService;

import java.util.Optional;

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

    @PutMapping(consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "Update an existing Item.")
    public ResponseEntity<Item> updateProducerData(@RequestBody Item item) {
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("{itemID}")
    @ApiOperation(value = "Find an Item by it's id.")
    public ResponseEntity<Item> getProducerData(@PathVariable Long itemID) {
        Optional<Item> itemOptional = itemService.findItem(itemID);

        if (itemOptional.isPresent()) {
            return new ResponseEntity<>(itemOptional.get(), HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
