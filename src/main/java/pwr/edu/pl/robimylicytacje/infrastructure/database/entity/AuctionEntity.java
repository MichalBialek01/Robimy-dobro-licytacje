package pwr.edu.pl.robimylicytacje.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "AUCTION")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuctionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "start_date_time", nullable = false)
    private LocalDateTime startDateTime;
    @Column(name = "end_date_time", nullable = false)
    private LocalDateTime endDateTime;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "photo_url")
    private String photoUrl;
    @Column(name = "city")
    private String city;
    @Column(name = "base_price")
    private BigDecimal basePrice;
    @Column(name = "link_to_thread")
    private String linkToThread;
    @Column(name = "win_price")
    private BigDecimal winPrice;

    @Column(name = "winner_id")
    private long winnderId;
    @Column(name = "moderator_id")
    private long moderatorId;
    @Column(name = "supplier_id")
    private long supplierId;

}
