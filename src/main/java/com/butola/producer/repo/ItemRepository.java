package com.butola.producer.repo;

import com.butola.producer.data.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    /*@Query("UPDATE Item c SET c.itemDescription = ?2 WHERE c.itemid = ?1")
    int updateItem(Long itemid, String itemDescription);*/

    @Query("select i from Item i where i.itemName = ?1")
    Optional<Item> findByItemName(String itemName);
}
