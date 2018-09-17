package com.butola.producer.base

import com.butola.producer.RestProducerApplication
import com.butola.producer.controllers.RestProducerController
import io.restassured.module.mockmvc.RestAssuredMockMvc
import org.assertj.core.api.BDDAssertions
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.jdbc.core.JdbcTemplate
import spock.lang.Specification

import javax.sql.DataSource

@SpringBootTest(classes = [RestProducerApplication.class, RestProducerController.class])
class RestConsumerBase extends Specification {
    @Autowired
    JdbcTemplate jdbcTemplate

    @Autowired
    DataSource dataSource;

    @Autowired
    RestProducerController restProducerController
    /*
     * Autowired instances can't be shared. Workaround to use @Shared variables.
     *
     */

    def setup() {
        RestAssuredMockMvc.standaloneSetup(restProducerController)
        //   jdbcTemplate = new JdbcTemplate(dataSource)
    }

    /*
     * Verify that a records has been created.
     */

    def verifyThatRecordIsCreated(def itemID) {
        List results = jdbcTemplate.queryForList("select * from item where itemID = " + itemID)
        BDDAssertions.then(itemID).isEqualTo(results.get(0).get("itemID"))
    }

    /*
     * Verify that a records has been updated.
     */

    def verifyThatRecordIsUpdated(def itemID, def itemDescription) {
        List results = jdbcTemplate.queryForList("select * from item where itemID = " + itemID)
        BDDAssertions.then(itemID).isEqualTo(results.get(0).get("itemID"))
        BDDAssertions.then(itemDescription).isEqualTo(results.get(0).get("itemDescription"))
    }

    /*
     * Clean the database after all the tests are complete.
     * This helps, specifically in dev environment where you need to run the same tests multiple times.
     */

    def cleanupSpec() {
        //jdbcTemplate.execute("delete * from item")
    }
}
