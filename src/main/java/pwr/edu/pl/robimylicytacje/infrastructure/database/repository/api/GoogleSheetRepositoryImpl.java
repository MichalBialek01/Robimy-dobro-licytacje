package pwr.edu.pl.robimylicytacje.infrastructure.database.repository.api;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import pwr.edu.pl.robimylicytacje.infrastructure.database.repository.mapper.GoogleSheetMapper;

import java.io.InputStream;
import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor
public class GoogleSheetRepositoryImpl implements GoogleSheetRepository {

    private final GoogleSheetMapper googleSheetMapper = new GoogleSheetMapper();

    private static final String APPLICATION_NAME = "RobimyLicytacje";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String SPREADSHEET_ID = "YOUR_SHEET_ID_HERE"; // TODO - trzeba podać google sheet ID
    private static final String RANGE = "Arkusz1!A1:H"; // TODO - Zakres do pobrania

    private Sheets sheetsService;

    @PostConstruct
    private void init() {
        try {
            InputStream credentialsStream = getClass().getResourceAsStream("/credentials.json");
            GoogleCredential credential = GoogleCredential.fromStream(credentialsStream)
                    .createScoped(List.of("https://www.googleapis.com/auth/spreadsheets.readonly"));

            sheetsService = new Sheets.Builder(
                    GoogleNetHttpTransport.newTrustedTransport(),
                    JSON_FACTORY,
                    credential
            )
                    .setApplicationName(APPLICATION_NAME)
                    .build();
        } catch (Exception e) {
            log.error("Błąd podczas inicjalizacji Sheets API", e);
        }
    }

    @Override
    public List<GoogleSheetMapper.AuctionRowDto> fetchAuctionRows() {
        try {
            ValueRange response = sheetsService.spreadsheets().values()
                    .get(SPREADSHEET_ID, RANGE)
                    .execute();

            List<List<Object>> values = response.getValues();
            if (values == null || values.isEmpty()) {
                log.warn("Brak danych w arkuszu Google Sheets");
                return List.of();
            }

            return googleSheetMapper.parseAuctionRow(values);
        } catch (Exception e) {
            log.error("Błąd podczas pobierania danych z Google Sheets", e);
            return List.of();
        }
    }
}