package pl.kala.houseseekerdomain.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.kala.houseseekerdomain.domain.logic.house.HouseApi;
import pl.kala.houseseekerdomain.domain.model.request.CreateHouseRequest;

@Slf4j
@RestController("/api/house")
@RequiredArgsConstructor
public class HouseController {
    private final HouseApi houseApi;

    @PostMapping("/save")
    ResponseEntity<Void> saveHouse(@RequestBody CreateHouseRequest request) {
        houseApi.saveHouse(request)
                .onFailure(ex -> log.error("Failed to save house - {}", ex.getMessage()));

        return ResponseEntity.ok().build();
    }

}
