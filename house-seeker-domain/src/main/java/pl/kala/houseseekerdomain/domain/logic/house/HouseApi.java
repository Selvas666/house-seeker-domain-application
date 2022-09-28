package pl.kala.houseseekerdomain.domain.logic.house;

import io.vavr.control.Try;
import pl.kala.houseseekerdomain.database.model.document.house.House;
import pl.kala.houseseekerdomain.domain.model.request.CreateHouseRequest;
import pl.kala.houseseekerdomain.domain.model.response.GetAllHousesResponse;

public interface HouseApi {
    Try<GetAllHousesResponse> getAllHouses(int page, int size);

    Try<House> saveHouse(CreateHouseRequest createHouseRequest);
}
