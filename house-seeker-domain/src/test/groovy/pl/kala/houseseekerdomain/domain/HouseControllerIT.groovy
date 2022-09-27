package pl.kala.houseseekerdomain.domain

import io.restassured.RestAssured
import io.restassured.http.ContentType
import io.restassured.specification.RequestSpecification
import lombok.extern.slf4j.Slf4j
import org.springframework.boot.test.web.server.LocalServerPort
import pl.kala.houseseekerdomain.IntegrationSpecificationConfiguration

@Slf4j
class HouseControllerIT extends IntegrationSpecificationConfiguration {
    @LocalServerPort
    int port

    def "I can save a house"() {
        given: "A proper config"
        RestAssured.port = port
        RequestSpecification request = RestAssured.given()
        request.basePath("/api/house/save")
        and: "A minimum possible body for saving a house"
        File body = new File("src/test/resources/json/request/saveHouseMin.json")
        request.contentType(ContentType.JSON)
        request.body(body)
        when: "We send that request"
        def result = request.post()
        then: "It should return code 200"
        result.statusCode() == 200
    }
}
