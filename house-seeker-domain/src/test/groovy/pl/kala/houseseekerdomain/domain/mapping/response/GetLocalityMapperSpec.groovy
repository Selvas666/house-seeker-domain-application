package pl.kala.houseseekerdomain.domain.mapping.response

import pl.kala.houseseekerdomain.UnitSpecificationConfiguration
import pl.kala.houseseekerdomain.database.model.document.locality.Locality
import pl.kala.houseseekerdomain.domain.model.response.dto.GetLocalityDto

import java.time.LocalDateTime

class GetLocalityMapperSpec extends UnitSpecificationConfiguration {
    GetLocalityMapper mapper = new GetLocalityMapper()

    def "GetLocalityMapper mapping a minimal Locality object with only id and name fields filled in"() {
        given: "A Locality object with only id and name fields filled in"
        Locality locality = Locality.builder()
                .id("1")
                .name("Wrocław")
                .entryDate(LocalDateTime.now())
                .build()
        when: "The mapper maps the object"
        GetLocalityDto result = mapper.convert(locality)
        then: "We get a GetLocalityDto object with only name field filled in"
        result.getName() == locality.getName()
        result.getVoivodeship() == null
        result.getDistanceFromHome() == null
        result.getDistanceFromRailStation() == null
    }

    def "GetLocalityMapper mapping a  Locality object with all the fields filled in"() {
        given: "A Locality object with all the fields filled in"
        Locality locality = Locality.random()
        when: "The mapper maps the object"
        GetLocalityDto result = mapper.convert(locality)
        then: "We get a GetLocalityDto object with all the fields properly filled in"
        result.getName() == locality.getName()
        result.getVoivodeship() == locality.getVoivodship().getLabel()
        result.getDistanceFromHome() == locality.getDistanceFromHome()
        result.getDistanceFromRailStation() == locality.getDistanceFromRailStation()
    }

}
