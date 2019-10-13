package producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import producer.data.Item;
import producer.repo.ItemRepository;

import java.util.Optional;

/**
 * Created by yogibutola on 8/25/18.
 */
@Service
public class ItemService {
    @Autowired
    ItemRepository itemRepository;

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    /*   public int updateItem(Item item) {
           return itemRepository.updateItem(item.getItemID(), item.getItemDescription());
       }*/
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
