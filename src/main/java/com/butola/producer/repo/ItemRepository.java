package com.butola.producer.repo;

import com.butola.producer.data.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long>{

   // @Query("UPDATE Item c SET c.itemDescription = :itemDescription WHERE c.itemid = :itemid")
   // int updateItem(@Param("itemid") Long itemid, @Param("itemDescription") String itemDescription);
}
