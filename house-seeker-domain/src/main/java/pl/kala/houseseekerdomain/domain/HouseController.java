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

    //TODO: add request/response logging
    private final HouseApi houseApi;

    @PostMapping("/save")
    ResponseEntity<Void> saveHouse(@RequestBody CreateHouseRequest request) {
        //TODO: add return type
        houseApi.saveHouse(request)
                .onFailure(ex -> log.error("Failed to save house - {}", ex.getMessage()));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    ResponseEntity<GetAllHousesResponse> getAllHouses(@RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "10") int size) {
        GetAllHousesResponse response = houseApi.getAllHouses(page, size)
                .onFailure(ex -> log.error("Failed to get all houses - {}", ex.getMessage()))
                .get();
        if (response.getTotalElements() == 0) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(response);
    }

}
