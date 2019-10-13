package producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import producer.data.ItemDetail;
import producer.repo.ItemDetailRepository;

import java.util.Optional;

/**
 * Created by yogibutola on 8/25/18.
 */
@Service
public class ItemDetailService {

    @Autowired
    ItemDetailRepository itemDetailRepository;

    public void createItemDetail(ItemDetail itemDetail) {
        itemDetailRepository.save(itemDetail);
    }

    public void deleteItemDetail(ItemDetail itemDetail) {
        itemDetailRepository.delete(itemDetail);
    }

    public Optional<ItemDetail> findItemDetail(Long itemDetailID) {
        return itemDetailRepository.findById(itemDetailID);
    }

    public Iterable<ItemDetail> findItemDetails() {
        return itemDetailRepository.findAll();
    }
}
