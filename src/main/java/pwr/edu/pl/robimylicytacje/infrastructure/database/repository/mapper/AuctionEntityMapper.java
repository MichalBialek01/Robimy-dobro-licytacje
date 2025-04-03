package pwr.edu.pl.robimylicytacje.infrastructure.database.repository.mapper;

import pwr.edu.pl.robimylicytacje.infrastructure.database.entity.AuctionEntity;
import pwr.edu.pl.robimylicytacje.infrastructure.database.entity.ListerEntity;
import pwr.edu.pl.robimylicytacje.infrastructure.database.entity.ModeratorEntity;

import static pwr.edu.pl.robimylicytacje.infrastructure.database.Util.DateUtil.parsePreferredDay;
import static pwr.edu.pl.robimylicytacje.infrastructure.database.Util.MoneyUtil.parsePrice;

public class AuctionEntityMapper {

    public AuctionEntity mapToAuctionEntity(GoogleSheetMapper.AuctionRowDto dto,
                                            ModeratorEntity moderator,
                                            ListerEntity supplier) {

        return AuctionEntity.builder()
                .moderatorId(moderator.getId())
                .supplierId(supplier.getId())
                .description(dto.title())
                .linkToThread(dto.threadUrl())
                .photoUrl(dto.photoUrl())
                .basePrice(parsePrice(dto.basePrice()))
                .city(dto.city())
                .startDateTime(parsePreferredDay(dto.preferredDay()))
                .endDateTime(parsePreferredDay(dto.preferredDay()).plusHours(2))
                .build();
    }

}
