package producer.base


import org.springframework.boot.test.context.SpringBootTest
import producer.RestProducerApplication
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
