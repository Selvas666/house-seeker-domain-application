package pl.kala.houseseekerdomain.domain.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfiguration {
    @Bean
    GetAllHousesMapper getAllHousesMapper(){
        return new GetAllHousesMapper();
    }

    @Bean
    HouseMapper houseMapper(){
        return new HouseMapper();
    }

    @Bean
    LocalityMapper localityMapper(){
        return new LocalityMapper();
    }

}
