package pl.kala.houseseekerdomain.domain.logic.house;


import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import pl.kala.houseseekerdomain.database.model.document.house.House;
import pl.kala.houseseekerdomain.database.model.document.locality.Locality;
import pl.kala.houseseekerdomain.database.repository.HouseRepository;
import pl.kala.houseseekerdomain.database.repository.LocalityRepository;
import pl.kala.houseseekerdomain.domain.mapping.request.CreateHouseMapper;
import pl.kala.houseseekerdomain.domain.mapping.response.GetAllHousesMapper;
import pl.kala.houseseekerdomain.domain.mapping.response.GetHouseMapper;
import pl.kala.houseseekerdomain.domain.mapping.response.GetLocalityMapper;
import pl.kala.houseseekerdomain.domain.model.request.CreateHouseRequest;
import pl.kala.houseseekerdomain.domain.model.response.GetAllHousesResponse;
import pl.kala.houseseekerdomain.domain.model.response.dto.GetHouseDto;
import pl.kala.houseseekerdomain.domain.model.response.dto.GetLocalityDto;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class HouseFacade implements HouseApi {

    private final HouseRepository houseRepository;

    private final LocalityRepository localityRepository;

    private final GetHouseMapper getHouseMapper;

    private final GetLocalityMapper getLocalityMapper;

    private final GetAllHousesMapper getAllHousesMapper;

    private final CreateHouseMapper createHouseMapper;

    @Override
    public Try<GetAllHousesResponse> getAllHouses(int page, int size) {
        return Try.of(() -> {
            Page<House> pagedHouses = houseRepository.findAll(PageRequest.of(page, size));
            List<GetHouseDto> getHouseDtoList = pagedHouses.stream().map(n -> {
                GetLocalityDto getLocalityDto = getLocalityMapper
                        .convert(localityRepository.findById(n.getLocalityId())
                                .orElseThrow(() -> new RuntimeException("Unknown locality id: " + n.getLocalityId())));
                return getHouseMapper.convert(GetHouseMapper.Source.of(n, getLocalityDto));
            }).toList();
            return getAllHousesMapper.convert(GetAllHousesMapper.Source.of(pagedHouses, getHouseDtoList));
        });
    }

    @Override
    public Try<GetHouseDto> saveHouse(CreateHouseRequest createHouseRequest) {
        return Try.of(() -> {
            String localityName = createHouseRequest.getLocality();
            Locality locality = localityRepository.findLocalityByNameIgnoreCase(localityName)
                    .getOrElse(() -> localityRepository
                            .save(Locality.builder()
                                    .name(localityName)
                                    .entryDate(LocalDateTime.now())
                                    .build()));
            House savedHouse = houseRepository.save(createHouseMapper.convert(CreateHouseMapper.Source.of(createHouseRequest, locality)));
            GetLocalityDto getLocalityDto = getLocalityMapper.convert(locality);
            return getHouseMapper.convert(GetHouseMapper.Source.of(savedHouse, getLocalityDto));
        });
    }
}
