package pwr.edu.pl.robimylicytacje.infrastructure.database.repository.mapper;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

import static pwr.edu.pl.robimylicytacje.infrastructure.database.Util.GoogleSheetUtils.*;

public class GoogleSheetMapper {

    public record AuctionRowDto(
            String moderatorFullName,
            String preferredDay,
            String supplierFullName,
            String title,
            String threadUrl,
            String basePrice,
            String city,
            String photoUrl
    ) {
    }

    public List<AuctionRowDto> parseAuctionRow(List<List<Object>> rows) {

        if (Objects.isNull(rows) || rows.size() < 2) {
            return Collections.emptyList();
        }

        List<String> header = rows.get(0).stream()
                .map(obj -> obj.toString().trim().replace("\uFEFF", ""))
                .toList();

        int moderatorIndex = header.indexOf(MODERATOR);
        int preferredAuctionDateIndex = header.indexOf(PREFERRED_AUCTION_DATE);
        int listerAuctionIndex = header.indexOf(LISTER);
        int auctionDescriptionAuctionIndex = header.indexOf(AUCTION_DESCRIPTION);
        int auctionTitleIndex = header.indexOf(AUCTION_TITLE);
        int photoUrlIndex = header.indexOf(PHOTO_URL);
        int cityIndex = header.indexOf(CITY);
        int basePrice = header.indexOf(BASE_PRICE);

        List<AuctionRowDto> result = new ArrayList<>();

        for (int i = 1; i < rows.size(); i++) {
            List<Object> row = rows.get(i);
            result.add(new AuctionRowDto(
                    getValue(row, moderatorIndex),
                    getValue(row, preferredAuctionDateIndex),
                    getValue(row, listerAuctionIndex),
                    getValue(row, auctionDescriptionAuctionIndex),
                    getValue(row, auctionTitleIndex),
                    getValue(row, photoUrlIndex),
                    getValue(row, cityIndex),
                    getValue(row, basePrice)
            ));
        }
        return result;
    }

    private String getValue(List<Object> row, int idx) {
        return (idx >= 0 && idx < row.size()) ? row.get(idx).toString().trim() : null;
    }


}
