package pwr.edu.pl.robimylicytacje.infrastructure.database.repository.api;

import pwr.edu.pl.robimylicytacje.infrastructure.database.repository.mapper.GoogleSheetMapper;

import java.util.List;

public interface GoogleSheetRepository {

    /**
     * @return lista wierszy aukcji jako DTO
     */
    List<GoogleSheetMapper.AuctionRowDto> fetchAuctionRows();
}