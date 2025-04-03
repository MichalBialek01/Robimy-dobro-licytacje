package pwr.edu.pl.robimylicytacje.infrastructure.database.repository.mapper;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GoogleSheetMapperTest {
    private final GoogleSheetMapper mapper = new GoogleSheetMapper();

    @Test
    void shouldMapCsvToAuctionRowDtoList() throws Exception {
        // given
        List<List<Object>> csvData = readCsv("/auction_data.csv");

        // when
        List<GoogleSheetMapper.AuctionRowDto> result = mapper.parseAuctionRow(csvData);

        // then
        assertEquals(2, result.size());

        var first = result.get(0);
        assertEquals("Jan Kowalski", first.moderatorFullName());
        assertEquals("2024-04-10", first.preferredDay());
        assertEquals("Firma XYZ", first.supplierFullName());
        assertEquals("Zabawka", first.title());
        assertEquals("http://example.com", first.threadUrl());
        assertEquals("100", first.basePrice());
        assertEquals("Wrocław", first.city());
        assertEquals("http://example.com/image.jpg", first.photoUrl());
    }

    private List<List<Object>> readCsv(String path) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(path)))) {
            List<List<Object>> rows = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split(",");
                List<Object> row = new ArrayList<>();
                for (String s : split) {
                    row.add(s.trim());
                }
                rows.add(row);
            }
            return rows;
        }
    }
}