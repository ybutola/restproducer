package producer.base

import com.butola.producer.RestProducerApplication
import com.butola.producer.controllers.RestProducerController
import com.butola.producer.data.Item
import com.butola.producer.repo.ItemRepository
import io.restassured.module.mockmvc.RestAssuredMockMvc
import org.assertj.core.api.BDDAssertions
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(classes = [RestProducerApplication.class, RestProducerController.class])
class RestConsumerBase extends Specification {

    @Autowired
    ItemRepository itemRepository

    @Autowired
    RestProducerController restProducerController
    /*
     * Autowired instances can't be shared. Workaround to use @Shared variables.
     *
     */

    def setup() {
        RestAssuredMockMvc.standaloneSetup(restProducerController)
    }

    /*
     * Verify that a records has been created.
     */

    def verifyThatRecordIsCreated(Long itemID) {
        Optional<Item> item = itemRepository.findById(itemID)
        BDDAssertions.then(itemID).isEqualTo(item.get().itemID)
    }

    def verifyThatRecordIsCreated(String itemName) {
        Optional<Item> item = itemRepository.findByItemName(itemName)
        BDDAssertions.then(itemName).isEqualTo(item.get().itemName)
    }
    /*
     * Verify that a records has been updated.
     */

    def verifyThatRecordIsUpdated(def itemID, def itemDescription) {
        Optional<Item> item = itemRepository.findById(itemID)
        BDDAssertions.then(itemDescription).isEqualTo(item.get().itemDescription)
    }

    /*
     * Clean the database after all the tests are complete.
     * This helps, specifically in dev environment where you need to run the same tests multiple times.
     */

    def cleanupSpec() {
        //jdbcTemplate.execute("delete * from item")
    }
}
