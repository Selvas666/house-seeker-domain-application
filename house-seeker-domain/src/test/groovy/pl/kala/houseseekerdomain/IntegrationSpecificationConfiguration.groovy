package pl.kala.houseseekerdomain

import io.restassured.RestAssured
import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.test.context.TestPropertySource
import spock.lang.Shared
import spock.lang.Specification

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-integration.properties")
class IntegrationSpecificationConfiguration extends Specification{
    protected static final Logger log = LoggerFactory.getLogger("RestAssuredTestsLogger")



//    def setupSpec() {
//        log.info("The port of gold is:${port.toString()}")
//        RestAssured.port = port
//    }

}
