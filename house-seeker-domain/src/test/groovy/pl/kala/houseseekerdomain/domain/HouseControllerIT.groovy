package pl.kala.houseseekerdomain.domain

import io.restassured.RestAssured
import io.restassured.http.ContentType
import io.restassured.specification.RequestSpecification
import lombok.extern.slf4j.Slf4j
import org.springframework.boot.test.web.server.LocalServerPort
import pl.kala.houseseekerdomain.IntegrationSpecificationConfiguration

@Slf4j
class HouseControllerIT extends IntegrationSpecificationConfiguration{
    @LocalServerPort
    int port
    def"I cant save a house" () {
        given: "a minimum possible body for saving a house"
        log.info("The port of silver is:${port.toString()}")
        RestAssured.port = port
        RequestSpecification request = RestAssured.given()
        request.basePath("/api/house/save")
        File body = new File("src/test/resources/json/request/saveHouseMin.json")

        request.contentType(ContentType.JSON)
        request.body(body)


        when:"we send that"
        def result = request.post()

        then:"it should get positive response xd"
        result.statusCode() == 200

    }
}
