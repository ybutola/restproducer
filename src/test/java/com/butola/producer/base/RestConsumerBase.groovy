package com.butola.producer.base

import com.butola.producer.RestProducerApplication
import com.butola.producer.controllers.RestProducerController
import io.restassured.module.mockmvc.RestAssuredMockMvc
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.jdbc.core.JdbcTemplate
import spock.lang.Shared
import spock.lang.Specification

import javax.sql.DataSource

@SpringBootTest(classes = RestProducerApplication.class)
class RestConsumerBase extends Specification {
    @Shared
    JdbcTemplate jdbcTemplate

    @Autowired
    DataSource dataSource;

    /*
     * Autowired instances can't be shared. Workaround to use @Shared variables.
     *
     */

    def setupSpec() {
        RestAssuredMockMvc.standaloneSetup(RestProducerController.class)
    //    jdbcTemplate = new JdbcTemplate(dataSource)
    }

    /*
     * Verify that a records has been created.
     */

    def verifyThatRecordIsCreated(def itemID) {
        List results =  jdbcTemplate.queryForList("select * from item where itemID = " + itemID)
        assert results.get(0).get("itemID") == itemID
    }

    /*
     * Verify that a records has been updated.
     */

    def verifyThatRecordIsUpdated(def itemID, def itemDescription) {
        List results = jdbcTemplate.queryForList("select * from item where itemID = " + itemID)
        assert results.get(0).get("itemID") == itemID
        assert results.get(0).get("itemDescription") == itemDescription
    }

    /*
     * Clean the database after all the tests are complete.
     * This helps, specifically in dev environment where you need to run the same tests multiple times.
     */

    def cleanupSpec() {
        jdbcTemplate.execute("delete * from item")
    }
}
