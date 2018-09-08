package com.butola.producer.base

import com.butola.producer.RestProducerApplication
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import spock.lang.Specification

@SpringBootTest(classes = RestProducerApplication.class)
class SpockTestSpec extends Specification {

    def 'test me'() {
        given:
        def start = 'this is good'

        when:
        start = start.substring(5)

        then:
        start.contains('good')
    }
}
