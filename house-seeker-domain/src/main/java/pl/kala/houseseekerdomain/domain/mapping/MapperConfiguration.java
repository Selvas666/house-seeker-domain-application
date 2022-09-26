package pl.kala.houseseekerdomain.domain.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.kala.houseseekerdomain.domain.mapping.request.CreateHouseMapper;
import pl.kala.houseseekerdomain.domain.mapping.response.GetAllHousesMapper;
import pl.kala.houseseekerdomain.domain.mapping.response.GetHouseMapper;
import pl.kala.houseseekerdomain.domain.mapping.response.GetLocalityMapper;

@Configuration
public class MapperConfiguration {
    @Bean
    GetAllHousesMapper getAllHousesMapper() {
        return new GetAllHousesMapper();
    }

    @Bean
    GetHouseMapper getHouseMapper() {
        return new GetHouseMapper();
    }

    @Bean
    GetLocalityMapper getLocalityMapper() {
        return new GetLocalityMapper();
    }

    @Bean
    CreateHouseMapper createHouseMapper() {
        return new CreateHouseMapper();
    }

}
