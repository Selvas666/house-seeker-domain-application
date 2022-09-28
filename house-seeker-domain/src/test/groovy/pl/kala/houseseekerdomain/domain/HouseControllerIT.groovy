package pl.kala.houseseekerdomain.domain

import io.restassured.RestAssured
import io.restassured.http.ContentType
import io.restassured.specification.RequestSpecification
import lombok.extern.slf4j.Slf4j
import org.springframework.http.HttpStatus
import pl.kala.houseseekerdomain.IntegrationSpecificationConfiguration

@Slf4j
class HouseControllerIT extends IntegrationSpecificationConfiguration {

    def "I can save a house"() {
        given: "A proper config"
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

    def "I can get 2 houses I can save"() {
        given: "A proper config"
        RequestSpecification saveRequest = RestAssured.given()
        saveRequest.basePath("/api/house/save")
        RequestSpecification getRequest = RestAssured.given()
        getRequest.basePath("/api/house/all")
        and: "A minimum possible body for saving a house"
        File body = new File("src/test/resources/json/request/saveHouseMin.json")
        saveRequest.contentType(ContentType.JSON)
        saveRequest.body(body)
        when: "We save 2 houses and try to get them all"
        saveRequest.post()
        saveRequest.post()
        def result = getRequest.get()
        then: "We get a list of two houses in return"
        result.statusCode() == HttpStatus.OK.value()
        result.body().jsonPath().getList("houses").size() == 2
    }

    def "I can call GetAllHouses on empty data base"(){
        given: "A proper config"
        RequestSpecification getRequest = RestAssured.given()
        getRequest.basePath("/api/house/all")
        when: "We tray to get all houses"
        def result = getRequest.get()
        then: "The result returns no content"
        result.statusCode() == HttpStatus.NO_CONTENT.value()
    }
}
