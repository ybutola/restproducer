package com.butola.producer.repo;

import com.butola.producer.data.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yogibutola on 8/25/18.
 */
@Repository
public interface ItemRepository extends CrudRepository<Item, Long>{

}
