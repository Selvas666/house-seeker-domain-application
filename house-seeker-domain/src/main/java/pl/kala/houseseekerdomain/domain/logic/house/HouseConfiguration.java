package pl.kala.houseseekerdomain.domain.logic.house;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.kala.houseseekerdomain.database.repository.HouseRepository;
import pl.kala.houseseekerdomain.database.repository.LocalityRepository;
import pl.kala.houseseekerdomain.domain.mapping.request.CreateHouseMapper;
import pl.kala.houseseekerdomain.domain.mapping.response.GetAllHousesMapper;
import pl.kala.houseseekerdomain.domain.mapping.response.GetHouseMapper;
import pl.kala.houseseekerdomain.domain.mapping.response.GetLocalityMapper;

@Configuration
public class HouseConfiguration {
    @Bean
    HouseApi houseApi(HouseRepository houseRepository,
                      LocalityRepository localityRepository,
                      GetHouseMapper getHouseMapper,
                      GetLocalityMapper getLocalityMapper,
                      GetAllHousesMapper getAllHousesMapper,
                      CreateHouseMapper createHouseMapper) {
        return new HouseFacade(houseRepository,
                localityRepository,
                getHouseMapper,
                getLocalityMapper,
                getAllHousesMapper,
                createHouseMapper);
    }
}
