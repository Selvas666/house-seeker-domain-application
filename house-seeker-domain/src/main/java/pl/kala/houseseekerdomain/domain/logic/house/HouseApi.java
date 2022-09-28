package pl.kala.houseseekerdomain.domain.logic.house;

import io.vavr.control.Try;
import pl.kala.houseseekerdomain.domain.model.request.CreateHouseRequest;
import pl.kala.houseseekerdomain.domain.model.response.GetAllHousesResponse;
import pl.kala.houseseekerdomain.domain.model.response.dto.GetHouseDto;

public interface HouseApi {
    Try<GetAllHousesResponse> getAllHouses(int page, int size);

    Try<GetHouseDto> saveHouse(CreateHouseRequest createHouseRequest);
}
