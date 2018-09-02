package com.butola.producer.service;

import com.butola.producer.data.Item;
import com.butola.producer.repo.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by yogibutola on 8/25/18.
 */
@Service
public class ItemService {
    @Autowired
    ItemRepository itemRepository;

    public void createItem(Item item) {
        itemRepository.save(item);
    }

    public void deleteItem(Item item) {
        itemRepository.delete(item);
    }

    public Optional<Item> findItem(Long itemID) {
        return itemRepository.findById(itemID);
    }

    public Iterable<Item> findItems() {
        return itemRepository.findAll();
    }
}
