package pwr.edu.pl.robimylicytacje.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "AUCTION_PARTICIPANT")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
class AuctionParticipantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "bid_date_time", nullable = false)
    @CreationTimestamp
    private LocalDateTime bidDateTime;

    @Column(name = "auction_id", nullable = false)
    private long acutionId;

    @Column(name = "participant_id", nullable = false)
    private long participantId;

}
