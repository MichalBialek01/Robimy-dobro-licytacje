package pwr.edu.pl.robimylicytacje.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pwr.edu.pl.robimylicytacje.infrastructure.database.entity.AuctionParticipantEntity;

public interface AuctionParticipantJpaRepository extends JpaRepository<Long, AuctionParticipantEntity> {
}
