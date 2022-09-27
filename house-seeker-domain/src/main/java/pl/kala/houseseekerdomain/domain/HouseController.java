package pl.kala.houseseekerdomain.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kala.houseseekerdomain.domain.logic.house.HouseApi;
import pl.kala.houseseekerdomain.domain.model.request.CreateHouseRequest;
import pl.kala.houseseekerdomain.domain.model.response.GetAllHousesResponse;

@Slf4j
@RestController
@RequestMapping("/api/house")
@RequiredArgsConstructor
public class HouseController {
    private final HouseApi houseApi;

    @PostMapping("/save")
    ResponseEntity<Void> saveHouse(@RequestBody CreateHouseRequest request) {
        houseApi.saveHouse(request)
                .onFailure(ex -> log.error("Failed to save house - {}", ex.getMessage()));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    ResponseEntity<GetAllHousesResponse> getAllHouses() {
        GetAllHousesResponse response = houseApi.getAllHouses()
                .onFailure(ex -> log.error("Failed to get all houses - {}", ex.getMessage()))
                .get();
        return ResponseEntity.ok(response);
    }

}
