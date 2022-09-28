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
        given: "A proper request config"
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
        given: "A proper request config"
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

    def "I can call GetAllHouses on empty data base"() {
        given: "A proper request config"
        RequestSpecification getRequest = RestAssured.given()
        getRequest.basePath("/api/house/all")
        when: "We tray to get all houses"
        def result = getRequest.get()
        then: "The result returns no content"
        result.statusCode() == HttpStatus.NO_CONTENT.value()
    }

    def "GetAllHouses request parameters are properly understood and paging is calculated accordingly"() {
        given: "A proper request config"
        RequestSpecification getRequest = RestAssured.given()
        getRequest.basePath("/api/house/all")
        and: "A DB populated with 3 houses"
        def numberOfHouses = 3
        RequestSpecification saveRequest = RestAssured.given()
        saveRequest.basePath("/api/house/save")
        File body = new File("src/test/resources/json/request/saveHouseMin.json")
        saveRequest.contentType(ContentType.JSON)
        saveRequest.body(body)
        for (int i = 1; i <= numberOfHouses; i++) {
            saveRequest.post()
        }
        and: "Request params: page = 1, size = 1"
        def page = 1
        def size = 1
        getRequest.param("page", page)
        getRequest.param("size", size)
        when: "We tray to get all houses"
        def result = getRequest.get()
        then: "The result has: pageNumber = page, totalPages = numberOfHouses, pageSize = size, totalElements = numberOfHouses"
        result.body().jsonPath().get("pageNumber") == page
        result.body().jsonPath().get("totalPages") == numberOfHouses
        result.body().jsonPath().get("pageSize") == size
        result.body().jsonPath().get("totalElements") == numberOfHouses

    }
}
